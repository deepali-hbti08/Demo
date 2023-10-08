package com.example.demo.model;

import java.util.Map;

public class ResultObject {
	
	private Boolean resultStatus = false;

	private String resultMesaage = "Something went wrong!!";

	private Object resultData;

	private Integer resultCode;

	private Map resultMap;

	private Integer count;

	private String authKey;

	public Boolean isResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Boolean resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getResultMesaage() {
		return resultMesaage;
	}

	public void setResultMesaage(String resultMesaage) {
		this.resultMesaage = resultMesaage;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Boolean getResultStatus() {
		return resultStatus;
	}

	public Map getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map resultMap) {
		this.resultMap = resultMap;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	@Override
	public String toString() {
		return "ResultObject{" + "resultStatus=" + resultStatus + ", resultMesaage=" + resultMesaage + ", resultData="
				+ resultData + ", resultCode=" + resultCode + ", resultMap=" + resultMap + ", count=" + count
				+ ", authKey=" + authKey + '}';
	}


}
