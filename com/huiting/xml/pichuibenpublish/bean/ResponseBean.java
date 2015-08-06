package com.huiting.xml.pichuibenpublish.bean;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private String UserID = "";
	private String PicbookId = "";
	private String PicbookURL = "";
	private String HuibenID = "";
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getPicbookId() {
		return PicbookId;
	}
	public void setPicbookId(String picbookId) {
		PicbookId = picbookId;
	}
	public String getPicbookURL() {
		return PicbookURL;
	}
	public void setPicbookURL(String picbookURL) {
		PicbookURL = picbookURL;
	}
	public String getHuibenID() {
		return HuibenID;
	}
	public void setHuibenID(String huibenID) {
		HuibenID = huibenID;
	}


	
	
	
}
