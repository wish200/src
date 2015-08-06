package com.huiting.xml.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;
import org.apache.log4j.Logger;

import com.huiting.common.StringUtil;
import com.huiting.ms.MSConfig;
import com.huiting.ms.UcloudApiClient;
import com.huiting.xml.dao.SMSVerifyCodeDao;
import com.huiting.xml.dto.SMSVerifyCodeDto; 

public class BLSmsAction  extends TimerTask{
	private final static Logger log = Logger.getLogger(BLSmsAction.class);
	private static Map<String, String> cache = new Hashtable<String, String>();
	private static int verifyCodeLength = 6;
	private static long checkTime = 5*1000;
	private static long validTime = 5*1000;
	private static long genCodeTime = 15000;
	
	static{

		try {
			log.info("blSmsAction初始化开始...");
			Properties prop = new Properties();
			InputStream is = null;
			File file = new File(BLSmsAction.class.getResource("").toURI().getPath()+"smsverify.properties");
			
			if (!file.exists()) {
				//throw new BusinessException("获取配置文件路径失败，未找到的路径:" + file.getPath());
				log.warn("smsaction donot have config file,using the default value");
			}else{
				try {
					is = new FileInputStream(file);
					prop.load(is);
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						is.close();
					} catch (Exception e) {
					}
				}
				
				Iterator<Entry<Object, Object>> iterator = prop.entrySet().iterator();
				while (iterator.hasNext()) {// 将配置文件中的配置信息加载到缓存中。
					Entry<Object, Object> e = iterator.next();
					cache.put((String)e.getKey(), (String)e.getValue());
				}
				if(cache.get("sms.verifyCodeLength")!=null&&!"".equals(cache.get("sms.verifyCodeLength"))){
					verifyCodeLength = Integer.parseInt((cache.get("sms.verifyCodeLength")));
				}
				if(cache.get("sms.checkTime")!=null&&!"".equals(cache.get("sms.checkTime"))){
					checkTime = Long.parseLong((cache.get("sms.checkTime")));
				}
				if(cache.get("sms.validTime")!=null&&!"".equals(cache.get("sms.validTime"))){
					validTime = Long.parseLong((cache.get("sms.validTime")));
				}
				if(cache.get("sms.genCodeTime")!=null&&!"".equals(cache.get("sms.genCodeTime"))){
					genCodeTime = Long.parseLong((cache.get("sms.genCodeTime")));
				}
				log.info("blSmsAction初始化完成...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
		
		 Thread t = new SMSCache();
		 t.start();
	 }
	
	public BLSmsAction() {
		super();
	}

	public String genVerifyCode(SMSVerifyCodeDto sMSVerifyCodeDto){
		if(sMSVerifyCodeDto==null||!StringUtil.isPhoneNumber(sMSVerifyCodeDto.getPhoneNumber())){
			//return "phonenumber is not correct";
		}
		String randomcode="";
		String smscontent="";
		
		if(SMSCache.map.containsKey(sMSVerifyCodeDto)){
			SMSVerifyCodeDto smsverifybeanmap = SMSCache.map.get(sMSVerifyCodeDto);
			if(System.currentTimeMillis()- smsverifybeanmap.getCreateTime().getTime()<= genCodeTime){
				return "请15秒后再获取验证码";
			}
		}else{
			randomcode = genRandom();
		}
		
		if(!"".equals(sMSVerifyCodeDto.getSourceType())){
			if(cache.get(sMSVerifyCodeDto.getSourceType())!=null&&!"".equals(sMSVerifyCodeDto.getSourceType())){
				smscontent =  cache.get(sMSVerifyCodeDto.getSourceType()) ;
			}else{
				//smscontent=sMSVerifyCodeDto.getSourceType();
			}
		}
		smscontent =smscontent+ "短信验证码为"+randomcode+",请勿泄漏";
		sMSVerifyCodeDto.setSmsCode(randomcode);
		System.out.println(sMSVerifyCodeDto.getPhoneNumber()+"-gen-"+sMSVerifyCodeDto.getSmsCode()+sMSVerifyCodeDto.getSourceType());
		sMSVerifyCodeDto.setCreateTime(new Timestamp(System.currentTimeMillis()));
		SMSCache.map.put(sMSVerifyCodeDto, sMSVerifyCodeDto);
		try {
			sendMS(sMSVerifyCodeDto.getPhoneNumber(),smscontent);
		} catch (Exception e) {
			randomcode = "sms platform is error";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return randomcode;
	}
	
	public String sendMS(String phonenumber,String content) throws Exception {
		UcloudApiClient uapiclient = new UcloudApiClient(MSConfig.base_url,
				MSConfig.public_key, MSConfig.private_key, 1, 1);
		String result=uapiclient.SendPost("/monitor/sendsms", phonenumber, content);
		log.info(result);
		if(!result.replaceAll("\"","").startsWith("{ret_code:0")){
			log.error("未发送短信:     "+phonenumber+"--"+content);
		}
		return result;
	}
	
	public String genRandom(){
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
		    int index = rand.nextInt(i);
		    int tmp = array[index];
		    array[index] = array[i - 1];
		    array[i - 1] = tmp;
		}
		int result = 0;
		String str = "";
		for(int i = 0; i < verifyCodeLength ; i++)
		    result = result * 10 + array[i];
		//System.out.println(result);
		str = String.valueOf(result);
		if(str.length()==5){
			str = "0"+str; 
		}
		return str;
	}
	
	public String VerifyCode(SMSVerifyCodeDto sMSVerifyCodeDto){
		String result = "";System.out.println(sMSVerifyCodeDto.getPhoneNumber()+"-ver-"+sMSVerifyCodeDto.getSmsCode()+sMSVerifyCodeDto.getSourceType());
		System.out.println(SMSCache.map.containsKey(sMSVerifyCodeDto));
		if(SMSCache.map.containsKey(sMSVerifyCodeDto)){
			SMSVerifyCodeDto smsverifybeanmap = (SMSVerifyCodeDto)SMSCache.map.get(sMSVerifyCodeDto);
			smsverifybeanmap.setVerifyTime(new Timestamp(System.currentTimeMillis()));
			SMSCache.map.put(smsverifybeanmap, smsverifybeanmap);
			if(!smsverifybeanmap.getSmsCode().equals(sMSVerifyCodeDto.getSmsCode())){
				result="verifycode is invalid";
			}else if(smsverifybeanmap.getVerifyTime().getTime()- smsverifybeanmap.getCreateTime().getTime()<= validTime){
				result= "success";
			}else{
				result= "verifycode is time out";
			}
		}else{
			result="verifycode is invalid";
		}
		System.out.println("-------------"+result);
		return result;
	}
	private static class SMSCache extends  Thread{
		 static Hashtable<SMSVerifyCodeDto, SMSVerifyCodeDto> map = new Hashtable<SMSVerifyCodeDto, SMSVerifyCodeDto>();
		 
		 public void manageCache() throws InterruptedException{
			 synchronized (map) { 
				 Enumeration<SMSVerifyCodeDto> e = map.keys();
				 while (e.hasMoreElements()) {
					 SMSVerifyCodeDto sMSVerifyCodeDto = e.nextElement();
					 System.out.println(sMSVerifyCodeDto.getPhoneNumber()+"-ver--"+sMSVerifyCodeDto.getSmsCode());
					 if(System.currentTimeMillis()- sMSVerifyCodeDto.getCreateTime().getTime()> validTime
							 || sMSVerifyCodeDto.getVerifyTime() != null ){
						 System.out.println(sMSVerifyCodeDto.getPhoneNumber()+"-remove--"+sMSVerifyCodeDto.getSmsCode());
						 map.remove(sMSVerifyCodeDto);
						 List<SMSVerifyCodeDto> beanlist = new ArrayList();
						 beanlist.add(sMSVerifyCodeDto);
						 try{
							 //new SMSVerifyCodeDao().insertlist(beanlist);
							 ((SMSVerifyCodeDao)com.huiting.common.SpringBeanFactory.lookup("sMSVerifyCodeDao")).insertlist(beanlist);
						 }catch(Exception e1 ){
							 e1.printStackTrace();
						 }
						 
					 }
				 }
			 }
		 }
		 


		public void run(){
				 
				 try {
					while(true){
						manageCache(); 
						this.sleep(checkTime);
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 public SMSCache() {
				super();
			}
		 
	}
	public  static void main(String[] arg) throws ParseException{
		BLSmsAction a = new BLSmsAction();
		Timer timer  = new Timer();
		String time = " 09:24:01";
		SimpleDateFormat sdf2   = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		String startTime =  sdf.format(new java.util.Date()) +time;
		//timer.schedule(new BLSmsAction(), sdf2.parse(startTime), 1*1000);
		//Map a1 = SMSCache.map;
	}
	public void run() {
		// TODO Auto-generated method stub
		Random rand = new Random(100);
		int i = rand.nextInt(100);
		SMSVerifyCodeDto a = new SMSVerifyCodeDto();
		a.setPhoneNumber(i+"");
		System.out.println(i);
		this.genVerifyCode(a);
	}
	 
	
}
