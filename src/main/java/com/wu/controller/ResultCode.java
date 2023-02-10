package com.wu.controller;

public enum ResultCode {
    SUCESS(200,"成功"),
    LOGIN_ERROR(2002,"账号或者密码错误");
    private Integer code;
    private String message;
    ResultCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    public Integer getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }
}
