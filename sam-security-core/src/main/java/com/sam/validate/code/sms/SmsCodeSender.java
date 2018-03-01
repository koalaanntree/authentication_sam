package com.sam.validate.code.sms;

/**
 * @Author: huangxin
 * @Date: Created in 上午11:26 2018/3/1
 * @Description:
 */
public interface SmsCodeSender {
    void send(String mobile, String code);
}
