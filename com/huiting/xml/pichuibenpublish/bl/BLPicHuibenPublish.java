package com.huiting.xml.pichuibenpublish.bl;

import java.sql.Timestamp;

import com.huiting.cache.SystemCache;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.AudioDao;
import com.huiting.xml.dao.AudioHuibenDao;
import com.huiting.xml.dao.HuibenDao;
import com.huiting.xml.dao.PicBookDao;
import com.huiting.xml.dao.PicHuibenDao;
import com.huiting.xml.dto.AudioDto;
import com.huiting.xml.dto.AudioHuibenDto;
import com.huiting.xml.dto.HuibenDto;
import com.huiting.xml.dto.PicBookDto;
import com.huiting.xml.dto.PicHuibenDto;
import com.huiting.xml.pichuibenpublish.bean.RequestBean;
import com.huiting.xml.pichuibenpublish.bean.ResponseBean;


public class BLPicHuibenPublish   extends BLBaseAction{
	PicBookDao picBookDao ;
	PicHuibenDao picHuibenDao;
	HuibenDao huibenDao;
	
	public Object handleXML(RequestBean requestBean){
		
		ResponseBean resHuiTingBean = new ResponseBean();
		String error = "";
		String baseurl = "http://120.132.70.11/:8080/huiting/";	
		baseurl = SystemCache.getCache("connection.url");
		PicBookDto picBookDto = new PicBookDto();
		PicHuibenDto picHuibenDto = new PicHuibenDto();
		HuibenDto HuibenDto = new HuibenDto();
		String picbookId="";
		String picbookURL="";
		String huibenid="";
		
		try{ 
			picBookDto.setUserID(requestBean.getUserID());
			picBookDto.setNickName(requestBean.getNickName());
			picBookDto.setPicbookName(requestBean.getPicbookName());
			picBookDto.setPicScene(requestBean.getPicScene());
			picBookDto.setPicbookStatus("1");
			picBookDto.setUploadTime(new Timestamp(System.currentTimeMillis()));
			picBookDto.setFlowerCnt(0);
			picbookId = genPicbookID("PH");
			picbookURL =baseurl+requestBean.getFilepath();
			picBookDto.setPicbookID(picbookId);
			picBookDto.setPicbookURL(picbookURL);
			
			if(requestBean.getAudioUserID().equals(requestBean.getUserID())){
				huibenid =  genHuibenID("H");
				
				HuibenDto.setHuibenID(huibenid);
				HuibenDto.setPicbookID(picbookId);
				HuibenDto.setPicbookName(requestBean.getPicbookName());
				HuibenDto.setPicbookURL(picbookURL);
				HuibenDto.setPicScene(requestBean.getPicScene());
				HuibenDto.setUserID(requestBean.getUserID());
				HuibenDto.setNickName(requestBean.getNickName());
				HuibenDto.setUserPic(requestBean.getUserPic());
				HuibenDto.setAudioID(requestBean.getAudioID());
				HuibenDto.setAudioURL(requestBean.getAudioURL());
				HuibenDto.setAudioName(requestBean.getAudioName());
				HuibenDto.setAudioContent(requestBean.getAudioContent());
				HuibenDto.setAudioLength(requestBean.getAudioLength());
				HuibenDto.setFlowerCnt(0);
				HuibenDto.setStatus("1");
				HuibenDto.setCommentCnt(0);
				HuibenDto.setCreateTime(new Timestamp(System.currentTimeMillis()));
				if(huibenDao==null){
					huibenDao = (HuibenDao)com.huiting.common.SpringBeanFactory.lookup("huibenDao");
				}
				huibenDao.insert(HuibenDto);
			}else{
				huibenid =  genHuibenID("AH");
				
				picHuibenDto.setHuibenID(huibenid);
				picHuibenDto.setPicbookID(picbookId);
				picHuibenDto.setPicbookName(requestBean.getPicbookName());
				picHuibenDto.setPicbookURL(picbookURL);
				picHuibenDto.setPicScene(requestBean.getPicScene());
				picHuibenDto.setUserID(requestBean.getUserID());
				picHuibenDto.setNickName(requestBean.getNickName());
				picHuibenDto.setUserPic(requestBean.getUserPic());
				picHuibenDto.setAudioID(requestBean.getAudioID());
				picHuibenDto.setAudioName(requestBean.getAudioName());
				picHuibenDto.setAudioURL(requestBean.getAudioURL());
				picHuibenDto.setAudioContent(requestBean.getAudioContent());
				picHuibenDto.setAudioLength(requestBean.getAudioLength());
				picHuibenDto.setFlowerCnt(0);
				picHuibenDto.setStatus("0");
				picHuibenDto.setCommentCnt(0);
				picHuibenDto.setCreateTime(new Timestamp(System.currentTimeMillis()));
				if(picHuibenDao==null){
					picHuibenDao = (PicHuibenDao)com.huiting.common.SpringBeanFactory.lookup("picHuibenDao");
				}
				picHuibenDao.insert(picHuibenDto);
			}
			
			
			
			if(picBookDao==null){
				picBookDao = (PicBookDao)com.huiting.common.SpringBeanFactory.lookup("picBookDao");
			}
			
			picBookDao.insert(picBookDto);
			
			
			resHuiTingBean.setUserID(requestBean.getUserID());
			resHuiTingBean.setHuibenID(huibenid);
			resHuiTingBean.setPicbookId(picbookId);
			resHuiTingBean.setPicbookURL(picbookURL);
			genResponseHeadXml(resHuiTingBean,requestBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			error ="UPLOAD_FAIL";
			genResponseHeadXml(resHuiTingBean,requestBean,"系统错误");
		}
		return resHuiTingBean;
	}

	 
	public PicBookDao getPicBookDao() {
		return picBookDao;
	}


	public void setPicBookDao(PicBookDao picBookDao) {
		this.picBookDao = picBookDao;
	}


	public PicHuibenDao getPicHuibenDao() {
		return picHuibenDao;
	}


	public void setPicHuibenDao(PicHuibenDao picHuibenDao) {
		this.picHuibenDao = picHuibenDao;
	}


	public HuibenDao getHuibenDao() {
		return huibenDao;
	}

	public void setHuibenDao(HuibenDao huibenDao) {
		this.huibenDao = huibenDao;
	}

	 


	
}
