package com.huiting.xml.channellistshow.bean;

public class ChannelListBean {
	private String ChannelID="";
	private String ChannelName="";
	private String ChannelDesc="";
	private int ProgramCnt=0;
	private String IsSubscribe="";
	private String ChannelPic="";
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
	
	public int getProgramCnt() {
		return ProgramCnt;
	}
	public void setProgramCnt(int programCnt) {
		ProgramCnt = programCnt;
	}
	public String getIsSubscribe() {
		return IsSubscribe;
	}
	public void setIsSubscribe(String isSubscribe) {
		IsSubscribe = isSubscribe;
	}
	public String getChannelPic() {
		return ChannelPic;
	}
	public void setChannelPic(String channelPic) {
		ChannelPic = channelPic;
	}
	
	
}
