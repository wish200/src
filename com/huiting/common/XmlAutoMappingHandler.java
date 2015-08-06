package com.huiting.common;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Element;

import com.huiting.common.interf.XmlMappingHandler;
import com.huiting.exception.FrameworkInitializeException;
import com.huiting.exception.HuiTingException;
import com.huiting.exception.XmlMappingException;


/**
 * XML自动映射处理器。用来进行XML节点与Java对象的自动映射。
 * <b>节点须依赖Dom4j中的Element类型</b>
 * 
 * @author HanYan
 * @date 2015-01-08
 */
public class XmlAutoMappingHandler implements XmlMappingHandler {
	
	/**
	 * 通过给定XML节点和映射类型生成对应的JAVA对象。
	 * 
	 * @param e 需要转换的XML节点
	 * @param c 对应的映射类的Class
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public <T> T marshal(Element e, Class<T> c) {
		if (e == null || c == null) {
			return null;
		}
		List<BeanUtil.Entry> methods = BeanUtil.getSetter(c);
		String value;
		Object temp;
		T instance = null;
		Class<?> paramClass;// 方法的参数类型
		try {
			instance = c.newInstance();
			for (BeanUtil.Entry m : methods) {//遍历所有set方法。
				if(e.attributeValue(m.getName())!=null){
					value = e.elementText(m.getName());
				}else{
					value = e.elementText(m.getName());
				}
				
				paramClass = m.getMethod().getParameterTypes()[0];//获取该set方法的参数类型
				
				if (paramClass == String.class) {
					temp = (value == null) ? "" : value;
				} else if (paramClass == int.class || paramClass == Integer.class) {
					temp = (value == null) ? 0 : Integer.parseInt(value);
				} else if (paramClass == long.class || paramClass == Long.class) {
					temp = (value == null) ? 0L : Long.parseLong(value);
				} else if (paramClass == double.class || paramClass == Double.class) {
					temp = (value == null) ? 0D : Double.parseDouble(value);
				} else if (paramClass == boolean.class || paramClass == Boolean.class) {
					temp = (value == null) ? null : Boolean.parseBoolean(value);
				} else if (paramClass == float.class || paramClass == Float.class) {
					temp = (value == null) ? 0F : Float.parseFloat(value);
				} else if (paramClass == short.class || paramClass == Short.class) {
					temp = (value == null) ? (short)0 : Short.parseShort(value);
				} else if (paramClass == char.class || paramClass == Character.class) {
					temp = (value == null) ? '0' : value.charAt(0);
				} else if (paramClass == byte.class || paramClass == Byte.class) {
					temp = (value == null) ? (byte)0 : Byte.parseByte(value);
				} else if (paramClass == java.sql.Date.class) {// java.sql.Date
					temp = (value == null) ? null : java.sql.Date.valueOf(value);
				} else if (paramClass == java.sql.Timestamp.class) {// java.sql.Timestamp
					temp = (value == null) ? null : java.sql.Timestamp.valueOf(value);
				} else if (paramClass == java.util.Date.class) {// java.util.Date
					temp = (value == null) ? null : new java.util.Date(value);
				} else if (List.class.isAssignableFrom(paramClass)) {// java.util.List
					if (m.getMethod().getGenericParameterTypes().length == 0) {
						throw new XmlMappingException("Dose not support that java.util.List without non-generic.");
					}
					Type type = m.getMethod().getGenericParameterTypes()[0];
					Class<?> clazz = null;// 泛型中的类型
					if (type instanceof ParameterizedType) {
						temp = new ArrayList();
						clazz = (Class<?>)((ParameterizedType)type).getActualTypeArguments()[0];
						for (Element element : (List<Element>)e.elements(m.getName())) {
							((ArrayList)temp).add(marshal(element, clazz));
						}
					} else {
						temp = null;
					}
				} else if (Set.class.isAssignableFrom(paramClass)) {// java.util.Set
					throw new XmlMappingException("The data type of java.util.Set hasn't been support.");
				} else if (Map.class.isAssignableFrom(paramClass)) {// java.util.Map
					throw new XmlMappingException("The data type of java.util.Map hasn't been support.");
				} else if (paramClass.isArray()) {// Array
					throw new XmlMappingException("The data type of Array hasn't been support.");
				} else {// 是对象类型。
					temp = marshal(e.element(m.getName()), paramClass);
				}
				m.getMethod().invoke(instance, temp);
			}
		} catch (InstantiationException ex) {
			throw new XmlMappingException("XmpMappingException:", ex);
		} catch (IllegalAccessException ex) {
			throw new XmlMappingException("XmpMappingException:", ex);
		} catch (InvocationTargetException ex) {
			throw new XmlMappingException("XmpMappingException:", ex);
		}
		
		return instance;
	}
	
	public static <T> T marshalByXml(Element e, Class<T> c)  {
		if (e == null || c == null) {
			return null;
		}
		List<BeanUtil.Entry> methods = BeanUtil.getSetter(c);
		String value;
		Object temp;
		T instance = null;
		Class<?> paramClass;// 方法的参数类型
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String elementname="";
		String elementtext = "";
		String attributename="";
		java.lang.reflect.Field  field;
		try {
			instance = c.newInstance();
			for(Iterator it=e.elementIterator();it.hasNext();){
				 Element element = (Element) it.next();
				 elementname=element.getName();
				 attributename = element.attributeValue("key");
				 if(attributename!=null&&!"attributename".equals(attributename)){
					 elementname = attributename;
				 }
				 value = element.getText();
				 if(elementtext!=null&&!"".equals(elementtext)||1==1){
					 try{
						 field = c.getDeclaredField(elementname);
					 }catch (NoSuchFieldException ex) {
						 System.out.println("elementname--"+elementname+c.getName());
						 if(value!=null&&!"".equals(value)){
							 ex.printStackTrace();
						 }
							continue;
					 }
					 field.setAccessible(true);
					 paramClass = field.getType();
					 
					 if (paramClass == String.class) {
							temp = (value == null) ? "" : value;
							//System.out.println(elementname+"-"+paramClass);
						} else if (paramClass == int.class || paramClass == Integer.class) {
							temp = (value == null|| "".equals(value)) ? 0 : Integer.parseInt(value);
						} else if (paramClass == long.class || paramClass == Long.class) {
							temp = (value == null|| "".equals(value)) ? 0L : Long.parseLong(value);
						} else if (paramClass == double.class || paramClass == Double.class) {
							temp = (value == null || "".equals(value)) ? 0D : Double.parseDouble(value);
						} else if (paramClass == boolean.class || paramClass == Boolean.class) {
							temp = (value == null|| "".equals(value)) ? null : Boolean.parseBoolean(value);
						} else if (paramClass == float.class || paramClass == Float.class) {
							temp = (value == null|| "".equals(value)) ? 0F : Float.parseFloat(value);
						} else if (paramClass == short.class || paramClass == Short.class) {
							temp = (value == null|| "".equals(value)) ? (short)0 : Short.parseShort(value);
						} else if (paramClass == char.class || paramClass == Character.class) {
							temp = (value == null|| "".equals(value)) ? '0' : value.charAt(0);
						} else if (paramClass == byte.class || paramClass == Byte.class) {
							temp = (value == null) ? (byte)0 : Byte.parseByte(value);
						} else if (paramClass == java.sql.Date.class) {// java.sql.Date
							temp = (value == null|| "".equals(value)) ? null : java.sql.Date.valueOf(value);
						} else if (paramClass == java.sql.Timestamp.class) {// java.sql.Timestamp
							temp = (value == null|| "".equals(value)) ? null : java.sql.Timestamp.valueOf(value);
						} else if (paramClass == java.util.Date.class) {// java.util.Date
							temp = (value == null|| "".equals(value)) ? null : format.parse(value);
						} else if (List.class.isAssignableFrom(paramClass)) {// java.util.List
							if (((java.lang.reflect.ParameterizedType)field.getGenericType()).getActualTypeArguments().length == 0) {
								throw new XmlMappingException("Dose not support that java.util.List without non-generic.");
							}
							Type type = ((java.lang.reflect.ParameterizedType)field.getGenericType());
							Class<?> clazz = null;// 泛型中的类型
							if (type instanceof ParameterizedType) {
								temp = (ArrayList)BeanUtil.getFieldValue(instance, elementname);
								if(temp==null){
									temp = new ArrayList();
								}
								clazz = (Class<?>)((ParameterizedType)type).getActualTypeArguments()[0];
								//for (Element element : (List<Element>)e.elements(m.getName())) {
								//System.out.println(element.getName()+"-"+clazz);
									((ArrayList)temp).add(marshalByXml(element, clazz));
								//}
							} else {
								temp = null;
							}
						} else if (Set.class.isAssignableFrom(paramClass)) {// java.util.Set
							throw new XmlMappingException("The data type of java.util.Set hasn't been support.");
						} else if (Map.class.isAssignableFrom(paramClass)) {// java.util.Map
							throw new XmlMappingException("The data type of java.util.Map hasn't been support.");
						} else if (paramClass.isArray()) {// Array
							throw new XmlMappingException("The data type of Array hasn't been support.");
						} else {// 是对象类型。
							temp = marshalByXml(element, paramClass);
						}
					 
					 field.set(instance, temp);
				 }
			}
		} catch (InstantiationException ex) {
			throw new HuiTingException("数据格式异常", ex);
		} catch (IllegalAccessException ex) {
			throw new HuiTingException("数据格式异常", ex);
		} catch (ParseException ex) {
			throw new HuiTingException("数据格式异常", ex);
		} 
		
		return instance;
	}
	
	/**
	 * 根据给定JAVA对象，解析成DOM4J中的元素对象Element，用于生成XML文档。
	 * 
	 * @param e
	 * @param obj
	 * @return
	 */
	public Element unmarshal(Element e, Object obj) {
		if (e == null || obj == null) {
			return null;
		}
		Class<?> c = null;
		List<BeanUtil.Entry> methods = BeanUtil.getGetter(obj.getClass());
		Object value;
		try {
			for (BeanUtil.Entry m : methods) {//遍历所有get方法。
				value = m.getMethod().invoke(obj);
				
				if (value == null) {
					e.addElement(m.getName()).setText("");
				} else {
					c = value.getClass();
					if (c.isPrimitive() || c == String.class || c == java.sql.Date.class 
							|| c == java.sql.Timestamp.class || c == java.util.Date.class) {
						e.addElement(m.getName()).setText(String.valueOf(value));
					} else if (Collection.class.isAssignableFrom(c)) {// java.util.Collection
						for (Object o : (Collection<?>)value) {
							unmarshal(e.addElement(m.getName()), o);
						}
					} else if (c.isArray()) {
						throw new XmlMappingException("The data type of Array hasn't been support.");
					} else if (Map.class.isAssignableFrom(c)) {
						throw new XmlMappingException("The data type of java.util.Map hasn't been support.");
					} else {// 是对象类型。
						unmarshal(e.addElement(m.getName()), value);
					}
				}
			}
		} catch (IllegalAccessException ex) {
			throw new XmlMappingException("XmpMappingException:", ex);
		} catch (InvocationTargetException ex) {
			throw new XmlMappingException("XmpMappingException:", ex);
		}
		
		return e;
	}
	
	public Element unmarshalByXml(Element e, Object obj) {
		if (e == null || obj == null) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Class<?> c = null;
		List<BeanUtil.Entry> methods = BeanUtil.getGetter(obj.getClass());
		Object value;
		try {
			//for (BeanUtil.Entry m : methods) {//遍历所有get方法。
			Field[] f = obj.getClass().getDeclaredFields();
			for(Field field :f){
				value = BeanUtil.getFieldValue(obj, field.getName());
				//System.out.println("field.getName()-------------"+field.getName()+"---"+obj.getClass().getName());
				 if (value == null) {
					e.addElement(field.getName()).setText("");
				} else {
					c = value.getClass();
					if (c.isPrimitive() || c == String.class || c == java.lang.Double.class|| c == java.lang.Integer.class|| c == java.sql.Date.class 
							|| c == java.sql.Timestamp.class || c == java.util.Date.class) {
						if( c == java.sql.Timestamp.class){
							e.addElement(field.getName()).setText(formatter.format(value));
						}else{
							e.addElement(field.getName()).setText(String.valueOf(value));
						}
						
					} else if (Collection.class.isAssignableFrom(c)) {// java.util.Collection
						for (Object o : (Collection<?>)value) {
							unmarshalByXml(e.addElement(field.getName()), o);
						}
					} else if (c.isArray()) {
						throw new XmlMappingException("The data type of Array hasn't been support.");
					} else if (Map.class.isAssignableFrom(c)) {
						throw new XmlMappingException("The data type of java.util.Map hasn't been support.");
					} else {// 是对象类型。
						unmarshalByXml(e.addElement(field.getName()), value);
					}
				}
			}
		}catch (FrameworkInitializeException  ex) {
			ex.printStackTrace();
			throw ex;
		}
		
		return e;
	}
}
