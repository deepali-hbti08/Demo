package com.example.demo.exception;

public class StudentNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private String code;
	private String msg;
	private StudentExceptionEnum error;
	
	public StudentNotFoundException(StudentExceptionEnum en) {
		super(en.getEx());
		//this.code=en.name();
		//this.msg=en.getEx();
		this.error=en;
	}
	
	public StudentNotFoundException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public StudentNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public StudentExceptionEnum getError() {
		return error;
	}

	public void setError(StudentExceptionEnum error) {
		this.error = error;
	}
	
	

	
	
	
}
