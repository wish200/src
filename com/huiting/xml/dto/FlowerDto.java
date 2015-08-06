package com.huiting.xml.dto;

import java.sql.Timestamp;

public class FlowerDto {
	private String Modular ="";
	private String BusiID ="";
	private String UserID ="";
	private String NickName ="";
	private int FlowerCnt = 0;
	private Timestamp CommenTime = null;
	public String getModular() {
		return Modular;
	}
	public void setModular(String modular) {
		Modular = modular;
	}
	public String getBusiID() {
		return BusiID;
	}
	public void setBusiID(String busiID) {
		BusiID = busiID;
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
	public int getFlowerCnt() {
		return FlowerCnt;
	}
	public void setFlowerCnt(int flowerCnt) {
		FlowerCnt = flowerCnt;
	}
	public Timestamp getCommenTime() {
		return CommenTime;
	}
	public void setCommenTime(Timestamp commenTime) {
		CommenTime = commenTime;
	}
	
	 
	
	
}
