package com.example.demo.model;

import com.example.demo.exception.StudentExceptionEnum;
import com.example.demo.exception.StudentNotFoundException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Response {
	private boolean status = false;
	private String responseCode = "500";
	private String responseMessage = "Internal server error";
	//private StudentExceptionEnum error;
	@JsonIgnore
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data;

	@JsonIgnore
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String authKey;

	@JsonIgnore
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer totalCount;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	


	public static Response buildSuccess(Object data) {
		Response res=new Response();
		res.setStatus(true);
		res.setData(data);
		return res;
	}
	
	public static Response buildFail(String code,String msg) {
		Response res=new Response();
		res.setStatus(false);
		res.setResponseMessage(msg);
		res.setResponseCode(code);
		return res;
	}
	
	public static Response buildFail(StudentExceptionEnum e) {
		Response res=new Response();
		res.setStatus(false);
		res.setResponseMessage(e.getEx());
		res.setResponseCode(e.name());
		return res;
	}
}
