package com.huiting.xml.channelsubscribe.bl;

import java.sql.Timestamp;
import java.util.HashMap;

import com.huiting.common.BeanUtil;
import com.huiting.xml.bean.ReqHeadBean;
import com.huiting.xml.channelsubscribe.bean.RequestBean;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.channelsubscribe.bean.ResponseBean;
import com.huiting.xml.dao.SubscribeDao; 
import com.huiting.xml.dao.UserSummaryDao;
import com.huiting.xml.dto.SubscribeDto; 

public class BLChannelSubscribe extends BLBaseAction{
	SubscribeDao subscribeDao;
	UserSummaryDao userSummaryDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		SubscribeDto subscribeDto = new SubscribeDto();
		
		
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			BeanUtil.coverBean2Dto(reqHuiTingBean, subscribeDto);
			subscribeDto.setSubscribeTime(new Timestamp(System.currentTimeMillis()));
			subscribeDto.setStatus("1");
			subscribeDao.insert(subscribeDto);
			
			try{
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("UserID", reqHuiTingBean.getUserID());
				map.put("cnt", "1");
				map.put("field", "SubscribeChnlCnt");
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
	public Object handleXMLU(RequestBean reqHuiTingBean){
		SubscribeDto subscribeDto = new SubscribeDto();
		
		
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			BeanUtil.coverBean2Dto(reqHuiTingBean, subscribeDto);
			subscribeDto.setSubscribeTime(new Timestamp(System.currentTimeMillis()));
			subscribeDto.setStatus("0");
			subscribeDao.updatestatus(subscribeDto);
			
			try{
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("UserID", reqHuiTingBean.getUserID());
				map.put("cnt", "-1");
				map.put("field", "SubscribeChnlCnt");
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
	 

	 
	public UserSummaryDao getUserSummaryDao() {
		return userSummaryDao;
	}
	public void setUserSummaryDao(UserSummaryDao userSummaryDao) {
		this.userSummaryDao = userSummaryDao;
	}
	public SubscribeDao getSubscribeDao() {
		return subscribeDao;
	}
	public void setSubscribeDao(SubscribeDao subscribeDao) {
		this.subscribeDao = subscribeDao;
	}
	
}
