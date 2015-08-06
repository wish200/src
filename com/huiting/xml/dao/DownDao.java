package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.CommentDto;
import com.huiting.xml.dto.DownDto;

public class DownDao  extends SqlMapClientDaoSupport{
	public void insert(DownDto downDto) {
        getSqlMapClientTemplate().insert("DownInfo.insert", downDto);
    }
	public void delete(DownDto downDto) {
        getSqlMapClientTemplate().delete("DownInfo.delete", downDto);
    }
	
	public DownDto selectById(DownDto downDto) {
        return (DownDto)getSqlMapClientTemplate().queryForObject("DownInfo.selectbyid", downDto);
    }
	public List queryList(DownDto downDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("DownInfo.querylist",downDto, skipResults, maxResults);
    }
	public void update(DownDto downDto) {
        getSqlMapClientTemplate().update("DownInfo.update", downDto);
    }
	
	
	
	
	public List queryListByUserID(String  UserID,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("DownInfo.querylistbyuserid",UserID,skipResults, maxResults);
    }
}
