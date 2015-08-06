package com.huiting.xml.huibenshow.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.HuibenDao;
import com.huiting.xml.dto.HuibenDto;
import com.huiting.xml.huibenshow.bean.HuibenListBean;
import com.huiting.xml.huibenshow.bean.RequestBean;
import com.huiting.xml.huibenshow.bean.ResponseBean;

public class BLHuibenShow   extends BLBaseAction{
	 HuibenDao huibenDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		String error = "";
		String userID="";
		ResponseBean resHuiTingBean = new ResponseBean();
		
		List<HuibenListBean> huibenList = new ArrayList<HuibenListBean>();
		HuibenDto huibenDto = new HuibenDto();
		try{
			
			if(!"".equals(reqHuiTingBean.getUserID())&&reqHuiTingBean.getUserID()!=null){
				huibenDto.setUserID(reqHuiTingBean.getUserID());
				huibenList = huibenDao.queryHuibenShow(huibenDto,reqHuiTingBean.getPage()*10,10 );
			}else{
				huibenList = huibenDao.queryHuibenShow(huibenDto,reqHuiTingBean.getPage()*10,10 );
			}
			
			resHuiTingBean.setHuibenList((ArrayList<HuibenListBean>)huibenList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}

	public HuibenDao getHuibenDao() {
		return huibenDao;
	}

	public void setHuibenDao(HuibenDao huibenDao) {
		this.huibenDao = huibenDao;
	}
	
	 

	
}
