package com.huiting.xml.myuserconcernedshow.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.myuserconcernedshow.bean.ConcernedUserListBean;
import com.huiting.xml.myuserconcernedshow.bean.RequestBean;
import com.huiting.xml.myuserconcernedshow.bean.ResponseBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.UserConcernedDao;

public class BLUserConcernedShow extends BLBaseAction{
	 UserConcernedDao userConcernedDao;
		
		public Object handleXML(RequestBean reqHuiTingBean){
			String userID= "";
			int page ; 
			
			ResponseBean resHuiTingBean = new ResponseBean();
			String error ="";
			try{
				userID = reqHuiTingBean.getUserID();
				page = reqHuiTingBean.getPage();
				
				List<ConcernedUserListBean> list = new ArrayList<ConcernedUserListBean>();
				list = userConcernedDao.selectfans(userID, page*countperpage, countperpage);
				System.out.println("1---"+((ConcernedUserListBean)list.get(0)).getConcernedUserID());
				 
				genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
				resHuiTingBean.setConcernedUserList((ArrayList)list);
				
			}catch(Exception e ){
				e.printStackTrace();
				genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
			}
			
			return resHuiTingBean;
		}
		public Object handleXMLU(RequestBean reqHuiTingBean){
			String userID= "";
			int page ; 
			
			ResponseBean resHuiTingBean = new ResponseBean();
			String error ="";
			try{
				userID = reqHuiTingBean.getUserID();
				page = reqHuiTingBean.getPage();
				
				List<ConcernedUserListBean> list = new ArrayList<ConcernedUserListBean>();
				list = userConcernedDao.selectconcerned(userID, page*countperpage, countperpage);
				 
				genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
				resHuiTingBean.setConcernedUserList((ArrayList)list);
				
			}catch(Exception e ){
				e.printStackTrace();
				genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
			}
			
			return resHuiTingBean;
		}
		public UserConcernedDao getUserConcernedDao() {
			return userConcernedDao;
		}
		public void setUserConcernedDao(UserConcernedDao userConcernedDao) {
			this.userConcernedDao = userConcernedDao;
		}


		
}
