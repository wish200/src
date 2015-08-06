package com.huiting.xml.majorpageshow.bean;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private String UserID = "";
	private String UserNick = "";
	private String Description = "";
	private String UserPicUrl = "";
	private String BackGroundPICURL = "";
	private int AttentionUserCnt = 0;
	private int SubscribeChnlCnt = 0;
	private int FansCnt = 0;
	private int FlowerCnt = 0;
	
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserNick() {
		return UserNick;
	}
	public void setUserNick(String userNick) {
		UserNick = userNick;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUserPicUrl() {
		return UserPicUrl;
	}
	public void setUserPicUrl(String userPicUrl) {
		UserPicUrl = userPicUrl;
	}
	public int getAttentionUserCnt() {
		return AttentionUserCnt;
	}
	public void setAttentionUserCnt(int attentionUserCnt) {
		AttentionUserCnt = attentionUserCnt;
	}
	public int getSubscribeChnlCnt() {
		return SubscribeChnlCnt;
	}
	public void setSubscribeChnlCnt(int subscribeChnlCnt) {
		SubscribeChnlCnt = subscribeChnlCnt;
	}
	public int getFansCnt() {
		return FansCnt;
	}
	public void setFansCnt(int fansCnt) {
		FansCnt = fansCnt;
	}
	public int getFlowerCnt() {
		return FlowerCnt;
	}
	public void setFlowerCnt(int flowerCnt) {
		FlowerCnt = flowerCnt;
	}
	public String getBackGroundPICURL() {
		return BackGroundPICURL;
	}
	public void setBackGroundPICURL(String backGroundPICURL) {
		BackGroundPICURL = backGroundPICURL;
	}

	
	
}
