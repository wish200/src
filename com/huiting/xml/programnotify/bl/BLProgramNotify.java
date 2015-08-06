package com.huiting.xml.programnotify.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.ProgramDao;
import com.huiting.xml.programnotify.bean.ProgramListBean;
import com.huiting.xml.programnotify.bean.RequestBean;
import com.huiting.xml.programnotify.bean.ResponseBean;

public class BLProgramNotify extends BLBaseAction {
	ProgramDao programDao ;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		
		String channelid  = "";
		int page =0;
		List<ProgramListBean> programList = new ArrayList<ProgramListBean>();
		try{
			//userID =  (reqHuiTingBean.getRequest()).getUserID();
			channelid = reqHuiTingBean.getChannelID(); 
			page = reqHuiTingBean.getPage();
			programList = programDao.selectByChannel(channelid, page*10, 10);
			System.out.println(programList.size());
			resHuiTingBean.setProgramList((ArrayList<ProgramListBean>)programList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			 
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	
	 

	public ProgramDao getProgramDao() {
		return programDao;
	}



	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}
	
}
