package com.huiting.xml.channellistshow.bl;

import java.util.ArrayList;
import java.util.List;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.channellistshow.bean.ResponseBean;
import com.huiting.xml.channellistshow.bean.ChannelListBean;
import com.huiting.xml.channellistshow.bean.RequestBean;
import com.huiting.xml.dao.ChannelDao;


public class BLChannelListShow  extends BLBaseAction{
	ChannelDao channelDao ;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		
		 
		int page =0;
		List<ChannelListBean> channelList = new ArrayList<ChannelListBean>();
		try{
			userID = reqHuiTingBean.getUserID();
			 
			page =reqHuiTingBean.getPage();
			channelList= channelDao.queryListShow( page*countperpage, countperpage);
			resHuiTingBean.setChannelList((ArrayList<ChannelListBean>)channelList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	



	public ChannelDao getChannelDao() {
		return channelDao;
	}



	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	
}
