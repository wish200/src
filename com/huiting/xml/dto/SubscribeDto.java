package com.huiting.xml.dto;

import java.sql.Timestamp;

public class SubscribeDto {
	private String ChannelID ="";
	private String UserID ="";
	private String Status ="";
	private Timestamp SubscribeTime = null;
	public String getChannelID() {
		return ChannelID;
	}
	public void setChannelID(String channelID) {
		ChannelID = channelID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Timestamp getSubscribeTime() {
		return SubscribeTime;
	}
	public void setSubscribeTime(Timestamp subscribeTime) {
		SubscribeTime = subscribeTime;
	}


	
	
	
	
}
