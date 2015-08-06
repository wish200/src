package com.huiting.xml.userconcerned.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	 
	private String ConcernedUserID ="";

	public String getConcernedUserID() {
		return ConcernedUserID;
	}

	public void setConcernedUserID(String concernedUserID) {
		ConcernedUserID = concernedUserID;
	}

	 
	 
	
}
