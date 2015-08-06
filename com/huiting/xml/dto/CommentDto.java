package com.huiting.xml.dto;

import java.sql.Timestamp;

public class CommentDto {
	private String CommentID = "";
	private String Modular = "";
	private String BusiID = ""; 
	private String ConcernedUserID = "";
	private String ConcernedNickName = "";
	private Timestamp CommentTime = null;
	private String CommentText = "";
	private String ConcernedUserPic = "";
	private String CommentStatus = "";
	public String getCommentID() {
		return CommentID;
	}
	public void setCommentID(String commentID) {
		CommentID = commentID;
	}
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
	public String getConcernedUserPic() {
		return ConcernedUserPic;
	}
	public void setConcernedUserPic(String concernedUserPic) {
		ConcernedUserPic = concernedUserPic;
	}
	public String getCommentStatus() {
		return CommentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		CommentStatus = commentStatus;
	}
	
	
	 
	
}
