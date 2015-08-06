package com.huiting.xml.userupdate.bl;
 

import com.huiting.common.BeanUtil; 
import com.huiting.xml.userupdate.bean.RequestBean; 
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.userupdate.bean.ResponseBean;
import com.huiting.xml.dao.UserBaseInfoDao;
import com.huiting.xml.dto.UserBaseInfoDto;

public class BLUserUpdate extends BLBaseAction {
	UserBaseInfoDao userBaseInfoDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		
		UserBaseInfoDto userBaseInfoDto = new UserBaseInfoDto();
		ResponseBean resHuiTingBean = new ResponseBean();
		String error = "";
		try{
			userBaseInfoDto = (UserBaseInfoDto)userBaseInfoDao.selectbyid(reqHuiTingBean.getUserID());
			//chuanhuan dto
			
			BeanUtil.coverBean2Dto(reqHuiTingBean, userBaseInfoDto);
			
			if(userBaseInfoDao==null){
				userBaseInfoDao = (UserBaseInfoDao)com.huiting.common.SpringBeanFactory.lookup("userBaseInfoDao");
			}
			userBaseInfoDao.update(userBaseInfoDto)	;
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
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
	
}
