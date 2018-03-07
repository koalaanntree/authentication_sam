package com.sam;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import com.sam.social.SamSpringSocialConfigure;

/**
 * @Author: huangxin
 * @Date: Created in 下午1:41 2018/3/7
 * @Description:
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.equals(beanName, "samSocialSecurityConfig")) {
            SamSpringSocialConfigure configurer = (SamSpringSocialConfigure) bean;
            configurer.signupUrl("/social/signUp");
            return configurer;
        }
        return bean;
    }

}
