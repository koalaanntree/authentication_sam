package com.sam.validate.code;

import com.sam.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: huangxin
 * @Date: Created in 上午8:57 2018/3/1
 * @Description:
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
    private SmsCodeSender smsCodeSender;

    /**
     * 图形验证码接口
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /**
         * 根据随机数生成图片
         */
        ImageCode imageCode = (ImageCode) imageCodeGenerator.generate(new ServletWebRequest(request));

        /**
         * 将随机数保存到session中
         */
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);

        /**
         * 将生成的图片写到接口中
         */
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());

    }

    /**
     * 短信验证码接口
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/code/sms")
    public void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {

        /**
         * 根据随机数生成短信验证码
         */
        ValidateCode smsCode = smsCodeGenerator.generate(new ServletWebRequest(request));

        /**
         * 将验证码保存到session中
         */
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,smsCode);

        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");

        /**
         * 发送短信验证码
         */
        smsCodeSender.send(mobile,smsCode.getCode());

    }


}
