package com.huiting.xml.dao;


import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.UserLoginDto;

public class UserLoginDao  extends SqlMapClientDaoSupport {
	public void insert(UserLoginDto userLoginDto) {
        getSqlMapClientTemplate().insert("UserLoginInfo.insert", userLoginDto);
    }
	public void delete(UserLoginDto userLoginDto) {
        getSqlMapClientTemplate().delete("DownInfo.delete", userLoginDto);
    }
	
	public UserLoginDto selectById(String UserID) {
        return (UserLoginDto)getSqlMapClientTemplate().queryForObject("DownInfo.selectbyid", UserID);
    }
	public List queryList(UserLoginDto userLoginDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("DownInfo.querylist",userLoginDto, skipResults, maxResults);
    }
	public void update(UserLoginDto userLoginDto) {
        getSqlMapClientTemplate().update("DownInfo.update", userLoginDto);
    }
	

}
