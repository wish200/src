package com.huiting.xml.commentshow.bean;

import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<CommentListBean> CommentList = new ArrayList<CommentListBean>();

	public ArrayList<CommentListBean> getCommentList() {
		return CommentList;
	}

	public void setCommentList(ArrayList<CommentListBean> commentList) {
		CommentList = commentList;
	}
	
	
}
