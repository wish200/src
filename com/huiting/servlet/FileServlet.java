package com.huiting.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileServlet extends HttpServlet{

	public FileServlet() {
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
	                       String paramValue = item.getString();    
	                       System.out.println(paramName + ":" + paramValue);    
	                   } else {    
	                       //上传文件信息处理    
	                       String fileName = item.getName();
	                       System.out.println(fileName+ item.getFieldName());
	                       String filePath = getServletContext().getRealPath("/files") + "/" + fileName;
	                       item.write(new File(filePath));
	                       /*byte[] data = item.get();    
	                       System.out.println("filePath="+filePath);
	                       FileOutputStream fos = new FileOutputStream(filePath);    
	                       fos.write(data);    
	                       fos.close(); */   
	                   }    
	               }    
	           } catch (FileUploadException e) {    
	               e.printStackTrace();    
	           }  catch (Exception e1) {    
	               e1.printStackTrace();    
	           }    
	       }  
	       response.getWriter().write("UPLOAD_SUCCESS"); 
			
			
			
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
