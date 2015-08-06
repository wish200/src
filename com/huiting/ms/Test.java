package com.huiting.ms;


public class Test {

	public static void main(String[] args) {
		
		UcloudApiClient uapiclient = new UcloudApiClient(MSConfig.base_url,
				MSConfig.public_key, MSConfig.private_key, 1, 1);

		String rs = null;

		// 发送短信 
		 rs = uapiclient.SendPost("/monitor/sendsms", "15800981549", "\u5185\u90e8\u9519\u8bef \u8bf7\u8054\u7cfb\u552e\u524d\u652f\u6301\uff0cQQ\uff1a4000188113");
		 System.out.println(rs);
		 rs=new String("\u5185\u90e8\u9519\u8bef \u8bf7\u8054\u7cfb\u552e\u524d\u652f\u6301\uff0cQQ\uff1a4000188113");
		
		//System.out.println(rs.replaceAll("\"","").startsWith("{ret_code:0"));
		System.out.println(rs);
	}

}