package org.test;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;

public class UrlFileReader {
	public String readUrlFile(String strUrl) {
		String res = null;
		try {
			res = new String(readUrlFileBytes(strUrl));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return res;
	}

	public byte[] readUrlFileBytes(String strUrl) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			java.net.URL url = new java.net.URL(strUrl);
			
			java.net.URLConnection urlconn = url.openConnection();
			//java.net.HttpURLConnection hu=(java.net.HttpURLConnection)urlconn;
			urlconn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.8.1.18) Gecko/20081029 Firefox/2.0.0.18");
			// urlconn.setRequestProperty("host", "192.111.111.111:9080");
			urlconn.setRequestProperty("Accept-Charset", "UTF-8");
			urlconn.setDoInput(true);
			urlconn.setDoOutput(true);
		
			java.io.InputStream in = urlconn.getInputStream();
			//printPro(urlconn);
			
			int num;
			byte[] bu = new byte[512];

			while ((num = in.read(bu)) > 0) {
				baos.write(bu, 0, num);
			}
			in.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return baos.toByteArray();
	}
	private void printPro(java.net.URLConnection urlconn){
		Map m=urlconn.getHeaderFields();
		Iterator<String> it=m.keySet().iterator();
        while(it.hasNext()){
        	String str=(String)it.next();
        	System.out.println(str);
        }
	}

}
