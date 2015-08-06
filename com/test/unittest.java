package com.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.python.antlr.PythonParser.list_for_return;
import org.python.util.PythonInterpreter;  

import com.huiting.xml.album.bl.BLAlbum;
import com.huiting.xml.dao.AlbumDao;
import com.huiting.xml.dto.AlbumDto;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
  
public class unittest  
{  
 public static void main(String args[])  
 {  
    // 修改ibatis配置文件，
	 String config = "SqlMapConfig_N.xml";  
     Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(config);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
     SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader); 
    // policyModelXMLDao.setSqlMapClient(sqlMap);
     AlbumDto albumDto = new AlbumDto();
     AlbumDao albumDao = new AlbumDao();
     albumDao.setSqlMapClient(sqlMap);
     albumDto.setUserID("u1");albumDto.setAudioID("a11");albumDto.setNickName(null);
     List<AlbumDto> list_for_return = albumDao.queryList(albumDto, 0, 6);
     System.out.println(list_for_return.size());
     for(int i =0; i<list_for_return.size();i++){
    	 System.out.println(list_for_return.get(i).getUserID()+"--"+list_for_return.get(i).getAudioID());
     }
 }//main  
} 
