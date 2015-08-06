package com.huiting.xml.msverify.bl;

import com.huiting.xml.msverify.bean.RequestBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.bl.BLSmsAction; 
import com.huiting.xml.dto.SMSVerifyCodeDto; 
import com.huiting.xml.msverify.bean.ResponseBean;
public class BLMsVerify extends BLBaseAction{

	public Object handleXML(RequestBean reqHuiTingBean){
		 
		ResponseBean resHuiTingBean = new ResponseBean();
		SMSVerifyCodeDto smsVerifyCodeDto = new SMSVerifyCodeDto();
		String error = "";
		try{
			smsVerifyCodeDto.setUserID(reqHuiTingBean.getUserID());
			smsVerifyCodeDto.setSourceType(reqHuiTingBean.getSourceType());
			smsVerifyCodeDto.setPhoneNumber(reqHuiTingBean.getPhoneNumber());
			
			String mscode = new BLSmsAction().genVerifyCode(smsVerifyCodeDto);
			System.out.println("mscode--"+mscode);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			resHuiTingBean.setSourceType(reqHuiTingBean.getSourceType());
			resHuiTingBean.setMSCode(mscode);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	
	 

	 
}
