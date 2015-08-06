package com.huiting.xml.audiopublish.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String UserID ="";
	private String NickName ="";
	private String AudioName ="";
	private String AudioSource ="";
	private String AudioLength ="";
	private String AudioContent ="";
	private String filepath  ="";
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getAudioName() {
		return AudioName;
	}
	public void setAudioName(String audioName) {
		AudioName = audioName;
	}
	public String getAudioSource() {
		return AudioSource;
	}
	public void setAudioSource(String audioSource) {
		AudioSource = audioSource;
	}
	public String getAudioContent() {
		return AudioContent;
	}
	public void setAudioContent(String audioContent) {
		AudioContent = audioContent;
	}
	public String getAudioLength() {
		return AudioLength;
	}
	public void setAudioLength(String audioLength) {
		AudioLength = audioLength;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}



	
	 
	
}
