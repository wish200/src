package com.huiting.exception;


import org.apache.log4j.Logger;

/**
 * XML映射异常。
 * Java对象与XML互相映射时抛出的异常。
 * 
 * @author HanYan
 * @date 2015-01-08
 */
public class XmlMappingException extends RuntimeException {

	private static final long serialVersionUID = 897833178317740120L;
	private static final Logger log = Logger.getLogger(XmlMappingException.class);
	
	public XmlMappingException() {
		super("An Unkown Exception occured!");
	}
	
	public XmlMappingException(String errMsg) {
		super(errMsg);
	}
	
	public XmlMappingException(String errMsg, Exception e) {
		super(errMsg, e);
	}

	@Override
	public void printStackTrace() {
		log.error("An exception occurs when the object serialized to xml or unserialized from xml.", this);
	}
}
