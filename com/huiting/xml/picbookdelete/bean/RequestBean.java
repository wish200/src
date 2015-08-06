package com.huiting.xml.picbookdelete.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String PicbookName ="";
	private String PicbookID ="";
	private String UserID ="";

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getPicbookName() {
		return PicbookName;
	}
	public void setPicbookName(String picbookName) {
		PicbookName = picbookName;
	}
	public String getPicbookID() {
		return PicbookID;
	}
	public void setPicbookID(String picbookID) {
		PicbookID = picbookID;
	} 
	
	
	
	
	 
	
}
