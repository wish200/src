package com.huiting.xml.dto;

import java.sql.Timestamp;

public class AlbumDto {
	private String UserID="";
	private String NickName="";
	private String AudioID="";
	private String AudioName="";
	private String AudioURL="";
	private String BackGoundPic="";
	private String AudioContent="";
	private String AudioLength="";
	private Timestamp CreateTime=null ;
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
	public String getBackGoundPic() {
		return BackGoundPic;
	}
	public void setBackGoundPic(String backGoundPic) {
		BackGoundPic = backGoundPic;
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
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	
	
}
