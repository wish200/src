package com.huiting.xml.mystore.bl;



import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.ActivityDao;
import com.huiting.xml.dao.StoreDao;
import com.huiting.xml.dto.StoreDto;
import com.huiting.xml.mystore.bean.ActivityListBean;
import com.huiting.xml.mystore.bean.RequestBean;
import com.huiting.xml.mystore.bean.ResponseBean;

public class BLMyStore  extends BLBaseAction{
	StoreDao storeDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		List<ActivityListBean> StoreList = new ArrayList<ActivityListBean>();
		StoreDto storeDto = new StoreDto();
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			storeDto.setUserID(reqHuiTingBean.getUserID());
			StoreList = storeDao.queryStoreList(storeDto,reqHuiTingBean.getPage()*countperpage,countperpage );
			resHuiTingBean.setActivityList((ArrayList<ActivityListBean>)StoreList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}

	public StoreDao getStoreDao() {
		return storeDao;
	}

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	
	  
	
	
}
