package com.huiting.xml.uploadheadpic.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String UserPic ="";
	private String filepath ="";

	public String getUserPic() {
		return UserPic;
	}

	public void setUserPic(String userPic) {
		UserPic = userPic;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	 
	
	
}
