package com.huiting.xml.huibenshow.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private int Page = 0;
	private String flag ="";

	public int getPage() {
		return Page;
	}

	public void setPage(int page) {
		Page = page;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
	 
	
}
