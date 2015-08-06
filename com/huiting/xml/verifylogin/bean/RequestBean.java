package com.huiting.xml.verifylogin.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String PhoneNumber ="";
	private String SourceType ="";
	private String MSCode ="";
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	public String getMSCode() {
		return MSCode;
	}
	public void setMSCode(String mSCode) {
		MSCode = mSCode;
	}
	public String getSourceType() {
		return SourceType;
	}
	public void setSourceType(String sourceType) {
		SourceType = sourceType;
	} 
	
	
	 
	
}
