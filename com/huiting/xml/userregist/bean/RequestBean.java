package com.huiting.xml.userregist.bean;

import com.huiting.xml.bean.ReqHeadBean;;

public class RequestBean extends ReqHeadBean{
	private String PhoneNumber ="";
	private String Password ="";
	private String MScode ="";
	private String SourceType ="";
	
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
	public String getMScode() {
		return MScode;
	}
	public void setMScode(String mScode) {
		MScode = mScode;
	}
	public String getSourceType() {
		return SourceType;
	}
	public void setSourceType(String sourceType) {
		SourceType = sourceType;
	}
	
	
}
