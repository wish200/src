package com.huiting.common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestDto2 {
	
	
	public TestDto2() {
		
	}
	private String appki ="";
	private String insure ="";
	private String kind ="";
	private ArrayList<String> list = new  ArrayList<String>();
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}
	public String getAppki() {
		return appki;
	}
	public void setAppki(String appki) {
		this.appki = appki;
	}
	public String getInsure() {
		return insure;
	}
	public void setInsure(String insure) {
		this.insure = insure;
	}
	public static void main(String[] arg) {
		TestDto1 t1= new TestDto1();
		TestDto2 t2= new TestDto2();
		
		t1.setItem("1");
		t1.setKind("kind");
		ArrayList<String> a=new ArrayList<String>();
		a.add("1");a.add("a");
		t1.setList(a);
		 BeanUtil.coverBean2Dto(t1, t2);
		//BeanUtil.printInvoke(t2);
		 
		
		BeanUtil.printInvoke(t2);System.out.println(t2.getList().get(0));
		
	}
	
	
}
