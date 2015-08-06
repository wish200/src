package com.huiting.xml.audioshow.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.audioshow.bean.AudioListBean;
import com.huiting.xml.audioshow.bean.RequestBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.audioshow.bean.ResponseBean;
import com.huiting.xml.dao.AudioDao;
import com.huiting.xml.dto.AudioDto;

public class BLAudioShow   extends BLBaseAction{
	 AudioDao  audioDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		String error = "";
		String userID="";
		ResponseBean resHuiTingBean = new ResponseBean();
		AudioDto audioDto = new AudioDto();
		
		List<AudioListBean> audioList = new ArrayList<AudioListBean>();
		
		try{
			audioDto.setUserID(reqHuiTingBean.getUserID());
			audioList = audioDao.queryaudioshow(audioDto,reqHuiTingBean.getPage()*countperpage,countperpage );
			
			
			resHuiTingBean.setAudioList((ArrayList<AudioListBean>)audioList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}

	public AudioDao getAudioDao() {
		return audioDao;
	}

	public void setAudioDao(AudioDao audioDao) {
		this.audioDao = audioDao;
	}
	
	 

	


}
