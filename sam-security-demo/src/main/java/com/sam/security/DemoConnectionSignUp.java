package com.sam.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @Author: huangxin
 * @Date: Created in 下午2:56 2018/3/2
 * @Description:
 */
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {
    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户信息，默认创建用户，并且返回用户唯一标志

        return connection.getDisplayName();
    }
}
