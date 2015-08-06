package com.huiting.xml.myuserconcernedshow.bean;

import java.util.ArrayList;
import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<ConcernedUserListBean> ConcernedUserList = new ArrayList<ConcernedUserListBean> ();

	public ArrayList<ConcernedUserListBean> getConcernedUserList() {
		return ConcernedUserList;
	}

	public void setConcernedUserList(
			ArrayList<ConcernedUserListBean> concernedUserList) {
		ConcernedUserList = concernedUserList;
	}
	
	
}
