package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.DownDto;
import com.huiting.xml.dto.FlowerDto;

public class FlowerDao extends SqlMapClientDaoSupport {
	public void insert(FlowerDto flowerDto) {
        getSqlMapClientTemplate().insert("FlowerInfo.insert", flowerDto);
    }
	

	public void delete(FlowerDto flowerDto) {
        getSqlMapClientTemplate().delete("FlowerInfo.delete", flowerDto);
    }
	
	public FlowerDto selectById(FlowerDto flowerDto) {
        return (FlowerDto)getSqlMapClientTemplate().queryForObject("FlowerInfo.selectbyid", flowerDto);
    }
	public List queryList(FlowerDto flowerDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("FlowerInfo.querylist",flowerDto, skipResults, maxResults);
    }
	public void update(FlowerDto flowerDto) {
        getSqlMapClientTemplate().update("FlowerInfo.update", flowerDto);
    }
	
	
	
}
