package com.sam.support;

/**
 * @Author: huangxin
 * @Date: Created in 下午1:25 2018/2/28
 * @Description:
 */
public class SimpleResponse {

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
