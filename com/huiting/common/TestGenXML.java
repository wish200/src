package com.huiting.common;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.huiting.exception.XmlMappingException;

public class TestGenXML {
	private static Date date = new Date();  
	  private static StringBuilder buf = new StringBuilder();  
	  private static int seq = 0;  
	  private static final int ROTATION = 99999; 
	  
	  public static synchronized long next(){  
	    if (seq > ROTATION) seq = 0;  
	    buf.delete(0, buf.length());  
	    date.setTime(System.currentTimeMillis());  
	    String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);  
	    
	    return Long.parseLong(str);  
	  }  
	
	 public static void main(String[] arg){
		 System.out.println(next());
	 }
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
					c = value.getClass();
					if (value == null) {
						e.addElement(m.getName()).setText("");
					} else {
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
	 
}
