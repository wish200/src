package com.huiting.xml.channeldetail.bl;


import com.huiting.common.BeanUtil;
import com.huiting.xml.channeldetail.bean.RequestBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.channeldetail.bean.ResponseBean;
import com.huiting.xml.dao.ChannelDao;
import com.huiting.xml.dto.ChannelDto;

public class BLChannelDetail  extends BLBaseAction{
	ChannelDao channelDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		ChannelDto channelDto = new ChannelDto();
		String userID="";
		String error = "";
		ResponseBean resHuiTingBean = new ResponseBean();
		try{

			channelDto = channelDao.selectById(reqHuiTingBean.getChannelID());
			BeanUtil.coverBean2Dto(channelDto, resHuiTingBean);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}

	public ChannelDao getChannelDao() {
		return channelDao;
	}

	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	
	 



	
}
