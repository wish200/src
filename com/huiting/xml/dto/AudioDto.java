package com.huiting.xml.dto;

import java.sql.Timestamp;

public class AudioDto {
	private String AudioID="";
	private String AudioName="";
	private String AudioURL="";
	private String UserID="";
	private String NickName="";
	private String AudioCatalog="";
	private String AudioSource="";
	private Timestamp UploadTime= null;
	private String AudioStatus="";
	private int FlowerCnt=0;
	private String AudioLength="";
	private String AudioContent="";
	private String BackGoundPic="";
	private String ProgramID="";
	private String ProgramURL="";
	
	public String getAudioID() {
		return AudioID;
	}
	public void setAudioID(String audioID) {
		AudioID = audioID;
	}
	public String getAudioName() {
		return AudioName;
	}
	public void setAudioName(String audioName) {
		AudioName = audioName;
	}
	public String getAudioURL() {
		return AudioURL;
	}
	public void setAudioURL(String audioURL) {
		AudioURL = audioURL;
	}
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
	public String getAudioCatalog() {
		return AudioCatalog;
	}
	public void setAudioCatalog(String audioCatalog) {
		AudioCatalog = audioCatalog;
	}
	public String getAudioSource() {
		return AudioSource;
	}
	public void setAudioSource(String audioSource) {
		AudioSource = audioSource;
	}
	public Timestamp getUploadTime() {
		return UploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		UploadTime = uploadTime;
	}
	public String getAudioStatus() {
		return AudioStatus;
	}
	public void setAudioStatus(String audioStatus) {
		AudioStatus = audioStatus;
	}
	public int getFlowerCnt() {
		return FlowerCnt;
	}
	public void setFlowerCnt(int flowerCnt) {
		FlowerCnt = flowerCnt;
	}
	public String getAudioLength() {
		return AudioLength;
	}
	public void setAudioLength(String audioLength) {
		AudioLength = audioLength;
	}
	public String getAudioContent() {
		return AudioContent;
	}
	public void setAudioContent(String audioContent) {
		AudioContent = audioContent;
	}
	public String getBackGoundPic() {
		return BackGoundPic;
	}
	public void setBackGoundPic(String backGoundPic) {
		BackGoundPic = backGoundPic;
	}
	public String getProgramID() {
		return ProgramID;
	}
	public void setProgramID(String programID) {
		ProgramID = programID;
	}
	public String getProgramURL() {
		return ProgramURL;
	}
	public void setProgramURL(String programURL) {
		ProgramURL = programURL;
	}
	
	
	
}
