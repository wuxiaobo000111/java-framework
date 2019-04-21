package com.bobo.springcloud.feign.feignfileproducer.controller;


import com.alibaba.fastjson.JSON;


public class ResultInfo {

	// the default value of the error code is 0 which represents success
	private int code = 0;

	// if the request is successful,the error message is blank
	private String message = "";

	// return data
	private Object data;

	public ResultInfo() {
		super();
	}
	

	public ResultInfo(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}


	public ResultInfo(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public void success() {
		this.code = 0;
		this.message = "";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultInfo [code=" + code + ", message=" + message + ", data="
				+ JSON.toJSONString(data) + "]";
	}

	public static ResultInfo successResult(){
		return new ResultInfo();
	}

	public static ResultInfo failResult(){
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setCode(500);
		resultInfo.setMessage("服务器错误");
		return resultInfo;
	}

}
