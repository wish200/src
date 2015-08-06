package com.huiting.xml.audiopublish.bean;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private String UserID = "";
	private String AudioId = "";
	private String AudioURL = "";
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getAudioId() {
		return AudioId;
	}
	public void setAudioId(String audioId) {
		AudioId = audioId;
	}
	public String getAudioURL() {
		return AudioURL;
	}
	public void setAudioURL(String audioURL) {
		AudioURL = audioURL;
	}
	
	
}
