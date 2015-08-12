package com.huiting.action;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class requestdemo {
	private static final String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
	private static final String PREFIX = "--";
	private static final String LINE_END = "\r\n";
	private static final String CONTENT_TYPE = "multipart/form-data"; // 内容类型

	private static final String TAG = "UploadUtil";
	private int readTimeOut = 10 * 1000; // 读取超时
	private int connectTimeout = 10 * 1000; // 超时时间
	/***
	* 请求使用多长时间
	*/
	private static int requestTime = 0;

	private static final String CHARSET = "utf-8"; // 设置编码

	/***
	* 上传成功
	*/
	public static final int UPLOAD_SUCCESS_CODE = 1;
	/**
	* 文件不存在
	*/
	public static final int UPLOAD_FILE_NOT_EXISTS_CODE = 2;
	/**
	* 服务器出错
	*/
	public static final int UPLOAD_SERVER_ERROR_CODE = 3;
	protected static final int WHAT_TO_UPLOAD = 1;
	protected static final int WHAT_UPLOAD_DONE = 2;
	
	public static void main(String[] arg){
		Map<String, String> param = new HashMap<String, String>();
		HashMap<String, String> fileHashMap = new HashMap<String, String>();
		
		
		/*param.put("UserID", "6127445");
		param.put("NickName", "哈哈");
		param.put("RequestType", "T05");		
		fileHashMap.put("UserPic", "D://test.png");
		
		param.put("RequestType", "T06");		
		fileHashMap.put("BackGroundPIC", "D://test.png");*/
		
		// audio
		/*param.put("UserID", "5216767");
		param.put("NickName", "怪蜀黍");
		param.put("RequestType", "T02");
		param.put("AudioName", "天生一对");
		param.put("AudioSource", "");
		param.put("AudioLength", "05:20");
		param.put("AudioContent", "睡觉了");
		
		fileHashMap.put("filepath", "D:\\07\\天生一对.mp3");*/
		
		
		//picbook
		param.put("UserID", "5255427");
		param.put("NickName", "哈哈");
		param.put("RequestType", "T01");
		param.put("PicbookName", "谢雨桐");
		param.put("PicScene", "场景");
		param.put("PicBookSource", "");
		
		fileHashMap.put("filepath", "D:\\07\\谢雨桐 男.jpg");
		
		
		/*param.put("PicbookUserID", "huitu");
		param.put("PicbookID", "P6173657");
		param.put("PicbookName", "huitu");
		param.put("PicbookURL", "http://120.132.70.11:8080/huiting/files/5216767/huitu.png");
		param.put("PicScene", "场景");
		param.put("UserID", "5216767");
		param.put("NickName", "哈哈");
		param.put("UserPic", "http://120.132.70.11:8080/huiting/files/5216767/test.png");
		param.put("AudioName", "跑啊跑");
		param.put("AudioLength", "3:20");
		param.put("AudioContent", "大酱");
		param.put("RequestType", "T04");
		fileHashMap.put("filepath", "D://mingxing1.mp3");*/
		
		
		/*param.put("PicbookID", "");
		param.put("PicbookName", "test1");
		param.put("PicScene", "场景1");
		param.put("UserID", "5216767");
		param.put("NickName", "哈哈");
		param.put("UserPic", "http://120.132.70.11:8080/huiting/files/5216767/test.png");
		param.put("AudioID", "A7322524");
		param.put("AudioUserID", "52167671");
		param.put("AudioName", "mingxing.mp3");
		param.put("AudioURL", "http://120.132.70.11:8080/huiting/files/5216767/mingxing.mp3");
		param.put("AudioLength", "05:20");
		param.put("AudioContent", "河水哗啦啦啦");
		param.put("RequestType", "T03");
		fileHashMap.put("filepath", "D://test.png");*/
		
		
		/*param.put("RequestType", "C08");
		param.put("ActivityName", "那么");
		param.put("ActivityType", "01");
		param.put("ActivityDESC", "aaaa");
		fileHashMap.put("filepath", "D://test.png");*/
		
		//new requestdemo().uploadFile("D://test.png","testfilekey",RequestURL,param);
		//new requestdemo().uploadFile("D://mingxing.mp3","testfilekey",RequestURL,param);
		
		String RequestURL ="http://120.132.70.11:8080/huiting/UploadServlet";
		
		
		
		new requestdemo().uploadFile(fileHashMap,RequestURL,param);
	}
	
	
	public void uploadFile(String filePath, String fileKey, String RequestURL,
			Map<String, String> param) {
			if (filePath == null) {
			System.out.println("文件不存在1");
			return;
			}
			try {
			File file = new File(filePath);
			uploadFile(file, fileKey, RequestURL, param);
			} catch (Exception e) {
				System.out.println("文件不存在2");
			e.printStackTrace();
			return;
			}
	}
	public void uploadFile(final HashMap<String, String> filemHashMap, final String RequestURL, final Map<String, String> param) {
		Iterator iter = filemHashMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			if(entry.getValue()==null||"".equals(entry.getValue().toString())){
				System.out.println("文件不存在1");
				return;
			}
		}
		new Thread(new Runnable() { //开启线程上传文件
			public void run() {
				toUploadFile(filemHashMap, RequestURL, param);
			}
			}).start();
	}

	public void uploadFile(final File file, final String fileKey,
	final String RequestURL, final Map<String, String> param) {
		if (file == null || (!file.exists())) {
			System.out.println("文件不存在3");
		    return;
		}
	
			
			new Thread(new Runnable() { //开启线程上传文件
			public void run() {
				toUploadFile(file, fileKey, RequestURL, param);
			}
			}).start();
		
	}
	
	private void toUploadFile(HashMap<String, String> filemHashMap, String RequestURL,
			Map<String, String> param) {
			String result = null;
			requestTime= 0;

			long requestTime = System.currentTimeMillis();
			long responseTime = 0;

			try {
			URL url = new URL(RequestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(readTimeOut);
			conn.setConnectTimeout(connectTimeout);
			conn.setDoInput(true); // 允许输入流
			conn.setDoOutput(true); // 允许输出流
			conn.setUseCaches(false); // 不允许使用缓存
			conn.setRequestMethod("POST"); // 请求方式
			conn.setRequestProperty("Charset", CHARSET); // 设置编码
			conn.setRequestProperty("Accept-Charset", CHARSET);
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
			// conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			/**
			* 当文件不为空，把文件包装并且上传
			*/
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			StringBuffer sb = null;
			String params = "";

			/***
			* 以下是用于上传参数
			*/
			if (param != null && param.size() > 0) {
				Iterator<String> it = param.keySet().iterator();
					while (it.hasNext()) {
					sb = null;
					sb = new StringBuffer();
					String key = it.next();
					String value = param.get(key);
					sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
					sb.append("Content-Disposition: form-data; name=\"").append(key).append("\"").append(LINE_END).append(LINE_END);
					sb.append(value).append(LINE_END);
					params = sb.toString();
					//Log.i(TAG, key+"="+params+"##");
					System.out.println(params);
					dos.write(params.getBytes());
					// dos.flush();
					}
			}

			sb = null;
			params = null;
			
			/**
			* 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
			* filename是文件的名字，包含后缀名的 比如:abc.png
			*/
			
			Iterator iter = filemHashMap.entrySet().iterator();
			Map.Entry entry = null;
			File file = null;
			String fileKey = "";
			while (iter.hasNext()) {
				sb = new StringBuffer();
				 entry = (Map.Entry) iter.next();
				//Object key = entry.getKey();
				//Object val = entry.getValue();
				 fileKey = entry.getKey().toString();
				 file = new File(entry.getValue().toString());
				 if (file == null || (!file.exists())) {
						System.out.println("文件不存在3");
					    return;
				 }
				 
				 sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
					sb.append("Content-Disposition:form-data; name=\"" + fileKey
					+ "\"; filename=\"" + file.getName() + "\"" + LINE_END);
					//sb.append("Content-Type:image/pjpeg" + LINE_END); // 这里配置的Content-type很重要的 ，用于服务器端辨别文件的类型的
					sb.append("Content-Type:application/octet-stream" + LINE_END); 
					sb.append(LINE_END);
					params = sb.toString();
					sb = null;

					//Log.i(TAG, file.getName()+"=" + params+"##");
					dos.write(params.getBytes());
					/**上传文件*/
					InputStream is = new FileInputStream(file); 
					byte[] bytes = new byte[1024];
					int len = 0;
					int curLen = 0;
					while ((len = is.read(bytes)) != -1) {
					curLen += len;
					dos.write(bytes, 0, len); 
					}
					is.close();

					dos.write(LINE_END.getBytes());
			}
			
			
			
			byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
			dos.write(end_data);
			dos.flush();
			// 
			// dos.write(tempOutputStream.toByteArray());
			/**
			* 获取响应码 200=成功 当响应成功，获取响应的流
			*/
			int res = conn.getResponseCode();
			responseTime = System.currentTimeMillis();
			this.requestTime = (int) ((responseTime-requestTime)/1000);
			//Log.e(TAG, "response code:" + res);
				if (res == 200) {
				//Log.e(TAG, "request success");
				InputStream input = conn.getInputStream();
				
				/*InputStreamReader isInputStreamReader  = new InputStreamReader(input, "utf-8");
				 BufferedReader reader =  new BufferedReader(isInputStreamReader);
				 String strMessage="";
				 StringBuffer buffer = new StringBuffer();
				 while ((strMessage = reader.readLine()) != null) {
		             buffer.append(strMessage);
		         }
				 System.out.println(UPLOAD_SUCCESS_CODE+ "上传结果："+buffer.toString());
				 */
				StringBuffer sb1 = new StringBuffer();
				int ss;
				while ((ss = input.read()) != -1) {
				sb1.append((char) ss);
				}
				result = sb1.toString();
				//Log.e(TAG, "result : " + result);
				System.out.println(UPLOAD_SUCCESS_CODE+ "上传结果："
				+ result);
				return;
				} else {
			//Log.e(TAG, "request error");
				System.out.println(UPLOAD_SERVER_ERROR_CODE+"上传失败1：code=" + res);
					return;
				}
			} catch (MalformedURLException e) {
				System.out.println(UPLOAD_SERVER_ERROR_CODE+"上传失败2：error=" + e.getMessage());
			e.printStackTrace();
			return;
			} catch (IOException e) {
				System.out.println(UPLOAD_SERVER_ERROR_CODE+"上传失败3：error=" + e.getMessage());
			e.printStackTrace();
			return;
			}
			}
	

	private void toUploadFile(File file, String fileKey, String RequestURL,
	Map<String, String> param) {
	String result = null;
	requestTime= 0;

	long requestTime = System.currentTimeMillis();
	long responseTime = 0;

	try {
	URL url = new URL(RequestURL);
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setReadTimeout(readTimeOut);
	conn.setConnectTimeout(connectTimeout);
	conn.setDoInput(true); // 允许输入流
	conn.setDoOutput(true); // 允许输出流
	conn.setUseCaches(false); // 不允许使用缓存
	conn.setRequestMethod("POST"); // 请求方式
	conn.setRequestProperty("Charset", CHARSET); // 设置编码
	conn.setRequestProperty("connection", "keep-alive");
	conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
	conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
	// conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

	/**
	* 当文件不为空，把文件包装并且上传
	*/
	DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
	StringBuffer sb = null;
	String params = "";

	/***
	* 以下是用于上传参数
	*/
	if (param != null && param.size() > 0) {
	Iterator<String> it = param.keySet().iterator();
	while (it.hasNext()) {
	sb = null;
	sb = new StringBuffer();
	String key = it.next();
	String value = param.get(key);
	sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
	sb.append("Content-Disposition: form-data; name=\"").append(key).append("\"").append(LINE_END).append(LINE_END);
	sb.append(value).append(LINE_END);
	params = sb.toString();
	//Log.i(TAG, key+"="+params+"##");
	dos.write(params.getBytes());
	// dos.flush();
	}
	}

	sb = null;
	params = null;
	sb = new StringBuffer();
	/**
	* 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
	* filename是文件的名字，包含后缀名的 比如:abc.png
	*/
	sb.append(PREFIX).append(BOUNDARY).append(LINE_END);
	sb.append("Content-Disposition:form-data; name=\"" + fileKey
	+ "\"; filename=\"" + file.getName() + "\"" + LINE_END);
	//sb.append("Content-Type:image/pjpeg" + LINE_END); // 这里配置的Content-type很重要的 ，用于服务器端辨别文件的类型的
	sb.append("Content-Type:application/octet-stream" + LINE_END); 
	sb.append(LINE_END);
	params = sb.toString();
	sb = null;

	//Log.i(TAG, file.getName()+"=" + params+"##");
	dos.write(params.getBytes());
	/**上传文件*/
	InputStream is = new FileInputStream(file); 
	byte[] bytes = new byte[1024];
	int len = 0;
	int curLen = 0;
	while ((len = is.read(bytes)) != -1) {
	curLen += len;
	dos.write(bytes, 0, len); 
	}
	is.close();

	dos.write(LINE_END.getBytes());
	byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
	dos.write(end_data);
	dos.flush();
	// 
	// dos.write(tempOutputStream.toByteArray());
	/**
	* 获取响应码 200=成功 当响应成功，获取响应的流
	*/
	int res = conn.getResponseCode();
	responseTime = System.currentTimeMillis();
	this.requestTime = (int) ((responseTime-requestTime)/1000);
	//Log.e(TAG, "response code:" + res);
	if (res == 200) {
	//Log.e(TAG, "request success");
	InputStream input = conn.getInputStream();
	StringBuffer sb1 = new StringBuffer();
	int ss;
	while ((ss = input.read()) != -1) {
	sb1.append((char) ss);
	}
	result = sb1.toString();
	//Log.e(TAG, "result : " + result);
	System.out.println(UPLOAD_SUCCESS_CODE+ "上传结果："
	+ result);
	return;
	} else {
	//Log.e(TAG, "request error");
		System.out.println(UPLOAD_SERVER_ERROR_CODE+"上传失败：code=" + res);
	return;
	}
	} catch (MalformedURLException e) {
		System.out.println(UPLOAD_SERVER_ERROR_CODE+"上传失败：error=" + e.getMessage());
	e.printStackTrace();
	return;
	} catch (IOException e) {
		System.out.println(UPLOAD_SERVER_ERROR_CODE+"上传失败：error=" + e.getMessage());
	e.printStackTrace();
	return;
	}
	}
	
	
}
