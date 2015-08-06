package com.huiting.xml.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.ProgramDto;
import com.huiting.xml.dto.SMSVerifyCodeDto;

public class SMSVerifyCodeDao  extends SqlMapClientDaoSupport {
	//SqlMapClient sqlMap = null;
	public SMSVerifyCodeDao() {
		 /*String config = "SqlMapConfig_N.xml";  
	        Reader reader = Resources.getResourceAsReader(config);  
	        sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);  */
	}
	
	
	public void insert(SMSVerifyCodeDto sMSVerifyCodeDto) {
        getSqlMapClientTemplate().insert("SMSVerifyCodeInfo.insert", sMSVerifyCodeDto);
    }
	
	public void insertlist(List<SMSVerifyCodeDto> list ) throws SQLException {
		
		getSqlMapClientTemplate().insert("SMSVerifyCodeInfo.insertlist", list);
    }
	
	
	public void delete(SMSVerifyCodeDto sMSVerifyCodeDto) {
        getSqlMapClientTemplate().delete("SMSVerifyCodeInfo.delete", sMSVerifyCodeDto);
    }
	
	public SMSVerifyCodeDto selectById(SMSVerifyCodeDto sMSVerifyCodeDto) {
        return (SMSVerifyCodeDto)getSqlMapClientTemplate().queryForObject("SMSVerifyCodeInfo.selectbyid", sMSVerifyCodeDto);
    }
	public List queryList(SMSVerifyCodeDto sMSVerifyCodeDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("SMSVerifyCodeInfo.querylist",sMSVerifyCodeDto, skipResults, maxResults);
    }
	public void update(SMSVerifyCodeDto sMSVerifyCodeDto) {
        getSqlMapClientTemplate().update("SMSVerifyCodeInfo.update", sMSVerifyCodeDto);
    }
	
	
}
