package com.huiting.xml.dto;

import java.sql.Timestamp;

public class SMSVerifyCodeDto {
	private String SourceType = "";
	private String PhoneNumber = "";
	private String UserID = "";
	private String SmsCode = "";
	private Timestamp CreateTime = null;
	private Timestamp VerifyTime = null;
	public String getSourceType() {
		return SourceType;
	}
	public void setSourceType(String sourceType) {
		SourceType = sourceType;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getSmsCode() {
		return SmsCode;
	}
	public void setSmsCode(String smsCode) {
		SmsCode = smsCode;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	public Timestamp getVerifyTime() {
		return VerifyTime;
	}
	public void setVerifyTime(Timestamp verifyTime) {
		VerifyTime = verifyTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((PhoneNumber == null) ? 0 : PhoneNumber.hashCode());
		result = prime * result + ((SmsCode == null) ? 0 : SmsCode.hashCode());
		result = prime * result
				+ ((SourceType == null) ? 0 : SourceType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SMSVerifyCodeDto other = (SMSVerifyCodeDto) obj;
		if (PhoneNumber == null) {
			if (other.PhoneNumber != null)
				return false;
		} else if (!PhoneNumber.equals(other.PhoneNumber))
			return false;
		if (SmsCode == null) {
			if (other.SmsCode != null)
				return false;
		} else if (!SmsCode.equals(other.SmsCode))
			return false;
		if (SourceType == null) {
			if (other.SourceType != null)
				return false;
		} else if (!SourceType.equals(other.SourceType))
			return false;
		return true;
	}
 

	
	
	
}
