package com.huiting.xml.firstpage.bean;

import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<FirstPicListBean> FirstPicList = new ArrayList<FirstPicListBean> ();

	public ArrayList<FirstPicListBean> getFirstPicList() {
		return FirstPicList;
	}

	public void setFirstPicList(ArrayList<FirstPicListBean> firstPicList) {
		FirstPicList = firstPicList;
	}

	
	
	
	
}
