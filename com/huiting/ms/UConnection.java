package com.huiting.ms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class UConnection {

	private URLConnection conn = null;
	private URL url = null;
	private String base_url;
	private PrintWriter out;
	private BufferedReader in;

	public UConnection(String base_url) 
	{
		this.base_url = base_url;
	}

	public String SendPost(String resouse, Map<String, String> params) 
	{
		String result = "";
		try {

			url = new URL(base_url + resouse);
			conn = url.openConnection();
			conn.setRequestProperty("Content-type",
						"application/x-www-form-urlencoded");
			conn.setRequestProperty("Accept", "text/plain");
			
			conn.setDoOutput(true);
			conn.setDoInput(true);

			out = new PrintWriter(conn.getOutputStream());

			out.print(Linkparams(params));
			out.flush();

			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));

			String line;
			while ((line = in.readLine()) != null) 
			{
				result += line;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try 
			{
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private String Linkparams(Map<String, String> params) 
	{
		String rs = "";

		for (Map.Entry<String, String> en : params.entrySet())
			rs = rs + en.getKey() + "=" + en.getValue() + "&";

		return rs;
	}
}
