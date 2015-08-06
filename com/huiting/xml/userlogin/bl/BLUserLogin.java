package com.huiting.xml.userlogin.bl;

import java.sql.Timestamp;

import com.huiting.cache.SystemCache;
import com.huiting.common.BeanUtil;
import com.huiting.xml.bean.ReqHeadBean;
import com.huiting.xml.userlogin.bean.RequestBean;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.userlogin.bean.ResponseBean;
import com.huiting.xml.dao.UserBaseInfoDao;
import com.huiting.xml.dao.UserLoginDao;
import com.huiting.xml.dto.UserBaseInfoDto;
import com.huiting.xml.dto.UserLoginDto;

public class BLUserLogin  extends BLBaseAction{
	UserBaseInfoDao userBaseInfoDao;
	UserLoginDao userLoginDao ;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		UserLoginDto userLoginDto = new UserLoginDto();
		UserBaseInfoDto userBaseInfoDto = new UserBaseInfoDto();
		
		
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			//chuanhuan dto
			userBaseInfoDto.setPhoneNumber(reqHuiTingBean.getPhoneNumber());
			userBaseInfoDto.setPassword(reqHuiTingBean.getPassword());
			
			//jiaoyan
			UserBaseInfoDto userBaseInfoDtov = (UserBaseInfoDto)userBaseInfoDao.selectbyphonenumber(userBaseInfoDto.getPhoneNumber());
			if(userBaseInfoDtov==null){
				error = "用户不存在";
			}else if(!userBaseInfoDtov.getPassword().equals(userBaseInfoDto.getPassword())){
				error = "密码不正确";
			}else{
				userLoginDto.setUserID(userBaseInfoDtov.getUserID());
				userLoginDto.setLoginTime(new Timestamp(System.currentTimeMillis()));
				userLoginDao.insert(userLoginDto);
			}	
			BeanUtil.coverBean2Dto(userBaseInfoDtov, resHuiTingBean);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean, reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	
	 
 

	public UserBaseInfoDao getUserBaseInfoDao() {
		return userBaseInfoDao;
	}



	public void setUserBaseInfoDao(UserBaseInfoDao userBaseInfoDao) {
		this.userBaseInfoDao = userBaseInfoDao;
	}



	public UserLoginDao getUserLoginDao() {
		return userLoginDao;
	}



	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}
	public  static void main(String[] arg){
		ResponseBean resHuiTingBean = new ResponseBean();
		resHuiTingBean.setUserID("xxx");
		ReqHeadBean reqHeader = new ReqHeadBean();
		reqHeader.setRequestType("01");
		reqHeader.setUUID("11111111");
		new BLUserLogin().genResponseHeadXml(resHuiTingBean, reqHeader,"系统错误");
		BeanUtil.printInvoke(resHuiTingBean);
	}
	
}
