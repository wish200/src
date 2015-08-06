package com.huiting.xml.audiohuibenshow.bean;

import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<HuibenListBean> HuibenList = new  ArrayList<HuibenListBean>();

	public ArrayList<HuibenListBean> getHuibenList() {
		return HuibenList;
	}

	public void setHuibenList(ArrayList<HuibenListBean> huibenList) {
		HuibenList = huibenList;
	}
	
}
