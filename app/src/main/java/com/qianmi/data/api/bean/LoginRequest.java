package com.qianmi.data.api.bean;

/**
 * Created by wv on 2015/8/19.
 */
public class LoginRequest {

    public String username;
    public String password;

    public LoginRequest() {

    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
