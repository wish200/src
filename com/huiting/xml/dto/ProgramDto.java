package com.huiting.xml.dto;

import java.sql.Timestamp;

public class ProgramDto {
	private String ProgramID = "";
	private String ChannelID = "";
	private String ProgramName = "";
	private String ProgramURL = "";
	private String Duration = "";
	private String ProgramPic = "";
	private int PlayCnt = 0;
	private int FlowerCnt = 0;
	private int Sort = 0;
	private Timestamp LoadTime = null;
	private String Description = "";
	private String Status = "";
	public String getProgramID() {
		return ProgramID;
	}
	public void setProgramID(String programID) {
		ProgramID = programID;
	}
	public String getChannelID() {
		return ChannelID;
	}
	public void setChannelID(String channelID) {
		ChannelID = channelID;
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
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	public String getProgramPic() {
		return ProgramPic;
	}
	public void setProgramPic(String programPic) {
		ProgramPic = programPic;
	}
	public int getPlayCnt() {
		return PlayCnt;
	}
	public void setPlayCnt(int playCnt) {
		PlayCnt = playCnt;
	}
	public int getFlowerCnt() {
		return FlowerCnt;
	}
	public void setFlowerCnt(int flowerCnt) {
		FlowerCnt = flowerCnt;
	}
	public int getSort() {
		return Sort;
	}
	public void setSort(int sort) {
		Sort = sort;
	}
	public Timestamp getLoadTime() {
		return LoadTime;
	}
	public void setLoadTime(Timestamp loadTime) {
		LoadTime = loadTime;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	
}
