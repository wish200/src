package com.huiting.common.interf;

import org.dom4j.Element;

/**
 * XML映射处理器。用来进行XML节点与Java对象的映射。
 * <b>节点须依赖Dom4j中的Element类型</b>
 * 
 * @author HanYan
 * @date 2015-01-08
 */
public interface XmlMappingHandler {
	
	/**
	 * 解析XML节点，并根据类型生成Java实例。
	 * @param <T>
	 * @param e Dom4j中的Element类型
	 * @param c 生成实例的类型
	 * @return
	 */
	public <T> T marshal(Element e, Class<T> c);
	
	/**
	 * 根据传入的Java对象组织XML节点，并返回。
	 * @param <T>
	 * @param e Dom4j中的Element类型
	 * @param c 生成实例的类型
	 * @return
	 */
	public Element unmarshal(Element e, Object obj);
}
