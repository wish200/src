package com.huiting.xml.audioshow.bean;

import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<AudioListBean> AudioList = new  ArrayList<AudioListBean>();

	public ArrayList<AudioListBean> getAudioList() {
		return AudioList;
	}

	public void setAudioList(ArrayList<AudioListBean> audioList) {
		AudioList = audioList;
	}

	
	
	
	
	
	
}
