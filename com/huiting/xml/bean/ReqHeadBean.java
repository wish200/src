package com.huiting.xml.bean;

import java.sql.Timestamp;

public class ReqHeadBean {
	private String RequestType ="";
	private String UUID ="";
	private Timestamp SendTime = null;
	private String UserID = "";
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
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
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	
	
	
}
