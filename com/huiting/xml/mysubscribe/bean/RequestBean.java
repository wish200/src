package com.huiting.xml.mysubscribe.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	
	private String NickName ="";
	private int Page=0;

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public int getPage() {
		return Page;
	}

	public void setPage(int page) {
		Page = page;
	}

	
	
	
	
}
