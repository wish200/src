package com.huiting.xml.dto;

import java.sql.Timestamp;

public class AudioHuibenDto {
	private String HuibenID = "";
	private String PicbookID = "";
	private String PicbookName = "";
	private String PicbookURL = "";
	private String PicScene = "";
	private String AudioID = "";
	private String AudioName = "";
	private String AudioURL = "";
	private String AudioLength = "";
	private String AudioContent = "";
	private String UserID = "";
	private String NickName = "";
	private String UserPic = "";
	private int FlowerCnt = 0;
	private String Status = "";
	private int CommentCnt = 0;
	private Timestamp CreateTime = null;
	
	
	public String getHuibenID() {
		return HuibenID;
	}
	public void setHuibenID(String huibenID) {
		HuibenID = huibenID;
	}
	public String getPicbookID() {
		return PicbookID;
	}
	public void setPicbookID(String picbookID) {
		PicbookID = picbookID;
	}
	public String getPicbookName() {
		return PicbookName;
	}
	public void setPicbookName(String picbookName) {
		PicbookName = picbookName;
	}
	public String getPicbookURL() {
		return PicbookURL;
	}
	public void setPicbookURL(String picbookURL) {
		PicbookURL = picbookURL;
	}
	public String getPicScene() {
		return PicScene;
	}
	public void setPicScene(String picScene) {
		PicScene = picScene;
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
	public String getUserPic() {
		return UserPic;
	}
	public void setUserPic(String userPic) {
		UserPic = userPic;
	}
	public int getFlowerCnt() {
		return FlowerCnt;
	}
	public void setFlowerCnt(int flowerCnt) {
		FlowerCnt = flowerCnt;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public int getCommentCnt() {
		return CommentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		CommentCnt = commentCnt;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
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
	
}
