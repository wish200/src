package com.huiting.xml.majorpageshow.bl;


import com.huiting.xml.majorpageshow.bean.RequestBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.majorpageshow.bean.ResponseBean;
import com.huiting.xml.dao.UserBaseInfoDao; 
import com.huiting.xml.dao.UserSummaryDao;
import com.huiting.xml.dto.UserBaseInfoDto; 
import com.huiting.xml.dto.UserSummaryDto;

public class BLMajorPageShow extends BLBaseAction{
 UserBaseInfoDao userBaseInfoDao;
 UserSummaryDao userSummaryDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		UserBaseInfoDto userBaseInfoDto = new UserBaseInfoDto();
		UserSummaryDto userSummaryDto = new UserSummaryDto();
		String userID= "";
		
		
		ResponseBean resHuiTingBean = new ResponseBean();
		String error ="";
		try{
			userID = reqHuiTingBean.getUserID();
			userBaseInfoDto = userBaseInfoDao.selectbyid(userID);
			userSummaryDto = userSummaryDao.selectByUserId(userID);
			
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			resHuiTingBean.setUserID(userID) ;
			resHuiTingBean.setUserNick(userBaseInfoDto.getNickName());
			resHuiTingBean.setDescription(userBaseInfoDto.getDescription());
			resHuiTingBean.setUserPicUrl(userBaseInfoDto.getUserPic());
			resHuiTingBean.setBackGroundPICURL(userBaseInfoDto.getBackGroundPIC());
			resHuiTingBean.setAttentionUserCnt(userSummaryDto.getAttentionActCnt());
			resHuiTingBean.setFansCnt(userSummaryDto.getFansCnt());
			resHuiTingBean.setFlowerCnt(userSummaryDto.getFlowerCnt());
			resHuiTingBean.setSubscribeChnlCnt(userSummaryDto.getSubscribeChnlCnt());
			
			
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	 


	public UserBaseInfoDao getUserBaseInfoDao() {
		return userBaseInfoDao;
	}


	public void setUserBaseInfoDao(UserBaseInfoDao userBaseInfoDao) {
		this.userBaseInfoDao = userBaseInfoDao;
	}


	public UserSummaryDao getUserSummaryDao() {
		return userSummaryDao;
	}


	public void setUserSummaryDao(UserSummaryDao userSummaryDao) {
		this.userSummaryDao = userSummaryDao;
	}
	
}
