package com.sam.social.weixin.api;

/**
 * @Author: huangxin
 * @Date: Created in 上午11:17 2018/3/3
 * @Description:
 */
public interface Weixin {

    /* (non-Javadoc)
     * @see com.ymt.pz365.framework.security.social.api.SocialUserProfileService#getUserProfile(java.lang.String)
     */
    WeixinUserInfo getUserInfo(String openId);

}
