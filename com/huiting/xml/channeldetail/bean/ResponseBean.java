package com.huiting.xml.channeldetail.bean;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private  String ChannelID="";
	private  String ChannelName="";
	private  String ChannelDesc="";
	private  String BackGroundPicURL="";
	private  String ChannelPicURL="";
	private  int FansCnt=0;
	private  int FlowerCnt=0;
	private  int ProgramCnt=0;
	
	
	public String getChannelID() {
		return ChannelID;
	}
	public void setChannelID(String channelID) {
		ChannelID = channelID;
	}
	public String getChannelName() {
		return ChannelName;
	}
	public void setChannelName(String channelName) {
		ChannelName = channelName;
	}
	public String getChannelDesc() {
		return ChannelDesc;
	}
	public void setChannelDesc(String channelDesc) {
		ChannelDesc = channelDesc;
	}
	public String getBackGroundPicURL() {
		return BackGroundPicURL;
	}
	public void setBackGroundPicURL(String backGroundPicURL) {
		BackGroundPicURL = backGroundPicURL;
	}
	public String getChannelPicURL() {
		return ChannelPicURL;
	}
	public void setChannelPicURL(String channelPicURL) {
		ChannelPicURL = channelPicURL;
	}
	public int getFansCnt() {
		return FansCnt;
	}
	public void setFansCnt(int fansCnt) {
		FansCnt = fansCnt;
	}
	public int getFlowerCnt() {
		return FlowerCnt;
	}
	public void setFlowerCnt(int flowerCnt) {
		FlowerCnt = flowerCnt;
	}
	public int getProgramCnt() {
		return ProgramCnt;
	}
	public void setProgramCnt(int programCnt) {
		ProgramCnt = programCnt;
	}
	
	
	
}
