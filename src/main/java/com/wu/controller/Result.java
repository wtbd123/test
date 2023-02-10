package com.wu.controller;

import java.io.Serializable;

public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;
    public Result(ResultCode resultCode,Object data){
        this.code=resultCode.getCode();
        this.message=resultCode.getMessage();
        this.data=data;
    }
}
