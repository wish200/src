package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.huiting.xml.dto.AudioDto;

public class AudioDao extends SqlMapClientDaoSupport{
	public void insert(AudioDto audioDto) {
        getSqlMapClientTemplate().insert("AudioInfo.insert", audioDto);
    }
	public void delete(AudioDto audioDto) {
        getSqlMapClientTemplate().delete("AudioInfo.delete", audioDto);
    }
	public AudioDto selectById(String AudioID) {
        return (AudioDto)getSqlMapClientTemplate().queryForObject("AudioInfo.selectbyid", AudioID);
    }
	public List queryList(AudioDto audioDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("AudioInfo.querylist",audioDto, skipResults, maxResults);
    }
	public List queryaudioshow(AudioDto audioDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("AudioInfo.queryaudioshow",audioDto, skipResults, maxResults);
    }
	public void update(AudioDto audioDto) {
        getSqlMapClientTemplate().update("AudioInfo.update", audioDto);
    }
	
 
	
	public void updateflowercnt(AudioDto AudioDto) {
        getSqlMapClientTemplate().update("AudioInfo.updateflowercnt", AudioDto);
    }
}
