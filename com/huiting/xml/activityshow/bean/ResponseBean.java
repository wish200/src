package com.huiting.xml.activityshow.bean;



import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<ActivityShowListBean> ActivityList = new  ArrayList<ActivityShowListBean>();

	public ArrayList<ActivityShowListBean> getActivityList() {
		return ActivityList;
	}

	public void setActivityList(ArrayList<ActivityShowListBean> activityList) {
		ActivityList = activityList;
	}
	
	
}
