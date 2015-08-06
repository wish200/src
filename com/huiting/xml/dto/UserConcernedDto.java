package com.huiting.xml.dto;

import java.sql.Timestamp;

public class UserConcernedDto {
	private String UserID ="";
	private String ConcernedUserID ="";
	private String Status  = "";
	private Timestamp ConcernedTime = null;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getConcernedUserID() {
		return ConcernedUserID;
	}
	public void setConcernedUserID(String concernedUserID) {
		ConcernedUserID = concernedUserID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Timestamp getConcernedTime() {
		return ConcernedTime;
	}
	public void setConcernedTime(Timestamp concernedTime) {
		ConcernedTime = concernedTime;
	} 
	
	
	
	
	
}
