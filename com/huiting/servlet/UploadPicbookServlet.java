package com.huiting.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import com.alibaba.fastjson.JSON;
import com.huiting.cache.SystemCache;
import com.huiting.common.XmlAutoMappingHandler;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.picbookpublish.bean.ResponseBean;
import com.huiting.xml.picbookpublish.bl.BLPicbookPublish;

public class UploadPicbookServlet extends HttpServlet{

	public UploadPicbookServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
        doPost(request,response);
		 
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
		 ResponseBean resHuiTingBean = new ResponseBean();
		 Map<String, String> paramMap = new HashMap<String, String>();
		 Document documentres = DocumentHelper.createDocument();
		 
	       if (isMultipart) {    
	           FileItemFactory factory = new DiskFileItemFactory();    
	           ServletFileUpload upload = new ServletFileUpload(factory);  
	           upload.setHeaderEncoding("utf-8");
	           
	           try {    
	               List items = upload.parseRequest(request);  
	               Iterator iter = items.iterator(); 
	               String paramName = "";
	               String paramValue = "";
	               String filePath1  = "";
	               String filePath  = "";
	               File file =null;
	               while (iter.hasNext()) {    
	                   FileItem item = (FileItem) iter.next();
	                   if (item.isFormField()) {    
	                       //普通文本信息处理    
	                	   paramName = item.getFieldName();   
	                       paramValue = item.getString("utf-8");  
	                       paramMap.put(paramName, paramValue);
	                       System.out.println("itemname="+item.getFieldName()+item.getString("utf-8"));
	                   } else {    
	                       //上传文件信息处理    
	                       String fileName = item.getName();
	                       
	                       System.out.println("1-"+item.getFieldName()+fileName);
	                       filePath1 = SystemCache.getCache("file.savedir")==null?"files":SystemCache.getCache("file.savedir");
	                       file = new File(getServletContext().getRealPath("/"+filePath1));
	                       if(!file.exists()){
	                    		  file.mkdir(); 
	                       }
	                       
	                       if(paramMap.get("UserID")!=null){
	                    	   file = new File(getServletContext().getRealPath("/"+filePath1) + "/"+paramMap.get("UserID"));
	                    	   if(!file.exists()){
	                    		  file.mkdir(); 
	                    	   }
	                    	   filePath = getServletContext().getRealPath("/"+filePath1) + "/"+paramMap.get("UserID")+"/" + fileName;
	                       }else{
	                    	   filePath = getServletContext().getRealPath("/"+filePath1) + "/" + fileName;
	                       }
	                        
	                       item.write(new File(filePath));
	                       paramMap.put(item.getFieldName(), filePath.substring(filePath.indexOf(filePath1)));
	                       /*byte[] data = item.get();    
	                       System.out.println("filePath="+filePath);
	                       FileOutputStream fos = new FileOutputStream(filePath);    
	                       fos.write(data);    
	                       fos.close(); */   
	                   }    
	               }   
	             //  resHuiTingBean = (ResponseBean)new BLPicbookPublish().handleXML(paramMap);
	               
	           } catch (FileUploadException e) {    
	               e.printStackTrace();   
	               genResponseHeadXml(paramMap,resHuiTingBean ,"系统错误");
	           }  catch (Exception e1) {    
	               e1.printStackTrace();    
	               genResponseHeadXml(paramMap,resHuiTingBean ,"系统错误");
	           }    
	       }
	       response.getWriter().write(JSON.toJSONString(resHuiTingBean)); 
	       response.getWriter().close();
			
			
	}
	
	public ResHeadBean genResponseHeadXml(Map<String, String> map,ResHeadBean resHeadBean ,String error){
		resHeadBean.setRequestType(map.get("RequestType"));
		resHeadBean.setSendTime(new Timestamp(System.currentTimeMillis()));
		resHeadBean.setUUID(map.get("UUID"));
		resHeadBean.setErrorMessage(error);
		if(error!=null&&!"".equals(error)){
			resHeadBean.setResponseCode("1");
		}else{
			resHeadBean.setResponseCode("0");
		}
		
		return resHeadBean;
	}

	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		System.out.println("-------------init--------------------");
		String v = this.getInitParameter("a"); 
		System.out.println("-------------a--------------------"+v);
        Enumeration e = this.getInitParameterNames(); 
        while(e.hasMoreElements()){ 
            System.out.println(">>haha>>"+e.nextElement()); 
        } 
		try {
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         
	}
}
