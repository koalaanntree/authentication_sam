package com.sam.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @Author: huangxin
 * @Date: Created in 上午10:53 2018/3/5
 * @Description:
 */
public class SamExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {
    public SamExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }


    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(), event.getResponse());
    }


    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
