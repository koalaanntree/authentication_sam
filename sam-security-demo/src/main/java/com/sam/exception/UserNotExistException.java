package com.sam.exception;

/**
 * @Author: huangxin
 * @Date: Created in 下午3:11 2018/2/26
 * @Description:
 */
public class UserNotExistException extends RuntimeException {

    private static final long serialVersionUID = -2919726340885386445L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
//        throw new RuntimeException("user not exist1");
    }

}
