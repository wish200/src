package com.huiting.action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.huiting.common.SpringBeanFactory;
import com.huiting.common.XmlAutoMappingHandler;
import com.huiting.common.factory.ServiceDefaultFactory;
import com.huiting.exception.FrameworkInitializeException;
import com.huiting.exception.HuiTingException;
import com.huiting.xml.bean.ReqHeadBean;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.bl.BLXml;
import com.huiting.xml.userregist.bl.BLUserRegist;
import com.opensymphony.xwork2.Action;

public class TestHuiTingAction  implements Action{

	private static final Logger log = Logger.getLogger(TestHuiTingAction.class);
	 
	
	public String execute() throws Exception {
		System.out.println("-------------start------------");
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		//boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		//System.out.println("-------------isMultipart------------"+isMultipart);
		//System.out.println(req.getParameter("name"));
		
		BufferedReader reader = null;
		String strMessage="";
		StringBuffer buffer = new StringBuffer();
		 try{
	        	reader = new BufferedReader(new InputStreamReader(req.getInputStream(),"utf-8"));
		        //reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		        while ((strMessage = reader.readLine()) != null) {
		             buffer.append(strMessage);
		         }
		        
		        System.out.println("100-----taobaointerface receive data-------------------"+buffer.toString());
				//System.out.println(new URLDecoder().decode(buffer.toString(),"utf-8"));
				
		        
	        }catch (IOException e){
	        	e.printStackTrace(); 
	        	throw new IOException(e.getMessage());
	        	
	        }finally{
	        	if(reader!=null){
	        		reader.close();
	        	}
	        	
	        }
		
		
		
		
		/*if (isMultipart) {    
	           FileItemFactory factory = new DiskFileItemFactory();    
	           ServletFileUpload upload = new ServletFileUpload(factory);    
	           try {    
	               List items = upload.parseRequest(req);    
	               Iterator iter = items.iterator();    
	               while (iter.hasNext()) {    
	                   FileItem item = (FileItem) iter.next(); 
	                   System.out.println("-------------item------------"+item.getFieldName());
	                   if (item.isFormField()) {    
	                       //普通文本信息处理    
	                       String paramName = item.getFieldName();    
	                       String paramValue = item.getString();    
	                       System.out.println(paramName + ":" + paramValue);    
	                   } else {    
	                       //上传文件信息处理    
	                       String fileName = item.getName();    
	                       byte[] data = item.get();    
	                       String filePath = req.getSession().getServletContext().getRealPath("/files") + "/" + fileName;
	                       System.out.println("filePath=="+filePath);
	                       FileOutputStream fos = new FileOutputStream(filePath);    
	                       fos.write(data);    
	                       fos.close();    
	                   }    
	               }    
	           } catch (FileUploadException e) {    
	               e.printStackTrace();    
	           }    
	       }    */
		System.out.println("-------------------------------");
		
		return null;
	}
	
	 
	
}
