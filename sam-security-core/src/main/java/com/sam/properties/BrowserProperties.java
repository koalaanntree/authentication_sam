package com.sam.properties;

/**
 * @Author: huangxin
 * @Date: Created in 下午1:36 2018/2/28
 * @Description:
 */
public class BrowserProperties {

    private String loginPage = "/sam-signIn.html";

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSecodes = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public int getRememberMeSecodes() {
        return rememberMeSecodes;
    }

    public void setRememberMeSecodes(int rememberMeSecodes) {
        this.rememberMeSecodes = rememberMeSecodes;
    }
}
