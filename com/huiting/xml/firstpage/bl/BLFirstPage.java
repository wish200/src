package com.huiting.xml.firstpage.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.firstpage.bean.RequestBean;
import com.huiting.xml.firstpage.bean.FirstPicListBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.FirstPageDao;
import com.huiting.xml.firstpage.bean.ResponseBean;

public class BLFirstPage  extends BLBaseAction {
	 FirstPageDao firstPageDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		
		String userID="";
		String error = "";
		List<FirstPicListBean> UrlList = new ArrayList<FirstPicListBean>();
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			userID = reqHuiTingBean.getUserID();
			UrlList =firstPageDao.selectByStatus("1");
			resHuiTingBean.setFirstPicList((ArrayList<FirstPicListBean>)UrlList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	
	 

	public FirstPageDao getFirstPageDao() {
		return firstPageDao;
	}



	public void setFirstPageDao(FirstPageDao firstPageDao) {
		this.firstPageDao = firstPageDao;
	}
	
}
