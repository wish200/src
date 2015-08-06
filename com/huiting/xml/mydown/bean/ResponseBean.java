package com.huiting.xml.mydown.bean;



import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	private ArrayList<ProgramListBean> ProgramList = new  ArrayList<ProgramListBean>();

	public ArrayList<ProgramListBean> getProgramList() {
		return ProgramList;
	}

	public void setProgramList(ArrayList<ProgramListBean> programList) {
		ProgramList = programList;
	}

	
	
	
	
	
	
}
