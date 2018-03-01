package com.sam.properties;

/**
 * @Author: huangxin
 * @Date: Created in 上午9:49 2018/3/1
 * @Description:
 */
public class ImageCodeProperties extends SmsCodeProperties{

    public ImageCodeProperties() {
        setLength(4);
    }

    private int width = 67;
    private int height = 23;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
