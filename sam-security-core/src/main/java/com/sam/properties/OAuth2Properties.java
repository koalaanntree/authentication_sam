package com.sam.properties;

/**
 * @Author: huangxin
 * @Date: Created in 下午2:48 2018/3/7
 * @Description:
 */
public class OAuth2Properties {

    private OAuth2ClientProperties[] clients = {};
    private String jwtSigningKey = "sam";

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }

    public String getJwtSigningKey() {
        return jwtSigningKey;
    }

    public void setJwtSigningKey(String jwtSigningKey) {
        this.jwtSigningKey = jwtSigningKey;
    }
}
