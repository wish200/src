package com.huiting.xml.dto;

import java.sql.Timestamp;

public class FirstPageDto {
	private int  ID = 0;
	private String PicUrl ="";
	private String Status ="";
	private Timestamp CreateTime = null;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	
	 
	
	
}
