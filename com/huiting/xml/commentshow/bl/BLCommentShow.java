package com.huiting.xml.commentshow.bl;

import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.commentshow.bean.CommentListBean;
import com.huiting.xml.commentshow.bean.RequestBean;
import com.huiting.xml.commentshow.bean.ResponseBean;
import com.huiting.xml.dao.CommentDao;
import com.huiting.xml.dto.CommentDto; 

public class BLCommentShow  extends BLBaseAction{
    CommentDao commentDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		
		
		List<CommentListBean> CommentList = new ArrayList<CommentListBean>();
		try{
			CommentList = commentDao.queryListByBusiid(reqHuiTingBean.getBusiID(),reqHuiTingBean.getPage()*10,10);
			resHuiTingBean.setCommentList((ArrayList<CommentListBean>)CommentList);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}
	
	public Object handleXMLU(RequestBean reqHuiTingBean){
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		
		int page =0;
		List<CommentListBean> CommentList = new ArrayList<CommentListBean>();
		try{
			
			CommentList = commentDao.queryListByUser(reqHuiTingBean.getUserID(),reqHuiTingBean.getPage()*10,10);
			resHuiTingBean.setCommentList((ArrayList<CommentListBean>)CommentList);
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
