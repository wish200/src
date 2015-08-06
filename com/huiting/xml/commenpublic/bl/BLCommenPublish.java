package com.huiting.xml.commenpublic.bl;

import java.util.UUID;

import com.huiting.common.BeanUtil;
import com.huiting.xml.commenpublic.bean.RequestBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.commenpublic.bean.ResponseBean;
import com.huiting.xml.dao.CommentDao; 
import com.huiting.xml.dto.CommentDto; 

public class BLCommenPublish extends BLBaseAction{
	CommentDao commentDao;
	
	
	public Object handleXML(RequestBean reqHuiTingBean){
		CommentDto commentDto = new CommentDto();
		
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{
			BeanUtil.coverBean2Dto(reqHuiTingBean, commentDto);
			System.out.println(UUID.randomUUID());
			commentDto.setCommentID(UUID.randomUUID().toString());
			commentDto.setCommentStatus("1");
			
			commentDao.insert(commentDto);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
			 
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	
	 





	public CommentDao getCommentDao() {
		return commentDao;
	}



	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
}
