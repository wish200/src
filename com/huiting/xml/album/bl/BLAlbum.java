package com.huiting.xml.album.bl;

import com.huiting.common.BeanUtil;
import com.huiting.xml.album.bean.RequestBean;
import com.huiting.xml.album.bean.ResponseBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.AlbumDao;
import com.huiting.xml.dto.AlbumDto;

public class BLAlbum   extends BLBaseAction{
	AlbumDao albumDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		AlbumDto albumDto = new AlbumDto();
		ResponseBean resHuiTingBean = new ResponseBean();
		String error="";
		try{
			BeanUtil.coverBean2Dto(reqHuiTingBean, albumDto);
			albumDao.insert(albumDto);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean, reqHuiTingBean,"系统错误");
		}
		
		
		return resHuiTingBean;
		
	}
	public Object handleQuery(RequestBean reqHuiTingBean){
		AlbumDto albumDto = new AlbumDto();
		ResponseBean resHuiTingBean = new ResponseBean();
		String error="";
		try{
			BeanUtil.coverBean2Dto(reqHuiTingBean, albumDto);
			albumDao.insert(albumDto);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean, reqHuiTingBean,"系统错误");
		}
		
		
		return resHuiTingBean;
		
	}

	public AlbumDao getAlbumDao() {
		return albumDao;
	}

	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	
}
