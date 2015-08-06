package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.ProgramDto;
import com.huiting.xml.dto.SubscribeDto;

public class SubscribeDao   extends SqlMapClientDaoSupport{
	public void insert(SubscribeDto subscribeDto) {
        getSqlMapClientTemplate().insert("SubscribeInfo.insert", subscribeDto);
    }
	
	public void delete(SubscribeDto subscribeDto) {
        getSqlMapClientTemplate().delete("ProgramInfo.delete", subscribeDto);
    }
	
	public SubscribeDto selectById(SubscribeDto subscribeDto) {
        return (SubscribeDto)getSqlMapClientTemplate().queryForObject("ProgramInfo.selectbyid", subscribeDto);
    }
	public List queryList(SubscribeDto subscribeDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("ProgramInfo.querylist",subscribeDto, skipResults, maxResults);
    }
	public void update(SubscribeDto subscribeDto) {
        getSqlMapClientTemplate().update("ProgramInfo.update", subscribeDto);
    }
	
	
	public void updatestatus(SubscribeDto subscribeDto) {
        getSqlMapClientTemplate().update("SubscribeInfo.updatestatus", subscribeDto);
    }
	
	public List queryListByUserID(String UserID,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("SubscribeInfo.querylistbyuserid",UserID, skipResults, maxResults);
    }
	
}
