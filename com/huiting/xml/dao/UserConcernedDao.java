package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.UserConcernedDto;

public class UserConcernedDao   extends SqlMapClientDaoSupport{
	public void insert(UserConcernedDto userConcernedDto) {
        getSqlMapClientTemplate().insert("UserConcernedInfo.insert", userConcernedDto);
    }
	public void delete(UserConcernedDto userConcernedDto) {
        getSqlMapClientTemplate().delete("UserConcernedInfo.delete", userConcernedDto);
    }
	
	public UserConcernedDto selectById(UserConcernedDto userConcernedDto) {
        return (UserConcernedDto)getSqlMapClientTemplate().queryForObject("UserConcernedInfo.selectbyid", userConcernedDto);
    }
	public List queryList(UserConcernedDto userConcernedDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("UserConcernedInfo.querylist",userConcernedDto, skipResults, maxResults);
    }
	public void update(UserConcernedDto userConcernedDto) {
        getSqlMapClientTemplate().update("UserConcernedInfo.update", userConcernedDto);
    }
	
	
	public void updatestatus(UserConcernedDto userConcernedDto) {
        getSqlMapClientTemplate().update("UserConcernedInfo.updatestatus", userConcernedDto);
    }
	public List selectfans(String UserID,int skipResults,int maxResults) {
        return getSqlMapClientTemplate().queryForList("UserConcernedInfo.selectfans", UserID, skipResults, maxResults);
	}
	public List selectconcerned(String UserID,int skipResults,int maxResults) {
        return getSqlMapClientTemplate().queryForList("UserConcernedInfo.selectconcerned", UserID, skipResults, maxResults);
	}
}
