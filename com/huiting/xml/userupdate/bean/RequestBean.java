package com.huiting.xml.userupdate.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String UserID ="";
	private String NickName ="";
	private String Sex ="";
	private String BirthDay ="";
	private String RealName ="";
	private String PhoneNumber ="";
	private String Weixin ="";
	private String QQ ="";
	private String Mail ="";
	private String Province ="";
	private String City ="";
	private String Description ="";
	
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	
	public String getRealName() {
		return RealName;
	}

	public void setRealName(String realName) {
		RealName = realName;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getWeixin() {
		return Weixin;
	}

	public void setWeixin(String weixin) {
		Weixin = weixin;
	}

	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	public String getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}
	
	 
	
}
