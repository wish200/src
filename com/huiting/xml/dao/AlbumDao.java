package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.ActivityDto;
import com.huiting.xml.dto.AlbumDto;

public class AlbumDao extends SqlMapClientDaoSupport{
	public void insert(AlbumDto albumDto) {
        getSqlMapClientTemplate().insert("AlbumInfo.insert", albumDto);
    }
	public void delete(AlbumDto albumDto) {
        getSqlMapClientTemplate().delete("AlbumInfo.delete", albumDto);
    }
	
	public AlbumDto selectById(AlbumDto albumDto) {
        return (AlbumDto)getSqlMapClientTemplate().queryForObject("AlbumInfo.selectbyid", albumDto);
    }
	public List queryList(AlbumDto albumDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("AlbumInfo.querylist",albumDto, skipResults, maxResults);
    }
	public void update(AlbumDto albumDto) {
        getSqlMapClientTemplate().update("AlbumInfo.update", albumDto);
    }
	
	public List queryListByUserID(String UserID,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("AlbumInfo.querylistbyuserid",UserID, skipResults, maxResults);
    }
	

}
