package com.huiting.xml.mystore.bean;

import java.sql.Timestamp;

public class ActivityListBean {
	private String ActivityID="";
	private String ActivityName="";
	private String ActivityDESC="";
	private String ActivityPicURL="";
	private Timestamp ActivityTime= null;
	public String getActivityID() {
		return ActivityID;
	}
	public void setActivityID(String activityID) {
		ActivityID = activityID;
	}
	public String getActivityName() {
		return ActivityName;
	}
	public void setActivityName(String activityName) {
		ActivityName = activityName;
	}
	public String getActivityDESC() {
		return ActivityDESC;
	}
	public void setActivityDESC(String activityDESC) {
		ActivityDESC = activityDESC;
	}
	public String getActivityPicURL() {
		return ActivityPicURL;
	}
	public void setActivityPicURL(String activityPicURL) {
		ActivityPicURL = activityPicURL;
	}
	public Timestamp getActivityTime() {
		return ActivityTime;
	}
	public void setActivityTime(Timestamp activityTime) {
		ActivityTime = activityTime;
	}
	 
	 
	
}
