package com.huiting.xml.pichuibenshow.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.PicHuibenDao;
import com.huiting.xml.dto.PicHuibenDto;
import com.huiting.xml.pichuibenshow.bean.RequestBean;
import com.huiting.xml.pichuibenshow.bean.HuibenListBean;
import com.huiting.xml.pichuibenshow.bean.ResponseBean;

public class BLPicHuibenShow   extends BLBaseAction{
	PicHuibenDao picHuibenDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		String error = "";
		String userID="";
		ResponseBean resHuiTingBean = new ResponseBean();
		
		List<HuibenListBean> huibenList = new ArrayList<HuibenListBean>();
		PicHuibenDto picHuibenDto = new PicHuibenDto();
		try{
			if(!"".equals(reqHuiTingBean.getUserID())&&reqHuiTingBean.getUserID()!=null){
				picHuibenDto.setUserID(reqHuiTingBean.getUserID());
				huibenList = picHuibenDao.queryHuibenShow(picHuibenDto,reqHuiTingBean.getPage()*countperpage,countperpage );
			}else{
				huibenList = picHuibenDao.queryHuibenShow(picHuibenDto,reqHuiTingBean.getPage()*10,10 );
			}
			
			resHuiTingBean.setHuibenList((ArrayList<HuibenListBean>)huibenList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}

	public PicHuibenDao getPicHuibenDao() {
		return picHuibenDao;
	}

	public void setPicHuibenDao(PicHuibenDao picHuibenDao) {
		this.picHuibenDao = picHuibenDao;
	}

	
	 

	
}
