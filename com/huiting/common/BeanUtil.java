package com.huiting.common;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * 对JavaBean一些操作的工具类。
 * 
 * @author HanYan
 * @date 2015-01-08
 */
public class BeanUtil {
	
	/**
	 * JavaBean的Set方法的集合的缓存。
	 */
	private final static Map<String, List<Entry>> SET_METHODS_CACHE = new Hashtable<String, List<Entry>>();
	/**
	 * JavaBean的Get方法的集合的缓存。
	 */
	private final static Map<String, List<Entry>> GET_METHODS_CACHE = new Hashtable<String, List<Entry>>();
	
	/**
	 * 获取某个JavaBean的所有成员属性的get方法，以List形式返回，并缓存。
	 * @param type
	 * @return
	 */
	public static List<Entry> getGetter(Class<?> type) {
		List<Entry> result = GET_METHODS_CACHE.get(type.getName());
		if (result == null) {
			result = getGetter(type, null);
			GET_METHODS_CACHE.put(type.getName(), result);
		}
		return result;
	}
	
	/**
	 * 根据指定列名，获取某个JavaBean的所有成员属性的get方法，以List形式返回。
	 * @param type
	 * @param args
	 * @return
	 */
	public static List<Entry> getGetter(Class<?> type, String[] args) {
		BeanInfo info = null;
		List<Entry> params = new ArrayList<Entry>();
		try {
			info = Introspector.getBeanInfo(type);
			PropertyDescriptor[] pd = info.getPropertyDescriptors();
			Method readMethod = null;
			Method writeMethod = null;
			for (int i = 0; i < pd.length; i++) {
				if (args != null) {// 如果有指定列名，则匹配指定的列名。
					for (int j = 0; j < args.length; j++) {
						if (args[j].equalsIgnoreCase(pd[i].getDisplayName())) {
							readMethod = pd[i].getReadMethod();
							writeMethod = pd[i].getWriteMethod();
							break;
						}
					}
				} else {
					readMethod = pd[i].getReadMethod();
					writeMethod = pd[i].getWriteMethod();
				}
				
				if (readMethod != null && writeMethod != null) {//必须同时存在getter and setter才认为是Bean的属性。
					params.add(new Entry(pd[i].getName(), readMethod));
				}
			}
		} catch (IntrospectionException e) {
			throw new RuntimeException(e);
		} finally {
			info = null;
		}
		return params;
	}
	
	/**
	 * 获取某个JavaBean的所有成员属性的set方法，以List形式返回，并缓存。
	 * @param type
	 * @return
	 */
	public static List<Entry> getSetter(Class<?> type) {
		List<Entry> result = SET_METHODS_CACHE.get(type.getName());
		if (result == null) {
			result = getSetter(type, null);
			SET_METHODS_CACHE.put(type.getName(), result);
		}
		return result;
	}
	
	/**
	 * 根据给定Class对象和属性名称，获取其所有属性的set方法。
	 * @param type
	 * @param args 指定的属性名
	 * @return
	 */
	public static List<Entry> getSetter(Class<?> type, String[] args) {
		BeanInfo info = null;
		List<Entry> params = new ArrayList<Entry>();
		try {
			info = Introspector.getBeanInfo(type);
			PropertyDescriptor[] pd = info.getPropertyDescriptors();
			Method readMethod = null;
			Method writeMethod = null;
			for (int i = 0; i < pd.length; i++) {
				if (args != null) {// 如果有指定列名，则匹配指定的列名。
					for (int j = 0; j < args.length; j++) {
						if (args[j].equalsIgnoreCase(pd[i].getDisplayName())) {
							readMethod = pd[i].getReadMethod();
							writeMethod = pd[i].getWriteMethod();
							break;
						}
					}
				} else {
					readMethod = pd[i].getReadMethod();
					writeMethod = pd[i].getWriteMethod();
				}
				
				if (readMethod != null && writeMethod != null) {//必须同时存在getter and setter才认为是Bean的属性。
					params.add(new Entry(pd[i].getName(), writeMethod));
				}
			}
		} catch (IntrospectionException e) {
			throw new RuntimeException(e);
		} finally {
			info = null;
		}
		return params;
	}
	
	/**
	 * 将给定Object实例的数组转换成其对应Class类型的数组。
	 * @param objs
	 * @return
	 */
	public static Class<?>[] getClassArray(Object[] objs) {
		if (objs == null) {
			return null;
		}
		Class<?>[] result = new Class<?>[objs.length];
		for (int i = 0; i < objs.length; i++) {
			result[i] = objs[i].getClass();
		}
		return result;
	}
	
	public static Object getFieldValue(Object o,String fieldname){
		Object object= null ;
		if(o== null||fieldname==null||"".equals(fieldname)){
			return "";
		}
		try {
			Method method = o.getClass().getMethod("get"+fieldname,null);
			object = method.invoke(o, null);
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * Main方法，用来调试。
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	/**
	 * 贮存属性名-属性方法的节点。
	 * 
	 * @author HanYan
	 * @date 2015-01-08
	 */
	static class Entry {
		
		private String name;
		private Method method;
		
		public Entry(String name, Method method) {
			super();
			this.name = name;
			this.method = method;
		}

		public Method getMethod() {
			return method;
		}
		public void setMethod(Method method) {
			this.method = method;
		}
		public String getName() {
			return name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((method == null) ? 0 : method.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (method == null) {
				if (other.method != null)
					return false;
			} else if (!method.equals(other.method))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	}
	
	/*
	 * 把JavaBean的from的值自动set给to，省略了自己从from中get然后再set给to
	 */
	public static Object convertBean2Bean(Object from, Object to) {   
        try {   
            BeanInfo beanInfo = Introspector.getBeanInfo(to.getClass());   
            PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();   
  
            for (PropertyDescriptor p : ps) {   
               Method getMethod = p.getReadMethod();  
               Method setMethod = p.getWriteMethod();   
               if (getMethod != null && setMethod != null) {   
                   try {    System.out.println(getMethod.getName()); 
                      Object result = getMethod.invoke(from);    System.out.println("1-"+result.toString()); 
                      setMethod.invoke(to, result); System.out.println(result.toString());  
                   } catch (Exception e) {    System.out.println("1"); 
                      // 如果from没有此属性的get方法，跳过   
                      continue;   
                   }   
               }   
            }   
        } catch (Exception e) {   
           e.printStackTrace();   
        }   
  
        return to;   
    }   
	/*
	 * 把JavaBean值自动set给Dto,不同对象的复制
	 */
	public static Object convertBean2Dto(Object from, Object to) {   
         
		Object value;
		Field[] f = to.getClass().getDeclaredFields();
		
		for(Field field :f){
			try{
				value = getFieldValue(from, field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
				field.setAccessible(true);
				field.set(to, value);
			}catch(Exception e ){
				continue;
			}
		} 	
         
  
        return to;   
    }   
	/**  
     * 不支持to继承(to是其他bean的子类)  
     */   
   public static Object coverBean2Dto(Object from, Object to) {   
        Class fClass = from.getClass();   
        Class tClass = to.getClass();   
        // 拿to所有属性（如果有继承，父类属性拿不到）   
        Field[] cFields = tClass.getDeclaredFields();   
        try {   
            for (Field field : cFields) {   
               String cKey = field.getName();   
               // 确定第一个字母大写   
               cKey = cKey.substring(0, 1).toUpperCase() + cKey.substring(1);   
  
               Method fMethod;   
               Object fValue;   
               try {   
                    fMethod = fClass.getMethod("get" + cKey);// public方法   
                    fValue = fMethod.invoke(from);// 取getfKey的值   
               } catch (Exception e) {   
                 // 如果from没有此属性的get方法，跳过   
                 continue;   
               }   
  
                try {   
                    // 用fMethod.getReturnType()，而不用fValue.getClass()   
                    // 为了保证get方法时，参数类型是基本类型而传入对象时会找不到方法   
                    Method cMethod = tClass.getMethod("set" + cKey, fMethod.getReturnType());   
                    cMethod.invoke(to, fValue);   
                } catch (Exception e) {   
                    // 如果to没有此属性set方法，跳过   
                    continue;   
                }   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
  
        return to;   
    }   
   
   static final String spare = "======================================================\r\n"; 
   /**      * 打印bean信息  
    */   
  public static void printInvoke(Object object) {   
     Method[] ms = object.getClass().getMethods();   
     String str = spare;   
     str += "start log object: " + object.getClass().getSimpleName() + "\r\n";   
     str += spare;   
     System.out.print(str);   
 
     for (int i = 0; i < ms.length; i++) {   
        if (ms[i].getName().indexOf("get") != -1   
            && !ms[i].getName().equals("getClass")) {   
            try {   
                System.out.println(ms[i].getName() + " = "   
                + ms[i].invoke(object));   
            } catch (Exception e) {   
                e.printStackTrace();   
            }   
        }   
     }   
 
    System.out.println(spare);   
  }   
	
}
