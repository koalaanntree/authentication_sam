package com.sam.logout;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.properties.SecurityProperties;
import com.sam.support.SimpleResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: huangxin
 * @Date: Created in 下午2:09 2018/3/5
 * @Description:
 */
public class SamLogoutSuccessHandler implements LogoutSuccessHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    public SamLogoutSuccessHandler(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

    private String signOutUrl;

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        logger.info("退出成功");
        if (StringUtils.isBlank(signOutUrl)) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        } else {
            response.sendRedirect(signOutUrl);
        }

    }
}
