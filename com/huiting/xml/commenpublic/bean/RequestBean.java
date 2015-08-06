package com.huiting.xml.commenpublic.bean;

import java.sql.Timestamp;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String Modular ="";
	private String BusiID ="";
	private String ConcernedUserID ="";
	private String ConcernedNickName ="";
	private String ConcernedUserPicUrl ="";
	private Timestamp CommentTime = null;
	private String CommentText ="";
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
	
	public String getConcernedNickName() {
		return ConcernedNickName;
	}
	public void setConcernedNickName(String concernedNickName) {
		ConcernedNickName = concernedNickName;
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
