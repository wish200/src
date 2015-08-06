package com.huiting.xml.msverify.bean;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	
	private String MSCode = "";
	private String SourceType = "";
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
