package com.huiting.xml.userregist.bean;

import com.huiting.xml.bean.ResHeadBean;;

public class ResponseBean extends ResHeadBean{
	
	private String UserID ="";
	private String Password = "";
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
}
