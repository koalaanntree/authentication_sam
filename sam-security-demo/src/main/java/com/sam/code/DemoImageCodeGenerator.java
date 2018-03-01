package com.sam.code;

import com.sam.validate.code.image.ImageCode;
import com.sam.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Author: huangxin
 * @Date: Created in 上午10:24 2018/3/1
 * @Description: 以增量的方式适应变化
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
