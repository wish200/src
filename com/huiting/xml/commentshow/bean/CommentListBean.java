package com.huiting.xml.commentshow.bean;

import java.sql.Timestamp;

public class CommentListBean {
	 private String Modular = "";
	 private String BusiID = "";
	 private String ConcernedUserID = "";
	 private String ConcernedNickname = "";
	 private String ConcernedUserPicUrl = "";
	 private Timestamp CommentTime = null;
	 private String CommentText = "";
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
	public String getConcernedUserID() {
		return ConcernedUserID;
	}
	public void setConcernedUserID(String concernedUserID) {
		ConcernedUserID = concernedUserID;
	}
	public String getConcernedNickname() {
		return ConcernedNickname;
	}
	public void setConcernedNickname(String concernedNickname) {
		ConcernedNickname = concernedNickname;
	}
	public String getConcernedUserPicUrl() {
		return ConcernedUserPicUrl;
	}
	public void setConcernedUserPicUrl(String concernedUserPicUrl) {
		ConcernedUserPicUrl = concernedUserPicUrl;
	}
	public Timestamp getCommentTime() {
		return CommentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		CommentTime = commentTime;
	}
	public String getCommentText() {
		return CommentText;
	}
	public void setCommentText(String commentText) {
		CommentText = commentText;
	}
	
}
