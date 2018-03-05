package com.sam.session;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.session.InvalidSessionStrategy;

/**
 * @Author: huangxin
 * @Date: Created in 上午11:26 2018/3/5
 * @Description:
 */
public class SamInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {

    public SamInvalidSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        onSessionInvalid(request, response);
    }

}