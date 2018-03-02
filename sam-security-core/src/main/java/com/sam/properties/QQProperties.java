package com.sam.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @Author: huangxin
 * @Date: Created in 上午9:34 2018/3/2
 * @Description:
 */
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
