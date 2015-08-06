package com.huiting.xml.passwordupdate.bl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.huiting.xml.bean.ReqHeadBean;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.UserBaseInfoDao;
import com.huiting.xml.dto.UserBaseInfoDto;
import com.huiting.xml.passwordupdate.bean.RequestBean;
import com.huiting.xml.passwordupdate.bean.ResponseBean;

public class BLPasswordUpdate  extends BLBaseAction{
	UserBaseInfoDao userBaseInfoDao ;

	
	public Object handleXML(RequestBean reqHuiTingBean){
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		UserBaseInfoDto userBaseInfoDto = new UserBaseInfoDto();
		//chuanhuan dto
		Map<String, String> userMap = new HashMap<String, String>();
		try{
			userBaseInfoDto = (UserBaseInfoDto)userBaseInfoDao.selectbyid(reqHuiTingBean.getUserID());
			if(userBaseInfoDto!=null&&reqHuiTingBean.getOldPassword().equals(userBaseInfoDto.getPassword())){
				userMap.put("UserID", reqHuiTingBean.getUserID());
				userMap.put("Password", reqHuiTingBean.getPassword());
				userBaseInfoDao.updatepassword(userMap);
			}else{
				error="原密码不正确";
			}
			
			//fanhui
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
