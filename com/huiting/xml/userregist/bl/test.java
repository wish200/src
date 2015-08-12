package com.huiting.xml.userregist.bl;

 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.UUID;

import com.alibaba.fastjson.JSON;

 

public class test {
	
	
public static void main(String[] arg){
		
		try{		 
			/*
			 * 注册时输入手机号，获取验证码，然后输入验证码和密码进行注册提交。
			 * 如果手机已注册，提示“该手机号已注册”，
			 * 否则生成用户ID，插入用户表和用户统计表，登陆表一条数据。
			 */
			com.huiting.xml.msverify.bean.RequestBean msBean = new com.huiting.xml.msverify.bean.RequestBean();
			msBean.setSendTime(new Timestamp(System.currentTimeMillis()));
			msBean.setUUID(UUID.randomUUID().toString());
			
			msBean.setRequestType("A06");//获取短信验证码接口
			msBean.setPhoneNumber("15800981549");
			msBean.setSourceType("C01");
			 String msjsonString = JSON.toJSONString(msBean);
			
			 com.huiting.xml.userregist.bean.RequestBean  requestBean = new com.huiting.xml.userregist.bean.RequestBean();
			 requestBean.setSendTime(new Timestamp(System.currentTimeMillis()));
			 requestBean.setUUID(UUID.randomUUID().toString());
			 requestBean.setRequestType("A02");
			 requestBean.setMScode("820615");
			 requestBean.setSourceType("C01");
			 requestBean.setPassword("123456");
			 requestBean.setPhoneNumber("15800981549");
			 String registString =JSON.toJSONString(requestBean);
			 
			
			String str=connect("http://120.132.70.11:8080/huiting/HuiTingAction.do", registString);
			//String str=connect("http://10.2.60.43:8080/huiting/HuiTingAction.do", registString);
			
			System.out.println("str----"+str);
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
public static String toMD5(String str){  
    try {  
        MessageDigest md = MessageDigest.getInstance("MD5");  
        md.update(str.getBytes());  
        byte[]byteDigest = md.digest();  
        int i;  
        StringBuffer buf = new StringBuffer("");  
        for (int offset = 0; offset < byteDigest.length; offset++) {  
            i = byteDigest[offset];  
            if (i < 0)  
                i += 256;  
            if (i < 16)  
                buf.append("0");  
            buf.append(Integer.toHexString(i));  
        }  
        //32位加密  
        return buf.toString();  
        // 16位的加密  
        //return buf.toString().substring(8, 24);   
    } catch (NoSuchAlgorithmException e) {  
        e.printStackTrace();  
        return null;  
    }  
      
}  
	
	
	  public static String connect(String strUrl,String jsonstr) throws Exception {
			
			HttpURLConnection httpUrlConn = null;
			InputStream inputStream = null; 
			OutputStream outputStream = null;
			
			BufferedReader reader = null;
	        OutputStreamWriter writer = null;
	        
	        String strMessage = "";
	        StringBuffer buffer = new StringBuffer();
	        
			try {
				URL url = new URL(strUrl);
				httpUrlConn = (HttpURLConnection) url.openConnection();
				System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
	            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); 
				httpUrlConn.setDoInput(true);
				httpUrlConn.setDoOutput(true);
				httpUrlConn.setRequestMethod("POST");
				httpUrlConn.setRequestProperty("content-type", "text/html");
				httpUrlConn.setAllowUserInteraction(true);
				httpUrlConn.setRequestProperty("Accept-Charset", "UTF-8");
				httpUrlConn.connect();
				
				outputStream = httpUrlConn.getOutputStream();
				//outputStream.write(jsonstr.getBytes());
				//outputStream.flush();
				//outputStream.close();
				 writer = new OutputStreamWriter(outputStream);
		         writer.write(jsonstr);
		         writer.flush();
		         writer.close();
				
				/*inputStream = httpUrlConn.getInputStream();
				Reader read = new InputStreamReader(inputStream, "GBK");
				Document doc = reader.read(read);
				doc.setXMLEncoding("UTF-8");*/
				
		         inputStream = httpUrlConn.getInputStream();
		         reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
		         while ((strMessage = reader.readLine()) != null) {
		        	 if(strMessage.indexOf("?xml")>-1)
		        	 {
		        	 	        		 strMessage="<?xml version='1.0' encoding='utf-8'?>";
		        	 }
		             buffer.append(strMessage);
		         }
		         //System.out.println("1212------------------"+buffer.toString());
		         if (buffer.length() < 1){
		            throw new Exception("  message is null ");
		         };
				
			} catch (IOException ioe) {
				ioe.printStackTrace();
				throw new IOException(ioe.getMessage());
			}catch (Exception e) {
				e.printStackTrace();
				throw new Exception("exception", e);
			} finally {
				if(outputStream!=null)
	        		outputStream.close();
	        	 if (writer != null) {
	        		 writer.close();
	             }
	        	 if(inputStream!=null)
	         		inputStream.close();
	            if (reader != null) {
	                reader.close();
	            }
	            if(httpUrlConn!=null)
	            {
	            	httpUrlConn.disconnect();
	            }
	          return  buffer.toString();
			}
		}
}
