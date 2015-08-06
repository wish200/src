package com.huiting.xml.dao;


import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.HuibenDto;


public class HuibenDao  extends SqlMapClientDaoSupport{
	public void insert(HuibenDto  HuibenDto) {
        getSqlMapClientTemplate().insert("HuibenInfo.insert", HuibenDto);
    }
	public void delete(HuibenDto HuibenDto) {
        getSqlMapClientTemplate().update("HuibenInfo.delete", HuibenDto);
    }	
	public HuibenDto selectbyid(String HuibenID) {
        return (HuibenDto)getSqlMapClientTemplate().queryForObject("HuibenInfo.selectbyid", HuibenID);
    }
	public List queryList(HuibenDto HuibenDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("HuibenInfo.querylist",HuibenDto,  skipResults, maxResults);
    }
	public void update(HuibenDto HuibenDto) {
        getSqlMapClientTemplate().update("HuibenInfo.update", HuibenDto);
    }
	public List queryHuibenShow(HuibenDto HuibenDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("HuibenInfo.queryhuibenshow",HuibenDto,  skipResults, maxResults);
    }
	public void updatehuibenflower(HuibenDto HuibenDto) {
        getSqlMapClientTemplate().update("HuibenInfo.updatehuibenflower", HuibenDto);
    }
	
	
}
