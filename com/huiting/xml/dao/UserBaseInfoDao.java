package com.huiting.xml.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.ProgramDto;
import com.huiting.xml.dto.UserBaseInfoDto;

public class UserBaseInfoDao   extends SqlMapClientDaoSupport{
	public void insert(UserBaseInfoDto userBaseInfoDto) {
        getSqlMapClientTemplate().insert("UserBaseInfo.insert", userBaseInfoDto);
    }
	public void delete(UserBaseInfoDto userBaseInfoDto) {
        getSqlMapClientTemplate().delete("ProgramInfo.delete", userBaseInfoDto);
    }
	public UserBaseInfoDto selectbyid(String UserID) {
       return (UserBaseInfoDto)getSqlMapClientTemplate().queryForObject("UserBaseInfo.selectbyid", UserID);
    }
	public UserBaseInfoDto selectbyphonenumber(String phonenumber) {
	       return (UserBaseInfoDto)getSqlMapClientTemplate().queryForObject("UserBaseInfo.selectbyphonenumber", phonenumber);
	}
	public void update(UserBaseInfoDto userBaseInfoDto) {
	        getSqlMapClientTemplate().update("UserBaseInfo.update", userBaseInfoDto);
	}
	public void updateBackGroundPIC(Map<String, String> map) {
        getSqlMapClientTemplate().update("UserBaseInfo.updatebackgroundpic", map);
	}
	public void updateuserpic(Map<String, String> map) {
        getSqlMapClientTemplate().update("UserBaseInfo.updateuserpic", map);
	}
	public void updatepassword(Map<String, String> map) {
        getSqlMapClientTemplate().update("UserBaseInfo.updatepassword", map);
	}
	
	
}
