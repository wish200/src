package com.huiting.xml.picbookpublish.bl;

import java.sql.Timestamp;

import com.huiting.cache.SystemCache;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.PicBookDao;
import com.huiting.xml.dto.PicBookDto;
import com.huiting.xml.picbookpublish.bean.RequestBean;
import com.huiting.xml.picbookpublish.bean.ResponseBean;;

public class BLPicbookPublish   extends BLBaseAction{
	PicBookDao picBookDao ;
	
	public Object handleXML(RequestBean requestBean){
		
		ResponseBean resHuiTingBean = new ResponseBean();
		String error = "";
		String baseurl = "http://120.132.70.11/:8080/huiting/";	
		baseurl = SystemCache.getCache("connection.url");
		PicBookDto picBookDto = new PicBookDto();
		String PicbookId="";
		String PicbookURL="";
		try{ 
			picBookDto.setUserID(requestBean.getUserID());
			picBookDto.setNickName(requestBean.getNickName());
			picBookDto.setPicbookName(requestBean.getPicbookName());
			picBookDto.setPicScene(requestBean.getPicScene());
			picBookDto.setPicBookSource(requestBean.getPicBookSource());
			picBookDto.setPicbookStatus("1");
			picBookDto.setUploadTime(new Timestamp(System.currentTimeMillis()));
			picBookDto.setFlowerCnt(0);
			PicbookId = genPicbookID("P");
			PicbookURL =baseurl+requestBean.getFilepath();
			picBookDto.setPicbookID(PicbookId);
			picBookDto.setPicbookURL(PicbookURL);
			
			/*picHuibenDto.setHuibenID(genHuibenID("PH"));
			picHuibenDto.setPicbookID(paramMap.get("PicbookID"));
			picHuibenDto.setPicbookName(paramMap.get("PicbookName"));
			picHuibenDto.setPicbookURL(genPicbookURL("P",picHuibenDto.getPicbookID()));
			picHuibenDto.setPicScene(paramMap.get("PicScene"));
			picHuibenDto.setAudioID(genAudioID("A"));
			picHuibenDto.setAudioName(paramMap.get("AudioName"));
			picHuibenDto.setAudioURL(genAudioURL("A",picHuibenDto.getAudioID()));
			
			picHuibenDto.setUserID(paramMap.get("UserID"));
			picHuibenDto.setNickName(paramMap.get("NickName"));
			picHuibenDto.setUserPic(paramMap.get("UserPic"));
			picHuibenDto.setFlowerCnt(0);
			picHuibenDto.setStatus("1");
			picHuibenDto.setCommentCnt(0);
			picHuibenDto.setCreateTime(new Timestamp(System.currentTimeMillis()));*/
			 
			
			if(picBookDao==null){
				picBookDao = (PicBookDao)com.huiting.common.SpringBeanFactory.lookup("picBookDao");
			}
			picBookDao.insert(picBookDto);
			 
			resHuiTingBean.setUserID(requestBean.getUserID());
			resHuiTingBean.setPicbookId(PicbookId);
			resHuiTingBean.setPicbookURL(PicbookURL);
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

	

	
}
