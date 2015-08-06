package com.huiting.xml.dao;


import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.PicBookDto;

public class PicBookDao  extends SqlMapClientDaoSupport{
	public void insert(PicBookDto picBookDto) {
        getSqlMapClientTemplate().insert("PicBookInfo.insert", picBookDto);
    }
	public PicBookDto SelectById(String PicbookID) {
        return (PicBookDto)getSqlMapClientTemplate().queryForObject("PicBookInfo.selectbyid", PicbookID);
    }
	
	public List queryList(PicBookDto picBookDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("PicBookInfo.querylist",picBookDto, skipResults, maxResults);
    }
	
	public void delete(PicBookDto picBookDto) {
        getSqlMapClientTemplate().update("PicBookInfo.delete", picBookDto);
    }
	public void update(PicBookDto picBookDto) {
        getSqlMapClientTemplate().update("PicBookInfo.update", picBookDto);
    }
	public void updatestatus(PicBookDto picBookDto) {
        getSqlMapClientTemplate().update("PicBookInfo.updatestatus", picBookDto);
    }
	
	public List queryListByUserID(String userid,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("PicBookInfo.querylistbyuserid", userid, skipResults, maxResults);
    }
	public List queryList(int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("PicBookInfo.querylist",  skipResults, maxResults);
    }
}
