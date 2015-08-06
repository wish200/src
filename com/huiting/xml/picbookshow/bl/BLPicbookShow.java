package com.huiting.xml.picbookshow.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.picbookshow.bean.PicbookListBean;
import com.huiting.xml.picbookshow.bean.RequestBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.picbookshow.bean.ResponseBean;
import com.huiting.xml.dao.PicBookDao;

public class BLPicbookShow   extends BLBaseAction{
	 PicBookDao picBookDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		String error = "";
		String userID="";
		ResponseBean resHuiTingBean = new ResponseBean();
		
		List<PicbookListBean> picbookList = new ArrayList<PicbookListBean>();
		
		try{
			if(!"".equals(reqHuiTingBean.getUserID())&&reqHuiTingBean.getUserID()!=null){
				picbookList = picBookDao.queryListByUserID(reqHuiTingBean.getUserID(),reqHuiTingBean.getPage()*10,10 );
			}else{
				picbookList = picBookDao.queryList(reqHuiTingBean.getPage()*10,10 );
			}
			
			resHuiTingBean.setPicbookList((ArrayList<PicbookListBean>)picbookList);
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
