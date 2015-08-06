package com.huiting.xml.dto;

import java.sql.Timestamp;

public class DownDto {
	private String ProgramID ="";
	private String ProgramName ="";
	private String ProgramURL ="";
	private String ProgramPic ="";
	private String UserID ="";
	private String NickName ="";
	private Timestamp DownLoadTime = null;
	private String ProgramSize ="";
	public String getProgramID() {
		return ProgramID;
	}
	public void setProgramID(String programID) {
		ProgramID = programID;
	}
	public String getProgramName() {
		return ProgramName;
	}
	public void setProgramName(String programName) {
		ProgramName = programName;
	}
	public String getProgramURL() {
		return ProgramURL;
	}
	public void setProgramURL(String programURL) {
		ProgramURL = programURL;
	}
	public String getProgramPic() {
		return ProgramPic;
	}
	public void setProgramPic(String programPic) {
		ProgramPic = programPic;
	}
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
	public Timestamp getDownLoadTime() {
		return DownLoadTime;
	}
	public void setDownLoadTime(Timestamp downLoadTime) {
		DownLoadTime = downLoadTime;
	}
	public String getProgramSize() {
		return ProgramSize;
	}
	public void setProgramSize(String programSize) {
		ProgramSize = programSize;
	}
	
	
	
}
