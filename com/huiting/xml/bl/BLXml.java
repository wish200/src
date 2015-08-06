package com.huiting.xml.bl;

import java.sql.Timestamp;

import com.huiting.xml.bean.ReqHeadBean;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.dao.XmlDao;
import com.huiting.xml.dto.XmlDto;


public class BLXml {
	
	public BLXml(){
		
	}
	XmlDao xmlDao;
	
	public void save (XmlDto xmlDto) throws Exception{
		
		if(xmlDao==null){
			xmlDao = new XmlDao();
		}
		try{
			xmlDao.insert(xmlDto);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("数据库异常",e);
		}
	}
	
	public XmlDto convertRes (ResHeadBean resHeadBean,String xml){
		XmlDto xmlDto = new XmlDto();
		xmlDto.setRequestType(resHeadBean.getRequestType());
		xmlDto.setResponseCode(resHeadBean.getResponseCode());
		xmlDto.setErrorMessage(resHeadBean.getErrorMessage());
		xmlDto.setUUID(resHeadBean.getUUID());
		xmlDto.setSendTime(resHeadBean.getSendTime());
		xmlDto.setXml(xml);
		return xmlDto;
	}
	
	public XmlDto convertReq (ReqHeadBean reqHeadBean,String xml,String httphead){
		XmlDto xmlDto = new XmlDto();
		xmlDto.setRequestType(reqHeadBean.getRequestType());
		xmlDto.setUUID(reqHeadBean.getUUID());
		xmlDto.setSendTime(reqHeadBean.getSendTime());
		xmlDto.setXml(xml);
		xmlDto.setHttpHead(httphead);
		xmlDto.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		return xmlDto;
	}

	public XmlDao getXmlDao() {
		return xmlDao;
	}

	public void setXmlDao(XmlDao xmlDao) {
		this.xmlDao = xmlDao;
	}
	
	
	
	
}
