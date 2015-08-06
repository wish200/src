package com.huiting.xml.msverify.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String PhoneNumber ="";
	private String SourceType ="";
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getSourceType() {
		return SourceType;
	}
	public void setSourceType(String sourceType) {
		SourceType = sourceType;
	}
	 
	 
	 
	
}
