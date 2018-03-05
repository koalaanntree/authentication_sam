package com.sam.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @Author: huangxin
 * @Date: Created in 上午11:12 2018/3/3
 * @Description:
 */
public class WeixinProperties extends SocialProperties {

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
     */
    private String providerId = "weixin";

    /**
     * @return the providerId
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * @param providerId the providerId to set
     */
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }


}