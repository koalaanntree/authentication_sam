package com.sam.authentication;

import com.sam.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @Author: huangxin
 * @Date: Created in 下午3:28 2018/3/1
 * @Description:
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler samAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler samAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(samAuthenticationSuccessHandler)
                .failureHandler(samAuthenticationFailureHandler);
    }

}
