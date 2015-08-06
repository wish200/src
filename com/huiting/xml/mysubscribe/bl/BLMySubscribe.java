package com.huiting.xml.mysubscribe.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.SubscribeDao; 
import com.huiting.xml.mysubscribe.bean.ChannelListBean;
import com.huiting.xml.mysubscribe.bean.RequestBean;
import com.huiting.xml.mysubscribe.bean.ResponseBean;

public class BLMySubscribe  extends BLBaseAction{
	SubscribeDao subscribeDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		List<ChannelListBean> channelList = new ArrayList<ChannelListBean>();
		
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			channelList = subscribeDao.queryListByUserID(reqHuiTingBean.getUserID(),reqHuiTingBean.getPage()*countperpage,countperpage );
			resHuiTingBean.setChannelList((ArrayList<ChannelListBean>)channelList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	  
	public SubscribeDao getSubscribeDao() {
		return subscribeDao;
	}
	public void setSubscribeDao(SubscribeDao subscribeDao) {
		this.subscribeDao = subscribeDao;
	}
	
}
