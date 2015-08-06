package com.huiting.xml.dto;

import java.sql.Timestamp;

public class XmlDto {
	private String RequestType ="";
	private String ResponseCode ="";
	private String ErrorMessage ="";
	private String UUID ="";
	private Timestamp SendTime = null;
	private Timestamp CreateTime = null;
	private String HttpHead ="";
	private String Xml ="";
	
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	public String getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public Timestamp getSendTime() {
		return SendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		SendTime = sendTime;
	}
	public String getXml() {
		return Xml;
	}
	public void setXml(String xml) {
		Xml = xml;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
	public String getHttpHead() {
		return HttpHead;
	}
	public void setHttpHead(String httpHead) {
		HttpHead = httpHead;
	}
	
	
	
}
