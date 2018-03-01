package com.sam.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: huangxin
 * @Date: Created in 上午10:12 2018/3/1
 * @Description:
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
