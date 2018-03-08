package com.sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangxin
 * @Date: Created in 上午9:02 2018/3/8
 * @Description:
 */
@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SSOClient2Application {

    @GetMapping("/user")
    public Authentication user(Authentication user) {
        return user;
    }


    public static void main(String[] args) {
        SpringApplication.run(SSOClient2Application.class, args);
    }


}
