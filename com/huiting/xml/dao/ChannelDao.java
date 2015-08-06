package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.ChannelDto;

public class ChannelDao extends SqlMapClientDaoSupport{
	public void insert(ChannelDto channelDto) {
        getSqlMapClientTemplate().insert("ChannelInfo.insert", channelDto);
    }
	public void delete(ChannelDto channelDto) {
        getSqlMapClientTemplate().delete("ChannelInfo.delete", channelDto);
    }
	
	public ChannelDto selectById(String ChannelID) {
        return (ChannelDto)getSqlMapClientTemplate().queryForObject("ChannelInfo.selectbyid", ChannelID);
    }
	
	/*public List queryListByUser(String userid,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("ChannelInfo.querylistbyUserid", userid, skipResults, maxResults);
    }*/
	
	public List queryList(ChannelDto channelDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("ChannelInfo.querylist",channelDto, skipResults, maxResults);
    }
	public List queryListShow(int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("ChannelInfo.querylistshow", skipResults, maxResults);
    }
	
	
	public void update(ChannelDto channelDto) {
        getSqlMapClientTemplate().update("ChannelInfo.update", channelDto);
    }
	
	public void updateflowercnt(ChannelDto channelDto) {
        getSqlMapClientTemplate().update("ChannelInfo.updateflowercnt", channelDto);
	}
	public void updateProgramCnt(ChannelDto channelDto) {
        getSqlMapClientTemplate().update("ChannelInfo.updateprogramCnt", channelDto);
	}
	public void updateFansCnt(ChannelDto channelDto) {
        getSqlMapClientTemplate().update("ChannelInfo.updatefansCnt", channelDto);
	}
	
	
	
}
