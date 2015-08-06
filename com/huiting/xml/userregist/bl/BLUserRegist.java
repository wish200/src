package com.huiting.xml.userregist.bl;
  
import java.sql.Timestamp;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.bl.BLSmsAction;
import com.huiting.xml.dao.UserBaseInfoDao;
import com.huiting.xml.dao.UserLoginDao;
import com.huiting.xml.dao.UserSummaryDao;
import com.huiting.xml.dto.SMSVerifyCodeDto;
import com.huiting.xml.dto.UserBaseInfoDto;
import com.huiting.xml.dto.UserLoginDto;
import com.huiting.xml.dto.UserSummaryDto;
import com.huiting.xml.userregist.bean.RequestBean;
import com.huiting.xml.userregist.bean.ResponseBean;

public class BLUserRegist  extends BLBaseAction  {
	UserBaseInfoDao userBaseInfoDao ;
	UserSummaryDao userSummaryDao;
	UserLoginDao userLoginDao;

	
	public Object handleXML(RequestBean reqHuiTingBean){
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		UserLoginDto userLoginDto = new UserLoginDto();
		//chuanhuan dto
		UserSummaryDto userSummaryDto = new UserSummaryDto();
		UserBaseInfoDto userBaseInfoDto = new UserBaseInfoDto();
		userBaseInfoDto.setPhoneNumber(reqHuiTingBean.getPhoneNumber());
		userBaseInfoDto.setPassword(reqHuiTingBean.getPassword());
		userBaseInfoDto.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		//jiaoyan
		SMSVerifyCodeDto smsVerifyCodeDto = new SMSVerifyCodeDto();
		smsVerifyCodeDto.setPhoneNumber(reqHuiTingBean.getPhoneNumber());
		smsVerifyCodeDto.setSourceType(reqHuiTingBean.getSourceType());
		smsVerifyCodeDto.setSmsCode(reqHuiTingBean.getMScode());
		String verifyResult = new BLSmsAction().VerifyCode(smsVerifyCodeDto);
		System.out.println("verifyResult---------------"+verifyResult);
		if(!"success".equals(verifyResult)){
			error = "验证码不正确";
		}else{
			//shengcheeng userid
			
			UserBaseInfoDto temp  = userBaseInfoDao.selectbyphonenumber(reqHuiTingBean.getPhoneNumber());;
			if(temp!=null){
				error = "该号码已注册";
			}else{
				userID = genUserID();
				temp =userBaseInfoDao.selectbyid(userID);
				while(temp!=null){
					userID = genUserID();
					temp =userBaseInfoDao.selectbyid(userID);
				}
				System.out.println("userID---------------"+userID);
				userBaseInfoDto.setUserID(userID);
				userSummaryDto.setUserID(userID);
				userLoginDto.setUserID(userID);
				userLoginDto.setLoginTime(new Timestamp(System.currentTimeMillis()));
				
				//baocun
				if(userBaseInfoDao==null){
					userBaseInfoDao = (UserBaseInfoDao)com.huiting.common.SpringBeanFactory.lookup("userBaseInfoDao");
				}
				if(userSummaryDao==null){
					userSummaryDao = (UserSummaryDao)com.huiting.common.SpringBeanFactory.lookup("userSummaryDao");
				}
				userBaseInfoDao.insert(userBaseInfoDto);
				userSummaryDao.insert(userSummaryDto);
				userLoginDao.insert(userLoginDto);
			} 
			
			
			resHuiTingBean.setUserID(userID);
			resHuiTingBean.setPassword(reqHuiTingBean.getPassword());
		}
		//fanhui
		genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		
		return resHuiTingBean;
	}
	
	 
	
	



	public UserSummaryDao getUserSummaryDao() {
		return userSummaryDao;
	}

	public void setUserSummaryDao(UserSummaryDao userSummaryDao) {
		this.userSummaryDao = userSummaryDao;
	}

	public UserLoginDao getUserLoginDao() {
		return userLoginDao;
	}


	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}


	public UserBaseInfoDao getUserBaseInfoDao() {
		return userBaseInfoDao;
	}

	public void setUserBaseInfoDao(UserBaseInfoDao userBaseInfoDao) {
		this.userBaseInfoDao = userBaseInfoDao;
	}
	
	
}
