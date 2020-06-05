package com.cq.whq.common;

/**
 * @author Lisa
 * @version 1.0
 * @date 2020/2/13 15:01
 */
public enum ResponseEnums {
	
	SUCCESS("success","成功"),
	ERROR("error","失败"),
	Sys_Exception("sys_exception","系统内部发生异常"),
	Request_Invalid("request_invalid","无效请求"),
	Data_Duplication("data_duplication","数据重复"),
	Request_Param_Invalid("request_param_invalid","请求参数不正确"),
	Access_Invalid("access_invalid","权限不足，请联系管理员开通访问权限。"),
	Not_Found_Data("not_found_data","未找到数据"),
	Data_Format_Error("606","数据格式不正确"),
	Data_Login_Error("607","登录错误次数太多，限制登录，请稍后在试"),
	Data_Login_Fail("608","登录失败"),
	ADD_TASK_FAIL("609","添加任务失败"),
	UPDATE_TASK_FAIL("610","修改任务失败"),
	Request_Param_null("611","必传参数为空"),
	PICTURE_SIZE_ERROR("612","图片大小超过2000kb"),
	NOT_SPLIT_ORDER("613","不能进行拆单")
	;
	
	ResponseEnums(final String code,final String value){
		this.code = code;
		this.value = value;
	}
	
	public String code;
	
	public String value;
	
}
