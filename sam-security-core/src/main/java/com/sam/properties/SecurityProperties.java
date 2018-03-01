package com.sam.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: huangxin
 * @Date: Created in 下午1:36 2018/2/28
 * @Description:
 */
@ConfigurationProperties(prefix = "sam.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

}