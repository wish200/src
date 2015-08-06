package com.huiting.action;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
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

public class HuiTingAction  implements Action{

	private static final Logger log = Logger.getLogger(HuiTingAction.class);
	private BLXml blXml ;
	private ServiceDefaultFactory serviceFactory;
	ResHeadBean  resHeader = new ResHeadBean();
	ReqHeadBean reqHeader = new ReqHeadBean();
	
	public String execute() throws Exception {
		String result ="";
		HttpServletRequest req = ServletActionContext.getRequest();
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is1 = null;
		BufferedReader readerr = null;
		StringBuffer buffer = new StringBuffer();
		PrintWriter out = null;
		log.info("sign-"+req.getParameter("sign"));
		String httphead = "Encoding:"+req.getCharacterEncoding()+";ContentType:"+req.getContentType()+";ReqAddr:"+req.getRemoteAddr()+";ReqPort:"+req.getRemotePort()+";ReqURI:"+req.getRequestURI();
		
		try {
			
			
			byte[] bs = new byte[1024];
			int len;
			while ((len = req.getInputStream().read(bs)) > -1) {
			    baos.write(bs, 0, len);
			}
			baos.flush();
			is1 = new ByteArrayInputStream(baos.toByteArray());
			//readerr = new BufferedReader(new InputStreamReader(is1));
			readerr = new BufferedReader(new InputStreamReader(is1,"utf-8"));
			String strMessage = "";
			while ((strMessage = readerr.readLine()) != null) {
				buffer.append(strMessage);
			}
			log.info("请求报文:"+buffer.toString());
			if(buffer.length()<1){
				buffer = new StringBuffer();
				System.out.println("message is null");
				buffer.append(req.getParameter("sign"));
			}
			
			result = parseJson(buffer.toString(),httphead);

			log.info("返回报文:"+result);
			out = resp.getWriter();
			out.write(result);
			out.flush();
		}catch(Exception exception ){
			exception.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
		
		
		return null;
	}
	
	public String parseJson(String jsonstr,String httpHead) throws ParseException{
		if(jsonstr==null||"".equals(jsonstr)||"null".equals(jsonstr)){
			return "message is null";
		}
		System.out.println("jsonstr request---"+jsonstr);
		String resultjson ="";
		String requestType = "";
		Object reshead;
		
		try {
			JSONObject jo = JSON.parseObject(jsonstr.toLowerCase());
			requestType = jo.getString("RequestType");
			
			reqHeader = JSON.parseObject(jsonstr, ReqHeadBean.class);
					  
			//保存请求报文
			if(blXml==null){
				blXml = (BLXml)SpringBeanFactory.lookup("blXml");
			}
			
			blXml.save(blXml.convertReq(reqHeader, jsonstr.length()>1000?jsonstr.substring(0, 1000):jsonstr ,httpHead.length()>500?httpHead.substring(0, 500):httpHead));
			
			System.out.println("serviceFactory-"+serviceFactory);
			//动态获取请求json对应dto类
			if(serviceFactory==null){
				serviceFactory = (ServiceDefaultFactory)SpringBeanFactory.lookup("ServiceDefaultFactory");
			}
			Class dtoClass = serviceFactory.getServiceParamClass("HuiTing", reqHeader.getRequestType());
			
			//解析json到对应dto类
			Object dtoObject = JSON.parseObject(jsonstr, dtoClass);
			
			//找到对应的业务类执行业务逻辑处理,并返回处理结果dto对象
			Object ores = serviceFactory.invokeFromMapping("HuiTing", reqHeader.getRequestType(),dtoObject);
			
			//根据返回对象生成json document
			resultjson = JSON.toJSONString(ores,SerializerFeature.WriteDateUseDateFormat);
			System.out.println("resultjson----="+resultjson);
			
			//获取返回头信息
			resHeader= JSON.parseObject(resultjson, ResHeadBean.class);;
			
			//保存返回json报文
			blXml.save(blXml.convertRes(resHeader, resultjson.length()>500?resultjson.substring(0, 500):resultjson));
			
			
			
		}catch(HuiTingException te ){
			te.printStackTrace();
			reshead = genResponseHeadXml(reqHeader,te.getErrMsg());
			resultjson = JSON.toJSONString(reshead,SerializerFeature.WriteDateUseDateFormat);
		}catch(FrameworkInitializeException fe ){
			fe.printStackTrace();
			reshead =genResponseHeadXml(reqHeader,"内部异常");
			resultjson = JSON.toJSONString(reshead,SerializerFeature.WriteDateUseDateFormat);
		}catch(Exception e ){
			e.printStackTrace();
			reshead =genResponseHeadXml(reqHeader,"系统错误");
			resultjson = JSON.toJSONString(reshead,SerializerFeature.WriteDateUseDateFormat);
		}
		return resultjson;
	}
	
	public String parse(String xml,String httpHead) throws ParseException{
		if(xml==null||"".equals(xml)||"null".equals(xml)){
			return "message is null";
		}
		Document document = null;
		Document documentres = DocumentHelper.createDocument();
		Object reshead;
		
		 
		Element root;
		Element packageElement;
		
		try {	
			document = DocumentHelper.parseText(xml);
		
			root= document.getRootElement();
			//packageElement=root.element("HuiTing");
			
		
			//解析请求头信息，需要对应的dto
			reqHeader = new XmlAutoMappingHandler().marshalByXml(root.element("Header"), ReqHeadBean.class);
			
			//保存请求报文
			if(blXml==null){
				blXml = (BLXml)SpringBeanFactory.lookup("blXml");
			}
			
			blXml.save(blXml.convertReq(reqHeader, xml.length()>1000?xml.substring(0, 1000):xml ,httpHead.length()>500?httpHead.substring(0, 500):httpHead));
			
			//动态获取请求xml对应dto类
			if(serviceFactory==null){
				serviceFactory = (ServiceDefaultFactory)SpringBeanFactory.lookup("ServiceDefaultFactory");
			}
			Class dtoClass = serviceFactory.getServiceParamClass("HuiTing", reqHeader.getRequestType());
			
			//解析xml到对应dto类
			Object dtoObject = new XmlAutoMappingHandler().marshalByXml(root, dtoClass);
			
			//找到对应的业务类执行业务逻辑处理,并返回处理结果dto对象
			Object ores = serviceFactory.invokeFromMapping("HuiTing", reqHeader.getRequestType(),dtoObject);
			
			//根据返回对象生成xml document
			new XmlAutoMappingHandler().unmarshalByXml(documentres.addElement("HuiTing"), ores);
			
			
			//获取返回头信息
			resHeader= (ResHeadBean)serviceFactory.invokeGet("getHeader", ores);
			
			//保存返回xml报文
			blXml.save(blXml.convertRes(resHeader, documentres.asXML().length()>500?documentres.asXML().substring(0, 500):documentres.asXML()));
			
			
			
		}catch(HuiTingException te ){
			te.printStackTrace();
			reshead = genResponseHeadXml(reqHeader,te.getErrMsg());
			new XmlAutoMappingHandler().unmarshal(documentres.addElement("HuiTing").addElement("Header"), reshead);
		}catch(FrameworkInitializeException fe ){
			fe.printStackTrace();
			reshead =genResponseHeadXml(reqHeader,"内部异常");
			new XmlAutoMappingHandler().unmarshal(documentres.addElement("HuiTing").addElement("Header"), reshead);
		}catch(Exception e ){
			e.printStackTrace();
			reshead =genResponseHeadXml(reqHeader,"系统错误");
			new XmlAutoMappingHandler().unmarshal(documentres.addElement("HuiTing").addElement("Header"), reshead);
		}
		return documentres.asXML();
	}
	
	public ResHeadBean genResponseHeadXml(ReqHeadBean reqHeader,String error){
		ResHeadBean resHeadBean = new ResHeadBean(); 
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

	public BLXml getBlXml() {
		return blXml;
	}

	public void setBlXml(BLXml blXml) {
		this.blXml = blXml;
	}

	public ServiceDefaultFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ServiceDefaultFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	
	
	
}
