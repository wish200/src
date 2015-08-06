package com.huiting.xml.userlogin.bean;

import com.huiting.xml.bean.ReqHeadBean;;

public class RequestBean extends ReqHeadBean{
	private String PhoneNumber ="";
	private String Password ="";
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	
	
}
