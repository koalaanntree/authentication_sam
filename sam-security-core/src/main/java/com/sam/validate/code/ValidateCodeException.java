package com.sam.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author: huangxin
 * @Date: Created in 上午9:17 2018/3/1
 * @Description:
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 6211308747098259295L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
