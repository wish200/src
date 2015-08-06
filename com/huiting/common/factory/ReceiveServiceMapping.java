package com.huiting.common.factory;


/**
 * 配置所有微信推送类型的配置文件的映射类。
 * 目前通过msgType+event(if exist)确定唯一映射。
 * 
 * @author HanYan
 * @date 2015-01-19
 */
public class ReceiveServiceMapping {
	
	private String name;
	private String type;
	private String method;
	private String paramClass;
	private String service;
	private String serviceid;
	
	public ReceiveServiceMapping() {
		super();
	}
	public ReceiveServiceMapping(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getParamClass() {
		return paramClass;
	}
	public void setParamClass(String paramClass) {
		this.paramClass = paramClass;
	}

	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getServiceid() {
		return serviceid;
	}
	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

	

}
