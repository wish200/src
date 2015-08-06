package com.huiting.xml.dto;

import java.sql.Timestamp;

public class PicBookDto {
	private String PicbookID = "";
	private String PicbookName = "";
	private String PicbookURL = "";
	private String UserID = "";
	private String NickName = "";
	private String PicCatalog = ""; 
	private String PicScene = "";
	private String PicBookSource = "";
	private Timestamp UploadTime = null;
	private String PicbookStatus = "";
	private int FlowerCnt = 0;
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
	public String getPicCatalog() {
		return PicCatalog;
	}
	public void setPicCatalog(String picCatalog) {
		PicCatalog = picCatalog;
	}
	public String getPicScene() {
		return PicScene;
	}
	public void setPicScene(String picScene) {
		PicScene = picScene;
	}
	public String getPicBookSource() {
		return PicBookSource;
	}
	public void setPicBookSource(String picBookSource) {
		PicBookSource = picBookSource;
	}
	public Timestamp getUploadTime() {
		return UploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		UploadTime = uploadTime;
	}
	public String getPicbookStatus() {
		return PicbookStatus;
	}
	public void setPicbookStatus(String picbookStatus) {
		PicbookStatus = picbookStatus;
	}
	public int getFlowerCnt() {
		return FlowerCnt;
	}
	public void setFlowerCnt(int flowerCnt) {
		FlowerCnt = flowerCnt;
	}
	 
	
	
}
