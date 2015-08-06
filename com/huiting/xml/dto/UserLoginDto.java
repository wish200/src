package com.huiting.xml.dto;

import java.sql.Timestamp;

public class UserLoginDto {
	private String UserID ="";
	private Timestamp LoginTime =null;
	private Timestamp LogoutTime= null;
	private String IP ="";
	private String Address ="";
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public Timestamp getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		LoginTime = loginTime;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Timestamp getLogoutTime() {
		return LogoutTime;
	}
	public void setLogoutTime(Timestamp logoutTime) {
		LogoutTime = logoutTime;
	}
	
	

}
