package com.huiting.xml.dto;

import java.sql.Timestamp;

public class UserBaseInfoDto {
	private String UserID = "";
	private String Password = "";
	private String NickName = "";
	private String Sex = "";
	private String BirthDay = "";
	private String RealName = "";
	private String PhoneNumber = "";
	private String Weixin = "";
	private String QQ = "";
	private String Mail = "";
	private String Province = "";
	private String City = "";
	private String Description = "";
	private String UserPic = "";
	private String BackGroundPIC = "";
	private Timestamp CreateTime = null;
	 
	
	
	
	
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
	public String getBirthDay() {
		return BirthDay;
	}
	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
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
	public String getUserPic() {
		return UserPic;
	}
	public void setUserPic(String userPic) {
		UserPic = userPic;
	}
	public String getBackGroundPIC() {
		return BackGroundPIC;
	}
	public void setBackGroundPIC(String backGroundPIC) {
		BackGroundPIC = backGroundPIC;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PhoneNumber == null) ? 0 : PhoneNumber.hashCode());
		result = prime * result + ((UserID == null) ? 0 : UserID.hashCode());
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
		UserBaseInfoDto other = (UserBaseInfoDto) obj;
		if (PhoneNumber == null) {
			if (other.PhoneNumber != null)
				return false;
		} else if (!PhoneNumber.equals(other.PhoneNumber))
			return false;
		if (UserID == null) {
			if (other.UserID != null)
				return false;
		} else if (!UserID.equals(other.UserID))
			return false;
		return true;
	}
	
	
	

}
