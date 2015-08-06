package com.huiting.xml.dao;


import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.AudioHuibenDto;;


public class AudioHuibenDao  extends SqlMapClientDaoSupport{
	public void insert(AudioHuibenDto  audioHuibenDto) {
        getSqlMapClientTemplate().insert("AudioHuibenInfo.insert", audioHuibenDto);
    }
	public void delete(AudioHuibenDto audioHuibenDto) {
        getSqlMapClientTemplate().update("AudioHuibenInfo.delete", audioHuibenDto);
    }	
	public AudioHuibenDto selectbyid(String HuibenID) {
        return (AudioHuibenDto)getSqlMapClientTemplate().queryForObject("AudioHuibenInfo.selectbyid", HuibenID);
    }
	public List queryList(AudioHuibenDto audioHuibenDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("AudioHuibenInfo.querylist",audioHuibenDto,  skipResults, maxResults);
    }
	public void update(AudioHuibenDto audioHuibenDto) {
        getSqlMapClientTemplate().update("AudioHuibenInfo.update", audioHuibenDto);
    }
	public List queryHuibenShow(AudioHuibenDto audioHuibenDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("AudioHuibenInfo.queryhuibenshow",audioHuibenDto,  skipResults, maxResults);
    }
	public void updateaudiohuibenflower(AudioHuibenDto audioHuibenDto) {
        getSqlMapClientTemplate().update("AudioHuibenInfo.updateaudiohuibenflower", audioHuibenDto);
    }
	
}
