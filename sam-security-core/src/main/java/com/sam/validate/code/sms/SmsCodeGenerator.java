package com.sam.validate.code.sms;

import com.sam.properties.SecurityProperties;
import com.sam.validate.code.ValidateCode;
import com.sam.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Author: huangxin
 * @Date: Created in 上午10:13 2018/3/1
 * @Description:
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * (non-Javadoc)
     *
     * @see
     * com.sam.validate.code.ValidateCodeGenerator#generate(org.
     * springframework.web.context.request.ServletWebRequest)
     */
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }



}