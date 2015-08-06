package com.huiting.xml.picbookdelete.bl;

import java.sql.Timestamp;

import com.huiting.xml.bean.ReqHeadBean;
import com.huiting.xml.picbookdelete.bean.RequestBean;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.picbookdelete.bean.ResponseBean;
import com.huiting.xml.dao.PicBookDao;
import com.huiting.xml.dto.PicBookDto;

public class BLPicbookDelete extends BLBaseAction{
	PicBookDao picBookDao; 
	
	public Object handleXML(RequestBean reqHuiTingBean){
		PicBookDto picBookDto = new PicBookDto();
		
		
		
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			
			picBookDto.setUserID(reqHuiTingBean.getUserID());
			picBookDto.setPicbookID(reqHuiTingBean.getPicbookID());
			picBookDto.setPicbookName(reqHuiTingBean.getPicbookName());
			picBookDto.setPicbookStatus("0");
			picBookDao.updatestatus(picBookDto); 
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			 
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	
	 

	


	public PicBookDao getPicBookDao() {
		return picBookDao;
	}



	public void setPicBookDao(PicBookDao picBookDao) {
		this.picBookDao = picBookDao;
	}
	
}
