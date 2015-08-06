package com.huiting.xml.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.huiting.xml.dto.XmlDto;


public class XmlDao extends SqlMapClientDaoSupport{
	
	
	public void insert(XmlDto xmlDto) {
        getSqlMapClientTemplate().insert("XmlInfo.insert", xmlDto);
    }
}
