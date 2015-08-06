package com.huiting.xml.picbookshow.bean;

import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<PicbookListBean> PicbookList = new  ArrayList<PicbookListBean>();

	public ArrayList<PicbookListBean> getPicbookList() {
		return PicbookList;
	}

	public void setPicbookList(ArrayList<PicbookListBean> picbookList) {
		PicbookList = picbookList;
	}
	
	
	
	
	
	
}
