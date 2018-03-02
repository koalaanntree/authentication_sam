package com.sam.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @Author: huangxin
 * @Date: Created in 上午10:16 2018/3/2
 * @Description:
 */
public class SamSpringSocialConfigure extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public SamSpringSocialConfigure(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {

        SocialAuthenticationFilter filter = (SocialAuthenticationFilter)super.postProcess( object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T)filter;
    }
}
