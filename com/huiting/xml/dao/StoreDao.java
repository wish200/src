package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.StoreDto;


public class StoreDao  extends SqlMapClientDaoSupport{
	 
	public void insert(StoreDto storeDto) {
        getSqlMapClientTemplate().insert("StoreInfo.insert", storeDto);
    }
	public void delete(StoreDto storeDto) {
        getSqlMapClientTemplate().delete("StoreInfo.delete", storeDto);
    }
	
	public StoreDto selectById(StoreDto storeDto) {
        return (StoreDto)getSqlMapClientTemplate().queryForObject("StoreInfo.selectbyid", storeDto);
    }
	public List queryList(StoreDto storeDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("StoreInfo.querylist",storeDto, skipResults, maxResults);
    }
	public void update(StoreDto storeDto) {
        getSqlMapClientTemplate().update("StoreInfo.update", storeDto);
    }
	
	public List queryStoreList(StoreDto storeDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("StoreInfo.querystorelist",storeDto, skipResults, maxResults);
    }
}
