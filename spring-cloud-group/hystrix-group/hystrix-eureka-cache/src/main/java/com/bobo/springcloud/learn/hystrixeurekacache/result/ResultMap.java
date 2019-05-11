package com.bobo.springcloud.learn.hystrixeurekacache.result;

public class ResultMap {

    private Integer code;
    private String msg;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public ResultMap() {
    }

    public ResultMap(Integer code) {
        this.code = code;
    }

    public ResultMap(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

