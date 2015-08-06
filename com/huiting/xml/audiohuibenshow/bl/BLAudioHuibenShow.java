package com.huiting.xml.audiohuibenshow.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.AudioHuibenDao;
import com.huiting.xml.dto.AudioHuibenDto;
import com.huiting.xml.audiohuibenshow.bean.HuibenListBean;
import com.huiting.xml.audiohuibenshow.bean.RequestBean;
import com.huiting.xml.audiohuibenshow.bean.ResponseBean;

public class BLAudioHuibenShow   extends BLBaseAction{
	 AudioHuibenDao audioHuibenDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		String error = "";
		String userID="";
		ResponseBean resHuiTingBean = new ResponseBean();
		
		List<HuibenListBean> huibenList = new ArrayList<HuibenListBean>();
		AudioHuibenDto audioHuibenDto = new AudioHuibenDto(); ;
		
		try{
			if(!"".equals(reqHuiTingBean.getUserID())&&reqHuiTingBean.getUserID()!=null){
				audioHuibenDto.setUserID(reqHuiTingBean.getUserID());
				huibenList = audioHuibenDao.queryHuibenShow(audioHuibenDto,reqHuiTingBean.getPage()*countperpage,countperpage );
			}else{
				huibenList = audioHuibenDao.queryHuibenShow(audioHuibenDto,reqHuiTingBean.getPage()*10,10 );
			}
			
			resHuiTingBean.setHuibenList((ArrayList<HuibenListBean>)huibenList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}

	public AudioHuibenDao getAudioHuibenDao() {
		return audioHuibenDao;
	}

	public void setAudioHuibenDao(AudioHuibenDao audioHuibenDao) {
		this.audioHuibenDao = audioHuibenDao;
	}


	
	 

	
}
