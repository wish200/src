package com.huiting.xml.flowerget.bl;

import java.sql.Timestamp;
import java.util.HashMap;

import org.python.antlr.PythonParser.else_clause_return;

import com.huiting.common.BeanUtil;
import com.huiting.xml.flowerget.bean.RequestBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.flowerget.bean.ResponseBean;
import com.huiting.xml.dao.AudioHuibenDao;
import com.huiting.xml.dao.ChannelDao;
import com.huiting.xml.dao.FlowerDao;
import com.huiting.xml.dao.HuibenDao;
import com.huiting.xml.dao.PicBookDao;  
import com.huiting.xml.dao.PicHuibenDao;
import com.huiting.xml.dao.ProgramDao;
import com.huiting.xml.dao.UserSummaryDao;
import com.huiting.xml.dto.AudioHuibenDto;
import com.huiting.xml.dto.ChannelDto;
import com.huiting.xml.dto.FlowerDto;
import com.huiting.xml.dto.HuibenDto;
import com.huiting.xml.dto.PicBookDto; 
import com.huiting.xml.dto.PicHuibenDto;
import com.huiting.xml.dto.ProgramDto;
import com.huiting.xml.dto.UserSummaryDto;


public class BLFlowerGet extends BLBaseAction{
	FlowerDao flowerDao;
	UserSummaryDao userSummaryDao;
	PicHuibenDao picHuibenDao;
	AudioHuibenDao audioHuibenDao;
	HuibenDao huibenDao;
	ProgramDao programDao;
	
	 
	public Object handleXML(RequestBean reqHuiTingBean){
		FlowerDto flowerDto = new FlowerDto();
		UserSummaryDto userSummaryDto=new UserSummaryDto();
		int flowercnt=0;
		
		String error = ""; 
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			BeanUtil.coverBean2Dto(reqHuiTingBean, flowerDto);
			flowerDto.setCommenTime(new Timestamp(System.currentTimeMillis()));
			flowerDao.insert(flowerDto);
			 
			
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			try{
				flowercnt = reqHuiTingBean.getFlowerCnt();
				
				//送出的小红花
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("UserID", reqHuiTingBean.getUserID());
				map.put("cnt", ""+flowercnt);
				map.put("field", "GiveFlowerCnt");
				userSummaryDao.updatecntfiled(map);
				 
				
				if("B01".equals(reqHuiTingBean.getModular())){
					PicHuibenDto picHuibenDto = new PicHuibenDto();
					picHuibenDto.setHuibenID(reqHuiTingBean.getBusiID());
					picHuibenDto.setFlowerCnt(flowercnt);
					picHuibenDao.updatepichuibenflower(picHuibenDto);
					
					
				}if("B02".equals(reqHuiTingBean.getModular())){
					AudioHuibenDto audioHuibenDto = new AudioHuibenDto();
					audioHuibenDto.setHuibenID(reqHuiTingBean.getBusiID());
					audioHuibenDto.setFlowerCnt(flowercnt);
					audioHuibenDao.updateaudiohuibenflower(audioHuibenDto);
					
					
				}if("B03".equals(reqHuiTingBean.getModular())){
					HuibenDto huibenDto = new HuibenDto();
					huibenDto.setHuibenID(reqHuiTingBean.getBusiID());
					huibenDto.setFlowerCnt(flowercnt);
					huibenDao.updatehuibenflower(huibenDto);
					
					
				}else if("P01".equals(reqHuiTingBean.getModular())){
					ProgramDto programDto = new  ProgramDto();
					programDto.setProgramID(reqHuiTingBean.getBusiID());
					programDto.setFlowerCnt(flowercnt);
					programDao.updateflowercnt(programDto);
					
				}else if("A01".equals(reqHuiTingBean.getModular())){
					
				}
				
				
				
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}


	public FlowerDao getFlowerDao() {
		return flowerDao;
	}


	public void setFlowerDao(FlowerDao flowerDao) {
		this.flowerDao = flowerDao;
	}


	public UserSummaryDao getUserSummaryDao() {
		return userSummaryDao;
	}


	public void setUserSummaryDao(UserSummaryDao userSummaryDao) {
		this.userSummaryDao = userSummaryDao;
	}


	public PicHuibenDao getPicHuibenDao() {
		return picHuibenDao;
	}


	public void setPicHuibenDao(PicHuibenDao picHuibenDao) {
		this.picHuibenDao = picHuibenDao;
	}


	public AudioHuibenDao getAudioHuibenDao() {
		return audioHuibenDao;
	}


	public void setAudioHuibenDao(AudioHuibenDao audioHuibenDao) {
		this.audioHuibenDao = audioHuibenDao;
	}


	public HuibenDao getHuibenDao() {
		return huibenDao;
	}


	public void setHuibenDao(HuibenDao huibenDao) {
		this.huibenDao = huibenDao;
	}


	public ProgramDao getProgramDao() {
		return programDao;
	}


	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}
	
	 


 




 



	
	
}
