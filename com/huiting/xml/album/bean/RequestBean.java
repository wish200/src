package com.huiting.xml.album.bean;

import com.huiting.xml.bean.ReqHeadBean;

public class RequestBean extends ReqHeadBean{
	
	private String NickName ="";
	private String AudioID ="";
	private String AudioName ="";
	private String AudioURL ="";
	private String BackGoundPic ="";
	private String AudioContent ="";
	private String AudioLength ="";
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getAudioID() {
		return AudioID;
	}
	public void setAudioID(String audioID) {
		AudioID = audioID;
	}
	public String getAudioName() {
		return AudioName;
	}
	public void setAudioName(String audioName) {
		AudioName = audioName;
	}
	public String getAudioURL() {
		return AudioURL;
	}
	public void setAudioURL(String audioURL) {
		AudioURL = audioURL;
	}
	public String getBackGoundPic() {
		return BackGoundPic;
	}
	public void setBackGoundPic(String backGoundPic) {
		BackGoundPic = backGoundPic;
	}
	public String getAudioContent() {
		return AudioContent;
	}
	public void setAudioContent(String audioContent) {
		AudioContent = audioContent;
	}
	public String getAudioLength() {
		return AudioLength;
	}
	public void setAudioLength(String audioLength) {
		AudioLength = audioLength;
	}

	

	
	
	 
	
}
