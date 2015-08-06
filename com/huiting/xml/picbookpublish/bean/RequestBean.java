package com.huiting.xml.picbookpublish.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	private String UserID ="";
	private String NickName ="";
	private String UserPic ="";
	private String PicbookName ="";
	
	private String PicScene ="";
	private String PicBookSource ="";
	private String filepath ="";
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getUserPic() {
		return UserPic;
	}
	public void setUserPic(String userPic) {
		UserPic = userPic;
	}
	public String getPicbookName() {
		return PicbookName;
	}
	public void setPicbookName(String picbookName) {
		PicbookName = picbookName;
	}
	public String getPicScene() {
		return PicScene;
	}
	public void setPicScene(String picScene) {
		PicScene = picScene;
	}
	public String getPicBookSource() {
		return PicBookSource;
	}
	public void setPicBookSource(String picBookSource) {
		PicBookSource = picBookSource;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	} 
	
	
	
	 
	
}
