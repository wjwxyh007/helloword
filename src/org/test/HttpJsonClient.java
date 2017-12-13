package org.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class HttpJsonClient {
	static int timeout=10*1000;
	/**
	 * 发送json请求返回，json字符串
	 * @param urlStr
	 * @param json
	 * @return
	 * @throws ProtocolException 
	 */
	public static String readHttpJson(String urlStr, String json) throws Exception {
		String res = "";// SessionID
		URL url = null;// 请求处理的Servlet
		OutputStream objOutputStrm = null;// 对象输出流
		InputStream in = null;// 得到HttpURLConnection的输入流
		HttpURLConnection httpUrlConnection = null;
		try {
			url = new URL(urlStr);
			// 设置HttpURLConnection参数
			httpUrlConnection = setURLConnectionProperties(url);
			if(json!=null && json.length()>0){
			// 得到对象输出流
			objOutputStrm = httpUrlConnection.getOutputStream();
			// 向对象输出流写出数据，这些数据将存到内存缓冲区中
			objOutputStrm.write(json.getBytes());
			// 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream）
			objOutputStrm.flush();
			objOutputStrm.close();
			}
			in = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这里
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int num;
			byte[] bu = new byte[in.available()];
			while ((num = in.read(bu)) > 0) {
				baos.write(bu, 0, num);
			}
			in.close();
			res=new String(baos.toByteArray());
		}catch (Exception e) {
			throw e;
		} finally {
			try {
				if (objOutputStrm != null) {
					objOutputStrm.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return res;
	}

	private static HttpURLConnection setURLConnectionProperties(URL url)
			throws IOException, ProtocolException {
		HttpURLConnection httpUrlConnection;
		URLConnection rulConnection = url.openConnection();// 此处的urlConnection对象实际上是根据URL的
		httpUrlConnection = (HttpURLConnection) rulConnection;
		
		// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
		// http正文内，因此需要设为true, 默认情况下是false;
		httpUrlConnection.setDoOutput(true);
		// 设置是否从httpUrlConnection读入，默认情况下是true;
		httpUrlConnection.setDoInput(true);
		// Post 请求不能使用缓存
		httpUrlConnection.setUseCaches(false);
		// 设定传送的内容类型是可序列化的Java对象
		httpUrlConnection
				.setRequestProperty("Content-type", "application/html");
		// 设定请求的方法为"POST"，默认是GET
		httpUrlConnection.setRequestMethod("POST");
		try {
			// 连接，从上述至此的配置必须要在connect之前完成，
			httpUrlConnection.connect();
			httpUrlConnection.setConnectTimeout(timeout);
			httpUrlConnection.setReadTimeout(timeout);
		} catch (ConnectException e1) {
			e1.printStackTrace();
			
		}
		return httpUrlConnection;
	}
}
