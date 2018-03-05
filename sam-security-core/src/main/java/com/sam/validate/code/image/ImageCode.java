package com.sam.validate.code.image;

import com.sam.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author: huangxin
 * @Date: Created in 上午8:54 2018/3/1
 * @Description:
 */
public class ImageCode extends ValidateCode {

    private static final long serialVersionUID = 7484944717558604944L;
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code,expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code,expireTime);
        this.image = image;
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
