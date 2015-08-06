package com.huiting.servlet;
 
import java.io.File; 
import java.io.IOException; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.huiting.action.HuiTingAction;
import com.huiting.cache.SystemCache;
import com.huiting.common.XmlAutoMappingHandler;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.uploadheadpic.bl.BLUploadHeadPic;

public class UploadServlet extends HttpServlet{

	public UploadServlet() {
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
		String resultjsonString = "";
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
		 Map<String, String> paramMap = new HashMap<String, String>();
		 String filePath1 ="";
		 String filePath ="";
		 File file = null;
		 SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMM");
		 String yearmonth =  sdf.format(new java.util.Date());
			
		 String httphead = "Encoding:"+request.getCharacterEncoding()+";ContentType:"+request.getContentType()+";ReqAddr:"+request.getRemoteAddr()+";ReqPort:"+request.getRemotePort()+";ReqURI:"+request.getRequestURI();
	       if (isMultipart) {    
	           FileItemFactory factory = new DiskFileItemFactory();    
	           ServletFileUpload upload = new ServletFileUpload(factory);   
	           
	           try {    
	               List items = upload.parseRequest(request);    
	               Iterator iter = items.iterator();    
	               while (iter.hasNext()) {    
	                   FileItem item = (FileItem) iter.next();
	                   System.out.println("itemname="+item.getFieldName());
	                   if (item.isFormField()) {    
	                       //普通文本信息处理    
	                       String paramName = item.getFieldName();    
	                       String paramValue = item.getString("utf-8");  
	                       paramMap.put(paramName, paramValue);
	                       System.out.println(paramName + ":" + paramValue);    
	                   } else {    
	                       //上传文件信息处理    
	                       String fileName = item.getName();
	                       fileName = UUID.randomUUID().toString().replace("-", "")+fileName.substring(fileName.indexOf("."));
	                       System.out.println("item.getFieldName()-"+item.getFieldName());
	                       paramMap.put(item.getFieldName(), fileName);
	                       filePath1 = SystemCache.getCache("file.savedir")==null?"files":SystemCache.getCache("file.savedir");
	                       file = new File(getServletContext().getRealPath("/"+filePath1));
	                       if(!file.exists()){
	                    		  file.mkdir(); 
	                       }
	                        
	                       if(paramMap.get("UserID")!=null){
	                    	   filePath1 =getServletContext().getRealPath("/"+filePath1) + "/"+hashfile(paramMap.get("UserID"))+ "/"+paramMap.get("UserID")+ "/"+yearmonth;
	                    	   file = new File(filePath1);
	                    	   if(!file.exists()){
	                    		  file.mkdir(); 
	                    	   }
	                    	   filePath = getServletContext().getRealPath("/"+filePath1) + "/"+paramMap.get("UserID")+"/" + fileName;
	                    	   
	                       }else{
	                    	   file = new File(getServletContext().getRealPath("/"+filePath1) + "/"+yearmonth);
	                    	   if(!file.exists()){
	                    		  file.mkdir(); 
	                    	   }
	                    	   filePath = getServletContext().getRealPath("/"+filePath1) + "/" + fileName;
	                       }
	                       item.write(new File(filePath));
	                       paramMap.put("filepath", filePath.substring(filePath.indexOf(filePath1)));
	                       /*byte[] data = item.get();    
	                       System.out.println("filePath="+filePath);
	                       FileOutputStream fos = new FileOutputStream(filePath);    
	                       fos.write(data);    
	                       fos.close(); */   
	                   }    
	               }   
	               System.out.println(filePath.substring(filePath.indexOf(filePath1)));
	               resultjsonString = new HuiTingAction().parseJson(JSON.toJSONString(paramMap), httphead);
	               System.out.println("resultjsonString--"+resultjsonString);
	           } catch (FileUploadException e) {    
	               e.printStackTrace();   
	               resultjsonString=genResponseHeadXml(paramMap,"系统错误");
	               
	           }  catch (Exception e1) {    
	               e1.printStackTrace();    
	               resultjsonString= genResponseHeadXml(paramMap,"系统错误");
	           }    
	       }  
	       response.getWriter().write(resultjsonString); 
	       response.getWriter().close();
			
			
	}
	
	public String genResponseHeadXml(Map<String, String> map,String error){
		ResHeadBean resHeadBean = new ResHeadBean(); 
		resHeadBean.setRequestType(map.get("RequestType"));
		resHeadBean.setSendTime(new Timestamp(System.currentTimeMillis()));
		resHeadBean.setUUID(map.get("UUID"));
		resHeadBean.setErrorMessage(error);
		if(error!=null&&!"".equals(error)){
			resHeadBean.setResponseCode("1");
		}else{
			resHeadBean.setResponseCode("0");
		}
		
		return JSON.toJSONString(resHeadBean);
	}
	
	public String hashfile(String UserID){
		int hash = hash(UserID.hashCode());
		int i = hash & 1023;
		return i+"";
	}
	
	static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
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
