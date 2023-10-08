package com.example.demo.exception;

public enum StudentExceptionEnum {
	
	STU_001("Student not found");
	
	private String ex;

	private StudentExceptionEnum(String ex) {
		this.ex = ex;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}

}
