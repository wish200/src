package com.huiting.xml.uploadheadpic.bean;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	
	private String UserPicURL ="";

	public String getUserPicURL() {
		return UserPicURL;
	}

	public void setUserPicURL(String userPicURL) {
		UserPicURL = userPicURL;
	}

	
	
}
