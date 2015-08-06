package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.FirstPageDto;

public class FirstPageDao extends SqlMapClientDaoSupport {
	public List selectByStatus(String  status) {
	       return getSqlMapClientTemplate().queryForList("FirstPageInfo.selectByStatus", status);
	    }
}
