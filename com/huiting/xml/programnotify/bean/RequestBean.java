package com.huiting.xml.programnotify.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String ChannelID ="";
	private int Page = 0;
	public String getChannelID() {
		return ChannelID;
	}
	public void setChannelID(String channelID) {
		ChannelID = channelID;
	}
	public int getPage() {
		return Page;
	}
	public void setPage(int page) {
		Page = page;
	}
	
	
}
