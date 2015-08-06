package com.huiting.xml.activity.bl;

import java.sql.Timestamp;

import com.huiting.cache.SystemCache;
import com.huiting.common.BeanUtil;
import com.huiting.xml.activity.bean.RequestBean;
import com.huiting.xml.activity.bean.ResponseBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.ActivityDao; 
import com.huiting.xml.dto.ActivityDto; 

public class BLActivity   extends BLBaseAction{
	ActivityDao activityDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		ActivityDto activityDto = new ActivityDto();
		ResponseBean resHuiTingBean = new ResponseBean();
		String error="";
		String baseurl = SystemCache.getCache("connection.url");
		try{
			
			BeanUtil.coverBean2Dto(reqHuiTingBean, activityDto);
			activityDto.setActivityID(genActivityID("Act"));
			activityDto.setActivityTime(new Timestamp(System.currentTimeMillis()));
			activityDto.setActivityPicURL(baseurl+reqHuiTingBean.getFilepath());
			activityDao.insert(activityDto);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean, reqHuiTingBean,"系统错误");
		}
		
		
		return resHuiTingBean;
		
	}
	
	public ActivityDao getActivityDao() {
		return activityDao;
	}
	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	
	
}
