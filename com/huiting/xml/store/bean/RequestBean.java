package com.huiting.xml.store.bean;





import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	
	private String UserID="";
	private String ActivityID="";
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getActivityID() {
		return ActivityID;
	}
	public void setActivityID(String activityID) {
		ActivityID = activityID;
	}
	
	
	
	
	
	
}
