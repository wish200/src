package com.huiting.xml.uploadheadpic.bl;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


import com.huiting.cache.SystemCache;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.UserBaseInfoDao;
import com.huiting.xml.uploadheadpic.bean.RequestBean;
import com.huiting.xml.uploadheadpic.bean.ResponseBean;

public class BLUploadHeadPic extends BLBaseAction{
	UserBaseInfoDao userBaseInfoDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		String UserID = "";
		String UserPicUrl = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		String error = "UPLOAD_SUCCESS";
		String baseurl = "http://120.132.70.11/:8080/huiting/";
		baseurl = SystemCache.getCache("connection.url");
		Map<String, String> paramMap = new HashMap<String, String>();
		try{
			
			UserID = reqHuiTingBean.getUserID();
			UserPicUrl= baseurl+reqHuiTingBean.getFilepath();
			paramMap.put("UserPic", UserPicUrl);
			paramMap.put("UserID", UserID);
			if(userBaseInfoDao==null){
				userBaseInfoDao = (UserBaseInfoDao)com.huiting.common.SpringBeanFactory.lookup("userBaseInfoDao");
			}
			userBaseInfoDao.updateuserpic(paramMap);
			resHuiTingBean.setUserPicURL(UserPicUrl);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"");
		}catch(Exception e ){
			e.printStackTrace();
			error ="UPLOAD_FAIL";
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		return resHuiTingBean;
	}
	
	public Object handleXMLBackGroundPIC(RequestBean reqHuiTingBean){
		String UserID = "";
		String UserPicUrl = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		String error = "UPLOAD_SUCCESS";
		String baseurl = "http://120.132.70.11/:8080/huiting/";
		baseurl = SystemCache.getCache("connection.url");
		Map<String, String> paramMap = new HashMap<String, String>();
		try{
			UserID = reqHuiTingBean.getUserID();
			UserPicUrl= baseurl+reqHuiTingBean.getFilepath();
			paramMap.put("BackGroundPIC", UserPicUrl);
			paramMap.put("UserID", UserID);
			if(userBaseInfoDao==null){
				userBaseInfoDao = (UserBaseInfoDao)com.huiting.common.SpringBeanFactory.lookup("userBaseInfoDao");
			}
			userBaseInfoDao.updateBackGroundPIC(paramMap);
			resHuiTingBean.setUserPicURL(UserPicUrl);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"");
		}catch(Exception e ){
			e.printStackTrace();
			error ="UPLOAD_FAIL";
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		return resHuiTingBean;
	}


	public UserBaseInfoDao getUserBaseInfoDao() {
		return userBaseInfoDao;
	}

	public void setUserBaseInfoDao(UserBaseInfoDao userBaseInfoDao) {
		this.userBaseInfoDao = userBaseInfoDao;
	}
	
}
