package com.huiting.xml.dto;

import java.sql.Timestamp;

public class StoreDto {
	private String UserID="";
	private String ActivityID="";
	private String Status="";
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getActivityID() {
		return ActivityID;
	}
	public void setActivityID(String activityID) {
		ActivityID = activityID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
}
