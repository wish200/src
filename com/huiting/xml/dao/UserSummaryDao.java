package com.huiting.xml.dao;

import java.util.HashMap;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.UserSummaryDto;

public class UserSummaryDao   extends SqlMapClientDaoSupport{
	public void insert(UserSummaryDto userSummaryDto) {
        getSqlMapClientTemplate().insert("UserSummaryInfo.insert", userSummaryDto);
    }
	public void delete(UserSummaryDto userSummaryDto) {
        getSqlMapClientTemplate().delete("UserSummaryInfo.delete", userSummaryDto);
    }
	public void update(UserSummaryDto userSummaryDto) {
        getSqlMapClientTemplate().update("UserSummaryInfo.update", userSummaryDto);
    }
	public UserSummaryDto selectById(String UserID) {
	       return (UserSummaryDto)getSqlMapClientTemplate().queryForObject("UserSummaryInfo.selectbyid", UserID);
	    }
	public UserSummaryDto selectByUserId(String  userid) {
       return (UserSummaryDto)getSqlMapClientTemplate().queryForObject("UserSummaryInfo.selectbyid", userid);
    }
	
	
	public void updatecntfiled(HashMap<String, String> m) {
        getSqlMapClientTemplate().update("UserSummaryInfo.updatecntfiled", m);
    }
}
