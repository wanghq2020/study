package com.cq.whq.common;


import com.alibaba.fastjson.JSON;

/**
 * @author Lisa
 * @version 1.0
 * @date 2020/2/13 15:01
 */
public class Response{
	
	public static String Res_Json_Type = "json";
	
	public static Response success() {
		return success(ResponseEnums.SUCCESS.value, null, null);
	}

	public static Response success(Object data) {
		return success(ResponseEnums.SUCCESS.value, Res_Json_Type, data);
	}

	public static Response success(String type, Object data) {
		return success(ResponseEnums.SUCCESS.value, type, data);
	}

	public static Response success(String msg,String type,Object data){
		Response model = new Response();
		model.setStatus(true);
		model.setMsg(msg);
		model.setType(type);
		model.setData(data);
		return model;
	}

	public static Response error() {
		return error(ResponseEnums.ERROR.code, ResponseEnums.ERROR.value);
	}
	
	public static Response error(ResponseEnums enums) {
		return error(enums.code, enums.value);
	}

	public static Response error(String code,String msg){
		Response model = new Response();
		model.setStatus(false);
		model.setErrorCode(code);
		model.setMsg(msg);
		return model;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	private boolean status;
	

	private String errorCode;
	

	private String type;
	

	private String msg;
	

	private Object data;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
