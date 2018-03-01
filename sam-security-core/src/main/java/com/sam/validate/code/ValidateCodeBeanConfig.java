package com.sam.validate.code;

import com.sam.properties.SecurityProperties;
import com.sam.validate.code.sms.DefaultSmsCodeSender;
import com.sam.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: huangxin
 * @Date: Created in 上午10:17 2018/3/1
 * @Description:
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")//初始化的时候会先找是否有这个bean。
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)//初始化的时候会先找是否有这个bean。
    public SmsCodeSender SmsCodeSender() {
        return new DefaultSmsCodeSender();
    }

}
