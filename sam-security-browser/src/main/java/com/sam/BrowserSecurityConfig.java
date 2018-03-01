package com.sam;

import com.sam.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.sam.validate.code.SmsCodeFilter;
import com.sam.validate.code.ValidateCodeFilter;
import com.sam.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

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
     * 配置token repository读写数据库
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {

        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
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

        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        smsCodeFilter.setAuthenticationFailureHandler(samAuthenticationFailureHandler);
        smsCodeFilter.setSecurityProperties(securityProperties);
        smsCodeFilter.afterPropertiesSet();
//表单登录
        //每个and后是一句话===>配置一类东西
        http    .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(codeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                //自定义登录页面
                .loginPage("/authentication/require")
                //自定义登录请求url
                .loginProcessingUrl("/authentication/form")
                .successHandler(samAuthenticationSuccessHandler)
                .failureHandler(samAuthenticationFailureHandler)
                //记住我的配置
                .and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSecodes())
                .userDetailsService(userDetailsService)
//        http.httpBasic()
                .and()
                .authorizeRequests()
                //配置哪些页面可以访问不需要身份认证
                .antMatchers("/authentication/require", securityProperties.getBrowser().getLoginPage()
                        , "/code/*").permitAll()
                .anyRequest()
                .authenticated()
                //暂时关闭csrf跨站请求伪造
                .and().csrf().disable()
        .apply(smsCodeAuthenticationSecurityConfig)
        ;


    }

}
