package com.huiting.xml.store.bl;


import java.util.HashMap;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.StoreDao;
import com.huiting.xml.dao.UserSummaryDao;
import com.huiting.xml.dto.StoreDto;
import com.huiting.xml.store.bean.RequestBean;
import com.huiting.xml.store.bean.ResponseBean;

public class BLStore  extends BLBaseAction{
	StoreDao storeDao;
	UserSummaryDao userSummaryDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		StoreDto storeDto = new StoreDto();
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			storeDto.setUserID(reqHuiTingBean.getUserID());
			storeDto.setActivityID(reqHuiTingBean.getActivityID());
			storeDto.setStatus("1");
			
			storeDao.insert(storeDto);
			
			try{
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("UserID", reqHuiTingBean.getUserID());
				map.put("cnt", "1");
				map.put("field", "AttentionActCnt");
				userSummaryDao.updatecntfiled(map);
			}catch(Exception e ){
				e.printStackTrace();
			}
			
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

	public UserSummaryDao getUserSummaryDao() {
		return userSummaryDao;
	}

	public void setUserSummaryDao(UserSummaryDao userSummaryDao) {
		this.userSummaryDao = userSummaryDao;
	}

	
	  
	
	
}
