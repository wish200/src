package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.PictureDto;

public class PictureDao  extends SqlMapClientDaoSupport{
	public void insert(PictureDto PictureDto) {
        getSqlMapClientTemplate().insert("PictureInfo.insert", PictureDto);
    }
	public void delete(PictureDto PictureDto) {
        getSqlMapClientTemplate().delete("PictureInfo.delete", PictureDto);
    }
	
	public PictureDto selectById(String PicID) {
        return (PictureDto)getSqlMapClientTemplate().queryForObject("PictureInfo.selectbyid", PicID);
    }
	public List queryList(PictureDto PictureDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("PictureInfo.querylist",PictureDto, skipResults, maxResults);
    }
	public void update(PictureDto PictureDto) {
        getSqlMapClientTemplate().update("PictureInfo.update", PictureDto);
    }
	

}
