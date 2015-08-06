package com.huiting.xml.audiopublish.bl;

import java.sql.Timestamp;

import com.huiting.cache.SystemCache;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.AudioDao;
import com.huiting.xml.dto.AudioDto;
import com.huiting.xml.audiopublish.bean.RequestBean;
import com.huiting.xml.audiopublish.bean.ResponseBean;;

public class BLAudioPublish   extends BLBaseAction{
	AudioDao audioDao ;
	
	public Object handleXML(RequestBean requestBean){
		
		ResponseBean resHuiTingBean = new ResponseBean();
		String error = "";
		String baseurl = "http://120.132.70.11/:8080/huiting/";	
		baseurl = SystemCache.getCache("connection.url");
		AudioDto audioDto = new AudioDto();
		String AudioId="";
		String AudioURL="";
		try{ 
			audioDto.setUserID(requestBean.getUserID());
			audioDto.setNickName(requestBean.getNickName());
			audioDto.setAudioName(requestBean.getAudioName());
			audioDto.setAudioSource(requestBean.getAudioSource());
			audioDto.setAudioLength(requestBean.getAudioLength());
			audioDto.setAudioContent(requestBean.getAudioContent());
			audioDto.setUploadTime(new Timestamp(System.currentTimeMillis()));
			audioDto.setAudioStatus("1");
			audioDto.setFlowerCnt(0);
			AudioId = genAudioID("A");
			AudioURL = baseurl+requestBean.getFilepath();
			audioDto.setAudioID(AudioId);
			audioDto.setAudioURL(AudioURL);
			
			  
			
			if(audioDao==null){
				audioDao = (AudioDao)com.huiting.common.SpringBeanFactory.lookup("audioDao");
			}
			audioDao.insert(audioDto);
			 
			resHuiTingBean.setUserID(requestBean.getUserID());
			resHuiTingBean.setAudioId(AudioId);
			resHuiTingBean.setAudioURL(AudioURL);
			genResponseHeadXml(resHuiTingBean,requestBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			error ="UPLOAD_FAIL";
			genResponseHeadXml(resHuiTingBean,requestBean,"系统错误");
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
