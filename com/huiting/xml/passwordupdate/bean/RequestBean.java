package com.huiting.xml.passwordupdate.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String Password ="";
	private String UserID ="";
	private String OldPassword ="";
	
	

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getOldPassword() {
		return OldPassword;
	}

	public void setOldPassword(String oldPassword) {
		OldPassword = oldPassword;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	 
	 
	
}
