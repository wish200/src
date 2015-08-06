package com.huiting.xml.activityshow.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.activityshow.bean.ActivityShowListBean;
import com.huiting.xml.activityshow.bean.RequestBean;
import com.huiting.xml.activityshow.bean.ResponseBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.ActivityDao;
import com.huiting.xml.dto.ActivityDto;

public class BLActivityShow   extends BLBaseAction{
	ActivityDao activityDao;
	
	
	public Object handleXML(RequestBean reqHuiTingBean){
		ResponseBean resHuiTingBean = new ResponseBean();
		ActivityDto activityDto = new ActivityDto();
		String error="";
		List<ActivityShowListBean> activityList = new ArrayList<ActivityShowListBean>();
		try{
			
			activityList = activityDao.queryListShow(activityDto,reqHuiTingBean.getPage()*countperpage,countperpage);
			resHuiTingBean.setActivityList(( ArrayList<ActivityShowListBean>)activityList);
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
