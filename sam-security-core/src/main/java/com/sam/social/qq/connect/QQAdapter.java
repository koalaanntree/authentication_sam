package com.sam.social.qq.connect;

import com.sam.social.qq.api.QQ;
import com.sam.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @Author: huangxin
 * @Date: Created in 上午9:04 2018/3/2
 * @Description:
 */
public class QQAdapter implements ApiAdapter<QQ> {
    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {

        QQUserInfo userInfo = api.getUserInfo();

        values.setDisplayName(userInfo.getNickname());

        values.setImageUrl(userInfo.getFigureurl_qq_1());

        values.setProfileUrl(null);

        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {



        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {

        // do nothing

    }
}
