package com.sam.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @Author: huangxin
 * @Date: Created in 上午11:09 2018/3/6
 * @Description:
 */
public interface SocialAuthenticationFilterPostProcessor {
    void process(SocialAuthenticationFilter socialAuthenticationFilter);
}
