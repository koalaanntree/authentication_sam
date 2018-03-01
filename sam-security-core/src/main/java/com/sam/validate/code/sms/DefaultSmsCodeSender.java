package com.sam.validate.code.sms;

/**
 * @Author: huangxin
 * @Date: Created in 上午11:27 2018/3/1
 * @Description:
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机"+mobile+"发送短信验证码"+code);
    }
}
