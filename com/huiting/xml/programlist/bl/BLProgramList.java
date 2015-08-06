package com.huiting.xml.programlist.bl;


import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.programlist.bean.RequestBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.programlist.bean.ResponseBean;
import com.huiting.xml.dao.ProgramDao; 
import com.huiting.xml.programlist.bean.ProgramListBean;

public class BLProgramList extends BLBaseAction{
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
			programList = programDao.selectByChannel(channelid, page*countperpage, countperpage);
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
