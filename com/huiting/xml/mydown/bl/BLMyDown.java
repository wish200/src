package com.huiting.xml.mydown.bl;



import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.DownDao;
import com.huiting.xml.mydown.bean.ProgramListBean;
import com.huiting.xml.mydown.bean.RequestBean;
import com.huiting.xml.mydown.bean.ResponseBean;

public class BLMyDown  extends BLBaseAction{
	DownDao downDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		List<ProgramListBean> programList = new ArrayList<ProgramListBean>();
		
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			programList = downDao.queryListByUserID(reqHuiTingBean.getUserID(),reqHuiTingBean.getPage()*countperpage,countperpage );
			resHuiTingBean.setProgramList((ArrayList<ProgramListBean>)programList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}

	public DownDao getDownDao() {
		return downDao;
	}

	public void setDownDao(DownDao downDao) {
		this.downDao = downDao;
	}
	  
	
	
}
