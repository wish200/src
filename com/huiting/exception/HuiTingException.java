package com.huiting.exception;


import org.apache.log4j.Logger;

/**
 * XML映射异常。
 * Java对象与XML互相映射时抛出的异常。
 * 
 * @author HanYan
 * @date 2015-01-08
 */
public class HuiTingException extends RuntimeException {

	private static final long serialVersionUID = 897833178317740120L;
	private static final Logger log = Logger.getLogger(HuiTingException.class);
	private String errMsg = "";
	
	public HuiTingException() {
		super("An Unkown Exception occured!");
	}
	
	public HuiTingException(String errMsg) {
		super(errMsg);
		this.errMsg = errMsg;
	}
	
	public HuiTingException(String errMsg, Exception e) {
		super(errMsg, e);
		this.errMsg = errMsg;
	}

	@Override
	public void printStackTrace() {
		log.error(errMsg);
		log.error("An exception occurs when the object serialized to xml or unserialized from xml.", this);
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

 
	
}
