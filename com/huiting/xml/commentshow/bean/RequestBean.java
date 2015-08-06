package com.huiting.xml.commentshow.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	 
	private String Modular =""; 
	private String BusiID = "";
	private int Page = 0;
	public String getModular() {
		return Modular;
	}
	public void setModular(String modular) {
		Modular = modular;
	}
	public String getBusiID() {
		return BusiID;
	}
	public void setBusiID(String busiID) {
		BusiID = busiID;
	}
	public int getPage() {
		return Page;
	}
	public void setPage(int page) {
		Page = page;
	}
	
	
	
}
