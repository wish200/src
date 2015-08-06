package com.huiting.xml.programnotify.bean;

import java.sql.Date;

public class ProgramListBean {
	private String ProgramID = "";
	private String ProgramName = "";
	private String Desc = "";
	private int PlayCnt = 0;
	private Date LoadDate = null;
	private String ProgramURL = "";
	private String ProgramPicUrl = "";
	
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
	
	
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public int getPlayCnt() {
		return PlayCnt;
	}
	public void setPlayCnt(int playCnt) {
		PlayCnt = playCnt;
	}
	public Date getLoadDate() {
		return LoadDate;
	}
	public void setLoadDate(Date loadDate) {
		LoadDate = loadDate;
	}
	
	public String getProgramPicUrl() {
		return ProgramPicUrl;
	}
	public void setProgramPicUrl(String programPicUrl) {
		ProgramPicUrl = programPicUrl;
	}
	public String getProgramURL() {
		return ProgramURL;
	}
	public void setProgramURL(String programURL) {
		ProgramURL = programURL;
	}
	 
	
}
