package com.sam.security;

import com.sam.authorize.AuthorizeConfigManager;
import com.sam.authorize.AuthorizeConfigProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @Author: huangxin
 * @Date: Created in 上午11:09 2018/3/8
 * @Description:
 */
@Component
public class DemoAuthorizeConfigProvider implements AuthorizeConfigProvider {
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config
                .antMatchers("/user","/demo.html")
                .hasRole("ADMIN");
    }
}
