package com.huiting.common.factory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.huiting.common.SpringBeanFactory;
import com.huiting.exception.FrameworkInitializeException;



/**
 * 生产实际调用的某个业务服务的工厂。
 * 在使用之前必须先进行初始化。
 * 配置文件是.properties文件，键值对分别为：
 * <p>key-全限定类名；</p>
 * <p>value-是否单例(singleton)</p>
 * 配置的类实现相对应的服务的接口即可识别。同样，当使用服务集合初始化时，实例所属类实现各接口。
 * 
 * @author HanYan
 * @date 2015-01-19
 */
public class ServiceDefaultFactory  {
	
	private static final String CONFIG_FILE_NAME = "service.xml";
	/*private static final ConcurrentHashMap<String, ReceiveServiceMapping> serviceCache = 
		new ConcurrentHashMap<String, ReceiveServiceMapping>();*/
	private static final HashMap<String, ReceiveServiceMapping> serviceCache = 
		new HashMap<String, ReceiveServiceMapping>();
	
	/**
	 * 通过指定配置文件进行初始化。
	 * @param file
	 */
	public void init() {
		init_XmlMapping();
		
	}
	
	/**
	 * 初始化映射文件。
	 */
	@SuppressWarnings("unchecked")
	private void init_XmlMapping() {
		Document document = null;
		SAXReader reader = new SAXReader();
		String key;
		try {
			document = reader.read(ServiceDefaultFactory.class.getResourceAsStream("/"+CONFIG_FILE_NAME));
			Element root = document.getRootElement();
			List<Element> elementList = root.elements("service");
			for (Element e : elementList) {
				ReceiveServiceMapping mapping = new ReceiveServiceMapping(e.attributeValue("name"), e.attributeValue("type"));
				mapping.setMethod(e.attributeValue("method"));
				mapping.setParamClass(e.attributeValue("param"));
				mapping.setService(e.attributeValue("class"));
				mapping.setServiceid(e.attributeValue("classid"));
				//mapping.setDtoClass((Class<? extends ReqBaseMessageDto>)Class.forName(e.attributeValue("param")));
				//mapping.setInterfaceClass((Class<? extends WeixinService>)Class.forName(e.attributeValue("interface")));
				//mapping.setService(Class.forName(e.attributeValue("class")).newInstance());
				key = mapping.getName()+mapping.getType();
				serviceCache.put(key, mapping);
			}
			System.out.println("------------services factory init success---");
		} catch (DocumentException e) {
			throw new FrameworkInitializeException("Document well-formedness error.", e);
		}finally {
			reader = null;
		}
	}
	
	/**
	 * 通过给定的远程服务的标识，获取本地服务实例。
	 * @param serviceName
	 * @param version
	 * @param method
	 * @return
	 */
	public synchronized Class getServiceParamClass(String name, String type) {
		ReceiveServiceMapping mapping = serviceCache.get(name+type);
		Class paramClass = null;
		
		if (mapping != null && !"".equals(mapping.getParamClass())) {
			try {
				paramClass =  Class.forName(mapping.getParamClass());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new FrameworkInitializeException("getServiceParamClass  failed.", e);
			}
		}
		return paramClass;
	}
 
	public  Object invokeFromMapping(String name, String type , Object dtoObject) {
		ReceiveServiceMapping mapping = serviceCache.get(name+type);
		Object returnObject = null;
		Object instanceObject ;
		Class paramClazz;
		Class serviceClazz;
		
		if (mapping != null && !"".equals(mapping.getParamClass())) {
			try {
				paramClazz =  Class.forName(mapping.getParamClass());
				serviceClazz = Class.forName(mapping.getService());
				Method method = serviceClazz.getMethod(mapping.getMethod(), paramClazz);
				instanceObject = SpringBeanFactory.lookup(mapping.getServiceid());
				if(instanceObject==null){
					instanceObject = serviceClazz.newInstance();
				}
				System.out.println(method.getName()+instanceObject.getClass());
				returnObject = method.invoke(instanceObject, dtoObject);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new FrameworkInitializeException("getServiceParamClass  failed.", e);
			} 
		}
		return returnObject;
	}
	public  Object invokeGet(String methodname , Object dtoObject) {
		Object returnObject = null;
		
			try { 
				Method method = dtoObject.getClass().getMethod(methodname, null);
				returnObject = method.invoke(dtoObject, null);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new FrameworkInitializeException("getServiceParamClass  failed.", e);
			} 
		
		return returnObject;
	}

	
	
}
