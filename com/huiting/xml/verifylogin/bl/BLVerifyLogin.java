package com.huiting.xml.verifylogin.bl;

import java.sql.Timestamp;

import com.huiting.common.BeanUtil;
import com.huiting.xml.bean.ReqHeadBean;
import com.huiting.xml.verifylogin.bean.RequestBean;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.verifylogin.bean.ResponseBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.bl.BLSmsAction;
import com.huiting.xml.dao.UserBaseInfoDao;
import com.huiting.xml.dao.UserLoginDao;
import com.huiting.xml.dto.SMSVerifyCodeDto;
import com.huiting.xml.dto.UserBaseInfoDto;
import com.huiting.xml.dto.UserLoginDto;

public class BLVerifyLogin  extends BLBaseAction{
	UserBaseInfoDao userBaseInfoDao;
	UserLoginDao userLoginDao ;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		UserBaseInfoDto userBaseInfoDto = new UserBaseInfoDto();
		SMSVerifyCodeDto smsVerifyCodeDto = new SMSVerifyCodeDto();
		UserLoginDto userLoginDto = new UserLoginDto();
		
		String userID="";
		String error = "";
		String verifyResult ="";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			//chuanhuan dto
			userBaseInfoDto = (UserBaseInfoDto)userBaseInfoDao.selectbyphonenumber(reqHuiTingBean.getPhoneNumber());
			if(userBaseInfoDto==null||"".equals(userBaseInfoDto.getUserID())){
				error =  "用户不存在";
			}else{
				smsVerifyCodeDto.setUserID(userBaseInfoDto.getUserID());
			}
			smsVerifyCodeDto.setPhoneNumber(reqHuiTingBean.getPhoneNumber());
			smsVerifyCodeDto.setSourceType(reqHuiTingBean.getSourceType());
			smsVerifyCodeDto.setSmsCode(reqHuiTingBean.getMSCode()); 
			
			verifyResult = new BLSmsAction().VerifyCode(smsVerifyCodeDto);
			if("success".equals(verifyResult)){
				userLoginDto.setUserID(userBaseInfoDto.getUserID());
				userLoginDto.setLoginTime(new Timestamp(System.currentTimeMillis()));
				userLoginDao.insert(userLoginDto);
				
				BeanUtil.coverBean2Dto(userBaseInfoDto, resHuiTingBean);
			}else{
				error ="验证码不正确";
			}
			
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



	public UserLoginDao getUserLoginDao() {
		return userLoginDao;
	}



	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}
	
}
