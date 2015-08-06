package com.huiting.common;

import java.util.ArrayList;

public class TestDto1 {
	
	
	public TestDto1() {
		super();
	}
	private String item="";
	private String kind ="";
	private ArrayList<String> list = new  ArrayList<String>();
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
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
	
	
}
