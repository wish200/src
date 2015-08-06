package com.huiting.exception;



import org.apache.log4j.Logger;

/**
 * 框架初始化异常。
 * 整个框架在初始化时的运行时异常。
 * 
 * @author HanYan
 * @date 2015-01-16
 */
public class FrameworkInitializeException extends RuntimeException {

	private static final long serialVersionUID = 897833178212140120L;
	private static final Logger log = Logger.getLogger(FrameworkInitializeException.class);
	
	public FrameworkInitializeException() {
		super("An Unkown Exception occured!");
	}
	
	public FrameworkInitializeException(String errMsg) {
		super(errMsg);
	}
	
	public FrameworkInitializeException(String errMsg, Exception e) {
		super(errMsg, e);
	}

	@Override
	public void printStackTrace() {
		log.error("An exception occurs when the framework initializing.", this);
	}
}
