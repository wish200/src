package com.huiting.xml.dao;


import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.PicHuibenDto;


public class PicHuibenDao  extends SqlMapClientDaoSupport{
	public void insert(PicHuibenDto  picHuibenDto) {
        getSqlMapClientTemplate().insert("PicHuibenInfo.insert", picHuibenDto);
    }
	public void delete(PicHuibenDto picHuibenDto) {
        getSqlMapClientTemplate().update("PicHuibenInfo.delete", picHuibenDto);
    }	
	public PicHuibenDto selectbyid(String HuibenID) {
        return (PicHuibenDto)getSqlMapClientTemplate().queryForObject("PicHuibenInfo.selectbyid", HuibenID);
    }
	public List queryList(PicHuibenDto picHuibenDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("PicHuibenInfo.querylist",picHuibenDto,  skipResults, maxResults);
    }
	public void update(PicHuibenDto picHuibenDto) {
        getSqlMapClientTemplate().update("PicHuibenInfo.update", picHuibenDto);
    }
	public List queryHuibenShow(PicHuibenDto picHuibenDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("PicHuibenInfo.queryhuibenshow",picHuibenDto,  skipResults, maxResults);
    }
	public void updatepichuibenflower(PicHuibenDto picHuibenDto) {
        getSqlMapClientTemplate().update("PicHuibenInfo.updatepichuibenflower", picHuibenDto);
    }
}
