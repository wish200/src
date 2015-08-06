package com.huiting.xml.channellistshow.bean;

import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<ChannelListBean> ChannelList = new  ArrayList<ChannelListBean>();

	public ArrayList<ChannelListBean> getChannelList() {
		return ChannelList;
	}

	public void setChannelList(ArrayList<ChannelListBean> channelList) {
		ChannelList = channelList;
	}

	
}
