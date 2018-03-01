package com.sam;

import com.sam.validate.code.ValidateCodeFilter;
import com.sam.validate.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: huangxin
 * @Date: Created in 上午10:07 2018/2/28
 * @Description:
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler samAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler samAuthenticationFailureHandler;

    /**
     * 设置密码加密解密方式
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * http请求配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter codeFilter = new ValidateCodeFilter();
        codeFilter.setAuthenticationFailureHandler(samAuthenticationFailureHandler);
        codeFilter.setSecurityProperties(securityProperties);
        codeFilter.afterPropertiesSet();
//表单登录
        //每个and后是一句话===>配置一类东西
        http
                .addFilterBefore(codeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                //自定义登录页面
                .loginPage("/authentication/require")
                //自定义登录请求url
                .loginProcessingUrl("/authentication/form")
                .successHandler(samAuthenticationSuccessHandler)
                .failureHandler(samAuthenticationFailureHandler)
//        http.httpBasic()
                .and()
                .authorizeRequests()
                //配置哪些页面可以访问不需要身份认证
                .antMatchers("/authentication/require",securityProperties.getBrowser().getLoginPage()
                ,"/code/image").permitAll()
                .anyRequest()
                .authenticated()
                //暂时关闭csrf跨站请求伪造
                .and().csrf().disable()
        ;



    }

}
