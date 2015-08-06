package com.huiting.xml.bean;

import java.sql.Timestamp;

public class ResHeadBean {
	private String RequestType ="";
	private String ResponseCode ="";
	private String ErrorMessage ="";
	private String UUID ="";
	private Timestamp SendTime = null;
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	public String getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public Timestamp getSendTime() {
		return SendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		SendTime = sendTime;
	}
	
	
	
	
}
