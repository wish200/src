package com.huiting.xml.mystore.bean;





import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<ActivityListBean> ActivityList = new  ArrayList<ActivityListBean>();

	public ArrayList<ActivityListBean> getActivityList() {
		return ActivityList;
	}

	public void setActivityList(ArrayList<ActivityListBean> activityList) {
		ActivityList = activityList;
	}

	

	
	
	
	
	
	
}
