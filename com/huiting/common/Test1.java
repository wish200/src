package com.huiting.common;

import java.sql.Timestamp;

public class Test1 {
	private  String userid="";
	private Timestamp CreateTime = new Timestamp(System.currentTimeMillis());
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Timestamp getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}

	
	
	
}
