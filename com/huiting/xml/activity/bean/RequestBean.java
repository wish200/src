package com.huiting.xml.activity.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	
	private String ActivityName ="";
	private String ActivityType ="";
	private String ActivityDESC ="";
	private String filepath ="";
	public String getActivityName() {
		return ActivityName;
	}
	public void setActivityName(String activityName) {
		ActivityName = activityName;
	}
	public String getActivityType() {
		return ActivityType;
	}
	public void setActivityType(String activityType) {
		ActivityType = activityType;
	}
	public String getActivityDESC() {
		return ActivityDESC;
	}
	public void setActivityDESC(String activityDESC) {
		ActivityDESC = activityDESC;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	} 
	
	
	
	
	 
	
}
