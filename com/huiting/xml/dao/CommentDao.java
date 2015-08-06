package com.huiting.xml.dao;


import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.CommentDto;

public class CommentDao  extends SqlMapClientDaoSupport{
	public void insert(CommentDto commentDto) {
        getSqlMapClientTemplate().insert("CommentInfo.insert", commentDto);
    }
	
	public void delete(CommentDto commentDto) {
        getSqlMapClientTemplate().delete("CommentInfo.delete", commentDto);
    }
	
	public CommentDto selectById(String CommentID) {
        return (CommentDto)getSqlMapClientTemplate().queryForObject("CommentInfo.selectbyid", CommentID);
    }
	public List queryList(CommentDto commentDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("CommentInfo.querylist",commentDto, skipResults, maxResults);
    }
	public void update(CommentDto commentDto) {
        getSqlMapClientTemplate().update("CommentInfo.update", commentDto);
    }
	
	
	
	
	
	
	public List queryListByBusiid(String busiid,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("CommentInfo.querylistbybusiid", busiid, skipResults, maxResults);
    }
	public List queryListByUser(String userid,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("CommentInfo.querylistbyuserid", userid, skipResults, maxResults);
    }
}
