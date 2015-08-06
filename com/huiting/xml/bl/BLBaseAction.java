package com.huiting.xml.bl;

import java.sql.Timestamp;
import java.util.UUID;

import com.huiting.xml.bean.ReqHeadBean;
import com.huiting.xml.bean.ResHeadBean;

public class BLBaseAction {
	public static final int countperpage =4;
	public static final int useridlength =8;
	public static final int huibenlength =8;
	public static final int piclength =8;
	public static final int audiolength =8;
	public static final int actlength =8;
	
	
	public ResHeadBean genResponseHeadXml(ResHeadBean resHeadBean,ReqHeadBean reqHeader,String error){
		resHeadBean.setRequestType(reqHeader.getRequestType());
		resHeadBean.setSendTime(new Timestamp(System.currentTimeMillis()));
		resHeadBean.setUUID(reqHeader.getUUID());
		resHeadBean.setErrorMessage(error);
		if(error!=null&&!"".equals(error)){
			resHeadBean.setResponseCode("1");
		}else{
			resHeadBean.setResponseCode("0");
		}
		
		return resHeadBean;
	}
	
	public String genUserID(){
		 String[] chars = new String[] {"1","2","3","4","5","6","7","8","9","0"}; 
		 StringBuffer shortBuffer = new StringBuffer();  
		    String uuid = UUID.randomUUID().toString().replace("-", "");  
		    for (int i = 0; i < useridlength; i++) {  
		        String str = uuid.substring(i * 4, i * 4 + 4);  
		        int x = Integer.parseInt(str, 16);  
		        shortBuffer.append(chars[(x % 0x3E)/9]);  
		    }  
		    return shortBuffer.toString(); 
		
	}
	
	public String genHuibenID(String type){
		 String[] chars = new String[] {"1","2","3","4","5","6","7","8","9","0"}; 
		 StringBuffer shortBuffer = new StringBuffer(); 
		 shortBuffer.append(type);
		    String uuid = UUID.randomUUID().toString().replace("-", "");  
		    for (int i = 0; i < huibenlength; i++) {  
		        String str = uuid.substring(i * 4, i * 4 + 4);  
		        int x = Integer.parseInt(str, 16);  
		        shortBuffer.append(chars[(x % 0x3E)/9]);  
		    }  
		    return shortBuffer.toString(); 
		
	}
	public String genAudioID(String type){
		 String[] chars = new String[] {"1","2","3","4","5","6","7","8","9","0"}; 
		 StringBuffer shortBuffer = new StringBuffer(); 
		 shortBuffer.append(type);
		    String uuid = UUID.randomUUID().toString().replace("-", "");  
		    for (int i = 0; i < audiolength; i++) {  
		        String str = uuid.substring(i * 4, i * 4 + 4);  
		        int x = Integer.parseInt(str, 16);  
		        shortBuffer.append(chars[(x % 0x3E)/9]);  
		    }  
		    return shortBuffer.toString(); 
		
	}
	public String genPicbookID(String type){
		 String[] chars = new String[] {"1","2","3","4","5","6","7","8","9","0"}; 
		 StringBuffer shortBuffer = new StringBuffer(); 
		 shortBuffer.append(type);
		    String uuid = UUID.randomUUID().toString().replace("-", "");  
		    for (int i = 0; i < piclength; i++) {  
		        String str = uuid.substring(i * 4, i * 4 + 4);  
		        int x = Integer.parseInt(str, 16);  
		        shortBuffer.append(chars[(x % 0x3E)/9]);  
		    }  
		    return shortBuffer.toString(); 
		
	}
	
	public String genActivityID(String type){
		 String[] chars = new String[] {"1","2","3","4","5","6","7","8","9","0"}; 
		 StringBuffer shortBuffer = new StringBuffer(); 
		 shortBuffer.append(type);
		    String uuid = UUID.randomUUID().toString().replace("-", "");  
		    for (int i = 0; i < actlength; i++) {  
		        String str = uuid.substring(i * 4, i * 4 + 4);  
		        int x = Integer.parseInt(str, 16);  
		        shortBuffer.append(chars[(x % 0x3E)/9]);  
		    }  
		    return shortBuffer.toString(); 
		
	}
	
}
