package com.huiting.xml.programlist.bean;

import java.sql.Date;

public class ProgramListBean {
	private String ProgramID = "";
	private String ProgramName = "";
	private String Description = "";
	private int PlayCnt = 0;
	private Date LoadDate = null;
	private String ProgramURL = "";
	private String ProgramPic = "";
	
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
	
	

	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
	
	
	public String getProgramPic() {
		return ProgramPic;
	}
	public void setProgramPic(String programPic) {
		ProgramPic = programPic;
	}
	public String getProgramURL() {
		return ProgramURL;
	}
	public void setProgramURL(String programURL) {
		ProgramURL = programURL;
	}
	 
	
}
