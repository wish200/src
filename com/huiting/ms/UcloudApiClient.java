package com.huiting.ms;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author songcy
 *  
 * to  send  sms
 * 
 */

public class UcloudApiClient {

	private Map<String, String> g_params = null;
	private UConnection uconn = null;
	private String access_token = null;
	
	
	/**
	 * 设置 短信 参数 
	 * @param base_url 
	 * @param public_key
	 * @param private_key
	 * @param region_id 默认值为1
	 * @param zone_id 默认值为1
	 */
	public UcloudApiClient(String base_url, String public_key,
			String private_key, int region_id, int zone_id) {
		g_params = new TreeMap<String, String>();
		g_params.put("public_key", public_key);
		g_params.put("region_id", region_id + "");
		g_params.put("zone_id", zone_id + "");
	}

	/**
	 * 设置短信 资源地址 内容 电话
	 * @param resouse  默认 /monitor/sendsms
	 * @param phone
	 * @param content
	 * @return  status string
	 */
	public String SendPost(String resouse, String phone, String content) {

		g_params.put("phone", "[\"" + phone + "\"]");

		// 设置编码
		try {
			g_params.put("content", new String(content.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 生成 access_token
		access_token = Verfy_ac(MSConfig.public_key, g_params);
		g_params.put("access_token", access_token);
		uconn = new UConnection(MSConfig.base_url);
		
		
		 /*Iterator it = g_params.keySet().iterator();  
	        while (it.hasNext()) {  
	            //it.next()得到的是key，tm.get(key)得到obj  
	            System.out.println(g_params.get(it.next()));  
	        } */
	        
		return uconn.SendPost(resouse, g_params);

	}

	/**
	 * 将content phone public_key region_id
	 *  zone_id private_key 以及对应的value进行
	 *  SHA-1 编码 生成 access_token
	 *  
	 * @param public_key
	 * @param params
	 * @return access_token string
	 */
	private String Verfy_ac(String public_key, Map<String, String> params) {

		String paramstr = "";
		String sha1rs = null;

		for (Map.Entry<String, String> e : params.entrySet()) {
			paramstr += e.getKey();
			paramstr += e.getValue();
		}

		paramstr += MSConfig.private_key;

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] sha1bytes = md.digest(paramstr.getBytes());
			sha1rs = bytetoString(sha1bytes);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sha1rs;
	}

	/**
	 * @param bytes
	 * @return String 
	 */
	private String bytetoString(byte[] bytes) {

		String str = "";
		String tempStr = "";

		for (int i = 0; i < bytes.length; i++) {
			tempStr = (Integer.toHexString(bytes[i] & 0xff));
			if (tempStr.length() == 1) {
				str = str + "0" + tempStr;
			} else {
				str = str + tempStr;
			}
		}
		return str.toLowerCase();
	}

}
