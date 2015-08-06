package com.huiting.xml.userconcerned.bl;

import java.sql.Timestamp;
import java.util.HashMap;

import com.huiting.xml.userconcerned.bean.RequestBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.userconcerned.bean.ResponseBean; 
import com.huiting.xml.dao.UserConcernedDao; 
import com.huiting.xml.dao.UserSummaryDao;
import com.huiting.xml.dto.UserConcernedDto; 

public class BLUserConcerned extends BLBaseAction{
	UserConcernedDao userConcernedDao ;
	UserSummaryDao userSummaryDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		UserConcernedDto userConcernedDto = new UserConcernedDto();
		ResponseBean resHuiTingBean = new ResponseBean();
		String error ="";
		try{
			userConcernedDto.setUserID(reqHuiTingBean.getUserID());
			userConcernedDto.setConcernedUserID(reqHuiTingBean.getConcernedUserID());
			userConcernedDto.setConcernedTime(new Timestamp(System.currentTimeMillis()));
			userConcernedDto.setStatus("1");
			userConcernedDao.insert(userConcernedDto);
			
			/*try{
				userSummaryDao.updateAttentionUserCnt(reqHuiTingBean.getUserID());
				userSummaryDao.updateFansCnt(reqHuiTingBean.getConcernedUserID());
			}catch(Exception e ){
				e.printStackTrace();
			}*/
			
			try{
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("UserID", reqHuiTingBean.getUserID());
				map.put("cnt", "1");
				map.put("field", "AttentionUserCnt");
				userSummaryDao.updatecntfiled(map);
				 
				map.put("UserID", reqHuiTingBean.getConcernedUserID());
				map.put("cnt", "1");
				map.put("field", "FansCnt");
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
		UserConcernedDto userConcernedDto = new UserConcernedDto();
		ResponseBean resHuiTingBean = new ResponseBean();
		String error ="";
		try{
			userConcernedDto.setUserID(reqHuiTingBean.getUserID());
			userConcernedDto.setConcernedUserID(reqHuiTingBean.getConcernedUserID());
			userConcernedDto.setConcernedTime(new Timestamp(System.currentTimeMillis()));
			userConcernedDto.setStatus("0");
			userConcernedDao.updatestatus(userConcernedDto);
			
			
			try{
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("UserID", reqHuiTingBean.getUserID());
				map.put("cnt", "-1");
				map.put("field", "AttentionUserCnt");
				userSummaryDao.updatecntfiled(map);
				 
				map.put("UserID", reqHuiTingBean.getConcernedUserID());
				map.put("cnt", "-1");
				map.put("field", "FansCnt");
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
	public UserConcernedDao getUserConcernedDao() {
		return userConcernedDao;
	}
	public void setUserConcernedDao(UserConcernedDao userConcernedDao) {
		this.userConcernedDao = userConcernedDao;
	}
	
}
