package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.ActivityDto;

public class ActivityDao  extends SqlMapClientDaoSupport{
	 
	public void insert(ActivityDto activityDto) {
        getSqlMapClientTemplate().insert("ActivityInfo.insert", activityDto);
    }
	public void delete(ActivityDto activityDto) {
        getSqlMapClientTemplate().delete("ActivityInfo.delete", activityDto);
    }
	
	public ActivityDto selectById(String ActivityID) {
        return (ActivityDto)getSqlMapClientTemplate().queryForObject("ActivityInfo.selectbyid", ActivityID);
    }
	public List queryList(ActivityDto activityDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("ActivityInfo.querylist",activityDto, skipResults, maxResults);
    }
	public void update(ActivityDto activityDto) {
        getSqlMapClientTemplate().update("ActivityInfo.update", activityDto);
    }
	public List queryListShow(ActivityDto activityDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("ActivityInfo.querylistshow",activityDto, skipResults, maxResults);
    }
}
