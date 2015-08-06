package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.PictureDto;
import com.huiting.xml.dto.ProgramDto;

public class ProgramDao  extends SqlMapClientDaoSupport{
	public void insert(ProgramDto programDto) {
        getSqlMapClientTemplate().insert("ProgramInfo.insert", programDto);
    }
	public void delete(ProgramDto programDto) {
        getSqlMapClientTemplate().delete("ProgramInfo.delete", programDto);
    }
	
	public ProgramDto selectById(String ProgramID) {
        return (ProgramDto)getSqlMapClientTemplate().queryForObject("ProgramInfo.selectbyid", ProgramID);
    }
	public List queryList(ProgramDto programDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("ProgramInfo.querylist",programDto, skipResults, maxResults);
    }
	public void update(ProgramDto programDto) {
        getSqlMapClientTemplate().update("ProgramInfo.update", programDto);
    }
	
	
	
	
	public List selectByChannel(String ChannelID ,int skipResults, int maxResults ) {
        return getSqlMapClientTemplate().queryForList("ProgramInfo.selectbychannelid",ChannelID,skipResults,maxResults);
    }

	public void updateflowercnt(ProgramDto programDto) {
          getSqlMapClientTemplate().update("ProgramInfo.updateflowercnt", programDto);
    }
	public List programlistnotify(String ChannelID ,int skipResults, int maxResults ) {
        return getSqlMapClientTemplate().queryForList("ProgramInfo.programlistnotify",ChannelID,skipResults,maxResults);
    }
	
}
