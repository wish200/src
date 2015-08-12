package com.huiting.common;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestDto extends Test{
	
	
	
	public TestDto() {
		
	}

	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	private String Name ="";
	private int Count =0;
	private double Amount;
	private TestDto1 testDto1 = new TestDto1();
	private ArrayList<TestDto2>  dto2List= new ArrayList<TestDto2>();
	 
	
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public TestDto1 getTestDto1() {
		return testDto1;
	}
	public void setTestDto1(TestDto1 testDto1) {
		this.testDto1 = testDto1;
	}
	
	
	public ArrayList<TestDto2> getDto2List() {
		return dto2List;
	}
	public void setDto2List(ArrayList<TestDto2> dto2List) {
		this.dto2List = dto2List;
	}
	
	
	public static void main(String[] agr){
		TestDto1 t1= new TestDto1();t1.setItem("item");t1.setKind("kind");
		TestDto2 t2 = new TestDto2();t2.setAppki("appki");t2.setInsure("insured");
		TestDto2 t21 = new TestDto2();t21.setAppki("appki1");t21.setInsure("insured1");
		ArrayList<TestDto2> arrayList = new ArrayList<TestDto2>();
		ArrayList a = new ArrayList();a.add("1");a.add("10");//a.add(20);
		arrayList.add(t2);
		arrayList.add(t21);//a.add(arrayList);
		
		TestDto t = new TestDto();
		t.setAmount(10);
		t.setDto2List(arrayList);
		t.setCount(1);
		//t.setName("name");
		t.setTestDto1(t1);
		String jsonString =JSON.toJSONString(t);
		System.out.println(jsonString);
		try{
			jsonString="{\"createtime\":\"2015-07-02 12:46:52\",\"userid\":\"aaa\",\"requesttype\":\"01\",\"amount\":10,\"count\":1,\"dto2List\":[{\"appki\":\"appki\",\"insure\":\"insured\"},{\"appki\":\"appki1\",\"insure\":\"insured1\"}],\"name\":\"\",\"testDto1\":{\"item\":\"item\",\"kind\":\"kind\"}}";
			JSONObject jo = JSON.parseObject(jsonString);
			TestDto ttDto = 	JSON.parseObject(jsonString,TestDto.class);
			//TestDto ttDto = 	JSON.toJavaObject(jo, TestDto.class);
			
			/*System.out.println(ttDto.getDto2List().get(0).getAppki()+ttDto.getDto2List().get(0).getInsure());
			System.out.println(ttDto.getRequesttype()+ttDto.getUserid()+"---"+ttDto.getCreateTime());
			
			Test1 test1 =JSON.parseObject(jsonString,Test1.class);
			System.out.println(test1.getUserid());
			
			Object t22 = new TestDto();
			t.setAmount(10);
			t.setDto2List(arrayList);
			t.setCount(1);
			System.out.println(JSON.toJSONString(t22,SerializerFeature.WriteDateUseDateFormat));
			
						*/
			 System.out.println(new TestDto().getClass());
			
		}catch(Exception e ){
		e.printStackTrace();	
		}
	}
}
