package org.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Test1 {
	static int timeout=10*1000;
	/**
	 * 爬药监局药品生产企业
	 */
	public static void getqiye() {
		final WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);  
        HtmlPage page;
		try {
			FileOutputStream fos=new FileOutputStream("/Users/wangjw/药品生产企业.txt",true);
			for(int n =489;n<500;n++) {
			page = webClient.getPage("http://app1.sfda.gov.cn/datasearch/face3/search.jsp?&bcId=undefined&State=1&tableId=34&keyword=&curstart="+n);
			 final String pageAsXml = page.asXml();  
		      //  Assert.assertTrue(pageAsXml.contains("杨尚川，系统架构设计师，系统分析师，2013年度优秀开源项目APDPlat发起人，资深Nutch搜索引擎专家。多年专业的软件研发经验，从事过管理信息系统(MIS)开发、移动智能终端(Win CE、Android、Java ME)开发、搜索引擎(nutch、lucene、solr、elasticsearch)开发、大数据分析处理(Hadoop、Hbase、Pig、Hive)等工作。目前为独立咨询顾问，专注于大数据、搜索引擎等相关技术，为客户提供Nutch、Lucene、Hadoop、Solr、ElasticSearch、HBase、Pig、Hive、Gora等框架的解决方案、技术支持、技术咨询以及培训等服务。"));  
		       // final String pageAsText = page.asText();  
		       // Assert.assertTrue(pageAsText.contains("[置顶] 国内首套免费的《Nutch相关框架视频教程》(1-20)"));  
		       // System.out.println(pageAsText);
		       // System.out.println(pageAsXml);
		        StringReader sr=new StringReader(pageAsXml);
		        BufferedReader br=new BufferedReader(sr);
		        String num="0123456789";
		        String str=null;
		        while((str=br.readLine())!=null) {
		        	  str=str.trim();
		        	  if(str.length()>0) {
		        	  if(num.indexOf(String.valueOf(str.charAt(0)))>=0) {
		        		 fos.write((str+"\r\n").getBytes());
		        		 System.out.println(str);
		        	  }else if(str.indexOf("javascript:commitForECMA")>0) {
		        		  int idn=str.indexOf("amp;Id=");
		        		  str=str.substring(idn+7,str.indexOf("'",idn));
		        		  System.out.print(str+"~");
		        		  fos.write((str+"~").getBytes());
		        	  }
		        	  }
		        }
		        Thread.sleep(1000);
		        //break;
		        webClient.close(); 
			}
					
					fos.flush();
					fos.close();
		}catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	public static void getXq() {
		//content.jsp?tableId=34&tableName=TABLE34&tableView=药品生产企业&Id=5484
		final WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);  
		 webClient.getOptions().setCssEnabled(false);  
		 webClient.getOptions().setJavaScriptEnabled(false);  
        try {
			HtmlPage page = webClient.getPage("http://app1.sfda.gov.cn/datasearch/face3/content.jsp?tableId=25&tableName=TABLE25&tableView=国产药品&Id=118641");
			System.out.println(page.asText());
			webClient.close();
        } catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 药品经营企业
	 */
	public static void getjyqiye() {
		try {
			 WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);  
			 webClient.getOptions().setCssEnabled(false);  
			 webClient.getOptions().setJavaScriptEnabled(false);  
			FileOutputStream fos=new FileOutputStream("/Users/wangjw/药品经营企业.txt",true);
			for(int n =4116;n<9500;n++) {
				try {
		         HtmlPage page = webClient.getPage("http://app1.sfda.gov.cn/datasearch/face3/search.jsp?&bcId=undefined&State=1&tableId=41&keyword=&curstart="+n);
			  String pageAsXml = page.asXml();  
		        StringReader sr=new StringReader(pageAsXml);
		        BufferedReader br=new BufferedReader(sr);
		        String num="0123456789";
		        String str=null;
		        while((str=br.readLine())!=null) {
		        	  str=str.trim();
		        	  if(str.length()>0) {
		        	  if(num.indexOf(String.valueOf(str.charAt(0)))>=0) {
		        		 fos.write((str+"\r\n").getBytes());
		        		 System.out.println(str);
		        	  }else if(str.indexOf("javascript:commitForECMA")>0) {
		        		  int idn=str.indexOf("amp;Id=");
		        		  str=str.substring(idn+7,str.indexOf("'",idn));
		        		  System.out.print(str+"~");
		        		  fos.write((str+"~").getBytes());
		        	  }
		        	  }
		        }
				}catch(Exception e) {
					e.printStackTrace();
					webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);  
				}
		        Thread.sleep(500);
			
		        //break;
		       
			}
			 webClient.close(); 
					fos.flush();
					fos.close();
		}catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	/**
	 * 国产药
	 */
	public static void getgcy() {
		try {
			
			FileOutputStream fos=new FileOutputStream("/Users/wangjw/国产药.txt",true);
			for(int n =11040;n<=11040;n++) {
				try {
					 WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);  
					 webClient.getOptions().setCssEnabled(false);  
					// webClient.getOptions().setJavaScriptEnabled(false);  
		         HtmlPage page = webClient.getPage("http://app1.sfda.gov.cn/datasearch/face3/search.jsp?&bcId=undefined&State=1&tableId=25&keyword=&curstart="+n);
			  String pageAsXml = page.asXml();  
		        StringReader sr=new StringReader(pageAsXml);
		        BufferedReader br=new BufferedReader(sr);
		        String num="0123456789";
		        String str=null;
		        while((str=br.readLine())!=null) {
		        	  str=str.trim();
		        	  if(str.length()>0) {
		        	  if(num.indexOf(String.valueOf(str.charAt(0)))>=0) {
		        		 fos.write((str+"\r\n").getBytes());
		        		 System.out.println(str);
		        	  }else if(str.indexOf("javascript:commitForECMA")>0) {
		        		  int idn=str.indexOf("amp;Id=");
		        		  str=str.substring(idn+7,str.indexOf("'",idn));
		        		  System.out.print(str+"~");
		        		  fos.write((str+"~").getBytes());
		        	  }
		        	  }
		        }
		        webClient.close(); 
				}catch(Exception e) {
					e.printStackTrace();
					
				}
		        Thread.sleep(6000);
			
		        //break;
		    
			}
			
					fos.flush();
					fos.close();
		}catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	/**
	 * 二次药品提取
	 */
	public static void getgcy2() {
		
			
			
			try {
				FileOutputStream fos=new FileOutputStream("/Users/wangjw/国产药2.txt",true);
				FileReader fr=new FileReader("/Users/wangjw/国产药缺.txt");
				 BufferedReader br1=new BufferedReader(fr);
				 String str1=null;
			
				 Map<String,String>mp=new HashMap<String,String>();
				 while((str1=br1.readLine())!=null) {
					 String[]ss=str1.split("~");
						int num1=Integer.parseInt(ss[0]);
						int num2=Integer.parseInt(ss[1]);
						int n=num1/15+1;
						int nl=(num2-num1-1)/15;
						if(nl==0 &&(num2-num1-1)>0) {
							nl=1;
						}
						int nn=n+nl;
						for(;n<nn;n++) {
							try {
								 WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);  
								 webClient.getOptions().setCssEnabled(false);  
								// webClient.getOptions().setJavaScriptEnabled(false);  
					         HtmlPage page = webClient.getPage("http://app1.sfda.gov.cn/datasearch/face3/search.jsp?&bcId=undefined&State=1&tableId=25&keyword=&curstart="+n);
						  String pageAsXml = page.asXml();  
					        StringReader sr=new StringReader(pageAsXml);
					        BufferedReader br=new BufferedReader(sr);
					        String num="0123456789";
					        String str=null;
					        while((str=br.readLine())!=null) {
					        	  str=str.trim();
					        	  if(str.length()>0) {
					        	  if(num.indexOf(String.valueOf(str.charAt(0)))>=0) {
					        		 fos.write((str+"\r\n").getBytes());
					        		 System.out.println(str);
					        	  }else if(str.indexOf("javascript:commitForECMA")>0) {
					        		  int idn=str.indexOf("amp;Id=");
					        		  str=str.substring(idn+7,str.indexOf("'",idn));
					        		  System.out.print(str+"~");
					        		  fos.write((str+"~").getBytes());
					        	  }
					        	  }
					        }
					        webClient.close(); 
							}catch(Exception e) {
								e.printStackTrace();
								
							}
					        Thread.sleep(6000);
						
					        //break;
					    
						}
						
				 }
				 
			
					fos.flush();
					fos.close();
		}catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * 合并
	 */
	public static void getgcy3() {
		
		
		
		try {
			FileOutputStream fos=new FileOutputStream("/Users/wangjw/国产药3.txt");
			FileReader fr=new FileReader("/Users/wangjw/国产药排重.txt");
			FileReader fr2=new FileReader("/Users/wangjw/国产药2排重.txt");
			 BufferedReader br1=new BufferedReader(fr);
			 BufferedReader br2=new BufferedReader(fr2);
			 String str1=br1.readLine();
			 String str2=br2.readLine();
			 int n1=getxh(str1);
			 int n2=getxh(str2);
			 Map<String,String>mp=new HashMap<String,String>();
			 
			 while(str1!=null || str2!=null) {
				 String str=null;
				
				 if(n1==0) {
					 if(str2!=null) {
						 str=str2;
						 
						 str2=br2.readLine();
					 }
				 }else if(n2==0) {
					 if(str1!=null) {
						 str=str1;
						 str1=br1.readLine();
					 }
				 }else {
					 if(n1<n2) {
						 str=str1;
						 str1=br1.readLine();
						 n1=getxh(str1);
					 }else {
						 str=str2;
						 str2=br2.readLine();
						 n2=getxh(str2);
					 }
				 }
				 if(str!=null) {
					 fos.write((str+"\r\n").getBytes());
					 System.out.println(str);
				 }else {
					 break;
				 }
					
			 }
			 
		
				fos.flush();
				fos.close();
	}catch (FailingHttpStatusCodeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}			
	public static void getgcy4() {
	
	
	
	try {
		FileOutputStream fos=new FileOutputStream("/Users/wangjw/国产药3.txt");
		FileReader fr=new FileReader("/Users/wangjw/国产药3排重.txt");
		FileReader fr2=new FileReader("/Users/wangjw/国产药2.txt");
		 BufferedReader br1=new BufferedReader(fr);
		 BufferedReader br2=new BufferedReader(fr2);
		 Map<String,String>mp=new HashMap<String,String>();
		 String str1=null;
		 while((str1=br1.readLine())!=null) {
			 String[] ss=str1.split(" ");
			 if(mp.get(ss[ss.length-1])!=null) {
				 System.out.println(str1);
			 }
			 mp.put( ss[ss.length-1],"");
		 }
		
		 
	
			fos.flush();
			fos.close();
}catch (FailingHttpStatusCodeException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (MalformedURLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
}		
	private static int getxh(String str) {
		if(str!=null) {
		 String[]ss=str.split("~");
		 String[]s2s=ss[1].split("\\.");
		return Integer.parseInt(s2s[0]);
		}else {
			return 0;
		}
	}
	/**
	 * 完整检测
	 */
	public static void scqy() {
		try {
			FileOutputStream fos=new FileOutputStream("/Users/wangjw/国产药丢.txt");

			FileReader fr=new FileReader("/Users/wangjw/国产药3排重.txt");
			 BufferedReader br=new BufferedReader(fr);
			 String str=null;
			 int num=0;
			 Map<String,String>mp=new HashMap<String,String>();
			 while((str=br.readLine())!=null) {
				 String[]ss=str.split("~");
				 if(mp.get(ss[0])==null) {
					 mp.put(ss[0], "");
					 fos.write((str+"\r\n").getBytes());
				 }
				 String[]s2s=ss[1].split("\\.");
				int num2=Integer.parseInt(s2s[0]);
				if(num>0&& (num2-num)>1) {
					System.out.println(num+"~"+num2);
				}
				num=num2;
			 }
			 fos.flush();
			 fos.close();
			 System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 数据排重
	 */
	public static void scqypc() {
		try {
			FileOutputStream fos=new FileOutputStream("/Users/wangjw/国产药3排重.txt");

			FileReader fr=new FileReader("/Users/wangjw/国产药3.txt");
			 BufferedReader br=new BufferedReader(fr);
			 String str=null;
			 int num=0;
			 Map<String,String>mp=new HashMap<String,String>();
			 while((str=br.readLine())!=null) {
				 String[]ss=str.split("~");
				 if(mp.get(ss[0])==null) {
					 mp.put(ss[0], "");
					 fos.write((str+"\r\n").getBytes());
				 }
				 
			 }
			 fos.flush();
			 fos.close();
			 System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void test() {
		try {
		//	System.out.println(readHttpJson("https://db.yaozh.com/instruct?p=1&pageSize=20",null));
			 WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);  
			 webClient.getOptions().setUseInsecureSSL(true);  
			 webClient.getOptions().setCssEnabled(false);  
			 webClient.getOptions().setJavaScriptEnabled(false);  
			// webClient.get
			HtmlPage page = webClient.getPage("https://db.yaozh.com/instruct?p=1&pageSize=30&source="+ URLEncoder.encode("哈药集团制药六厂3", "UTF-8"));
			  String pageAsXml = page.asXml();  
			  
			  System.out.println(pageAsXml);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	/**
	 * 下载药智数据说明书
	 */
	private  static int numw=0;
	public static String getSms(int pageNum,String orgName) {
		String res=null;
		try {
		   if(pageNum>7)return res;
		//	System.out.println(readHttpJson("https://db.yaozh.com/instruct?p=1&pageSize=20",null));
			 WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);  
			 webClient.getOptions().setUseInsecureSSL(true);  
			 webClient.getOptions().setCssEnabled(false);  
			 webClient.getOptions().setJavaScriptEnabled(false);  
			
			
				
			HtmlPage page = webClient.getPage("https://db.yaozh.com/instruct?p="+pageNum+"&pageSize=30&source="+ URLEncoder.encode(orgName, "UTF-8"));
			  String pageAsXml = page.asXml();  
			
			  int num=pageAsXml.indexOf("<div class=\"offset-top table-list\"");
			  if(num>0) {
				  int num2=pageAsXml.indexOf("</table>",num);
				  if(num2>0) {
					  num2=pageAsXml.indexOf("</div>",num2);
					  res=pageAsXml.substring(num,num2+6);
				  }
			  }else {
				  num=pageAsXml.indexOf("dbNoData");
				  if(num>0) {
					
				  }else {//触发了对方反爬算法
					  try {
							Thread.sleep(90000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  return getSms( pageNum, orgName);
				  }
			  }
			 // System.out.println(page.asXml());
			  webClient.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
	}
	public static void getSms(String orgName) {
		int pageNum=1;
		String res=getSms( pageNum, orgName) ;
		
		while(res!=null&& res.length()>0) {
			try {
				FileOutputStream fos=new FileOutputStream("/Users/wangjw/说明书/"+orgName+".txt",true);
				fos.write((res+"\r\n").getBytes());
				fos.flush();
				fos.close();
				if(countStr(res,"</tr>")==31) {
					pageNum++;
					res=getSms( pageNum, orgName) ;
				}else {
					res=null;
				}
				
				//Thread.sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static int countStr(String res,String key) {
		int rnum=0;
		int idx=res.indexOf(key);
		while(idx>=0) {
			rnum++;
			idx=res.indexOf(key,idx+1);
		}
		return rnum;
	}
	/**
	 * 提取
	 */
	public static void scqySms() {
		try {
			FileReader fr=new FileReader("/Users/wangjw/药品生产企业.txt");
			 BufferedReader br=new BufferedReader(fr);
			 String str=null;
			 int num=1;
			 while((str=br.readLine())!=null) {
				 String[]ss=str.split("~");
				 String[]s2s=ss[1].split("\\.");
				System.out.println(s2s[1].split(" ")[0]);
				getSms(s2s[1].split(" ")[0]);
				
			 }
			// System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 解析药品列表
	 */
	public static void jiexiSms() {
		try {
			FileOutputStream fos=new FileOutputStream("/Users/wangjw/说明书列表.txt");
			File[] fls=(new File("/Users/wangjw/说明书")).listFiles();
			for(File f:fls) {
			 FileInputStream fis=new FileInputStream(f);
			 byte[] bf=new byte[fis.available()];
			 fis.read(bf);
			 String ls=new String(bf);
			 int num=ls.indexOf("<tr>");
			 while(num>=0) {
				 int num2=ls.indexOf("</tr>",num);
				 if(num2>0) {
					 String res=printTrStr(ls.substring(num+4,num2));
					 if(res.trim().length()>0) {
					 fos.write(res.getBytes());
					 }else {
						 System.out.println(ls.substring(num+4,num2));
					 }
				 }
				 num=ls.indexOf("<tr>",num2);
			 }
		}
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    private static String printTrStr(String tr) {
    	StringBuffer sr=new StringBuffer();
    	tr=tr.replaceAll("th>", "td>");
    	 int num=tr.indexOf("<td>");
		 while(num>=0) {
			 int num2=tr.indexOf("</td>",num);
			 if(num2>0) {
				 String s1=tr.substring(num+4,num2).trim();
				 int hn=s1.indexOf("class=\"cl-blue\" href=\"");
				 int  tpn=s1.indexOf("<div class=\"drug-instructions-img\" style=\"display: none\">");
				 if(hn>0) {
					 StringBuffer sf=new StringBuffer();
					 while(hn>0) {
						 int hn2=s1.indexOf("\"",hn+22);
						String s2=s1.substring(hn+22, s1.indexOf("\"",hn+22));
					//	System.out.print(s2);System.out.print(",");
						 sr.append(s2); sr.append(",");
						 hn=s1.indexOf("class=\"cl-blue\" href=\"",hn2);
					  }
				 }else if(tpn>=0){
					 int tpn2=s1.indexOf("</div>",tpn+57);
					 s1=s1.substring(tpn+57,tpn2).trim();
					// System.out.print(s1);
					 sr.append(s1);
				 }else  {
					// System.out.print(s1);
					 sr.append(s1);
				 }
				 
				
			 }
			 num=tr.indexOf("<td>",num2);
			 //System.out.print("~");
			 sr.append("~");
			
		 }
		 sr.append("\r\n");
		 System.out.println("");
		 return sr.toString();
    }
    public static void getFile(String stros,String url) {
    	UrlFileReader ufr=new UrlFileReader();
    	try {
    		File f=new File(stros);
    		f=f.getParentFile();
    		if(!f.exists())f.mkdirs();
			FileOutputStream fos=new FileOutputStream(stros);
			fos.write(ufr.readUrlFileBytes(url));
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void getFile2(String stros,String url) {
    	UrlFileReader ufr=new UrlFileReader();
    	try {
    		String res=getSmsStr(url);
    		if(res==null)return;
    		File f=new File(stros);
    		f=f.getParentFile();
    		if(!f.exists())f.mkdirs();
    		
			FileOutputStream fos=new FileOutputStream(stros);
			fos.write(res.getBytes());
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 下载说明书文件
     */
    public static void downSms() {
    	 String str=null;
    	try {
			FileReader fr=new FileReader("/Users/wangjw/说明书列表.txt");
			 BufferedReader br=new BufferedReader(fr);
			
			 int num=1;
			 while((str=br.readLine())!=null) {
				 System.out.println(str);
				 String[]ss=str.split("~");
				String ym=ss[1];
				String jgm=ss[2];
				String sms=ss[3].trim();
				String tp="";
				if(ss.length>4) {
					tp=ss[4];
				}
				if(sms.length()>0) {
					String[]s1=sms.split(",");
					for(int n=0;n<s1.length;n++) {
						String str2=s1[n];
						if(str2.endsWith(".html")) {
							//String res=getSmsStr("https://db.yaozh.com"+str2);
							
							getFile2("/Users/wangjw/说明书/文件/html/"+jgm+"/"+ym+"/"+n+".html", "https://db.yaozh.com"+str2);
						}else {
//							String[]fend=str2.split("\\.");
//							String end=fend[fend.length-1];
//							if(end.length()>4) {
//								end="jpg";
//							}
//							getFile("/Users/wangjw/说明书/文件/说明书/"+jgm+"/"+ym+"/"+n+"."+end, str2);
						}
					}
				}
//				if(tp.length()>0) {
//					String[]s1=tp.split(",");
//					for(int n=0;n<s1.length;n++) {
//						String str2=s1[n];
//					
//							String[]fend=str2.split("\\.");
//							getFile("/Users/wangjw/说明书/文件/图片/"+jgm+"/"+ym+"/"+n+"."+fend[fend.length-1], str2);
//						
//					}
//				}
				
			 }
			// System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(str);
		}
    }
	public static String getSmsStr(String url) {
		String res=null;
		try {
		  
		//	System.out.println(readHttpJson("https://db.yaozh.com/instruct?p=1&pageSize=20",null));
			 WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52);  
			 webClient.getOptions().setUseInsecureSSL(true);  
			 webClient.getOptions().setCssEnabled(false);  
			 webClient.getOptions().setJavaScriptEnabled(false);  
			
			
				
			HtmlPage page = webClient.getPage(url);
			  String pageAsXml = page.asXml();  
			System.out.println(pageAsXml);
			  int num=pageAsXml.indexOf("<div class=\"manual\">");
			  if(num>0) {
				  int num2=pageAsXml.indexOf("<div class=\"ui-panel offset-top\">",num);
				  if(num2>0) {
					
					  res=pageAsXml.substring(num,num2);
				  }
			  }else {
				  num=pageAsXml.indexOf("dbNoData");
				 // if(num>0) {
					
				  //}else {//触发了对方反爬算法
					  try {
							Thread.sleep(90000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  return getSmsStr( url);
				 // }
			  }
			 // System.out.println(page.asXml());
			  webClient.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
	}
	/**
	 * 生产药品生产企业入库sql
	 */
	public static void ypscqySql() {
		
		
		
		try {
			FileOutputStream fos=new FileOutputStream("/Users/wangjw/药品生产企业sql.txt");
			FileReader fr=new FileReader("/Users/wangjw/药品生产企业.txt");

			 BufferedReader br1=new BufferedReader(fr);

			 Map<String,String>mp=new HashMap<String,String>();
			 String str1=null;
			 int num=1;
			 while((str1=br1.readLine())!=null) {
				 StringBuffer sql=new StringBuffer("INSERT INTO PRODUCT_BASE_YP_SCQY (PRODUCT_SCQY_ID,SCQY_NAME,SYJ_ID,BH) VALUES(");
				 sql.append("'");
				sql.append(num++);
				 sql.append("'");
				
			//	 24548~9383.新沂市恒昌医药连锁有限公司沟群药店 (苏CB0312028)
				 String[] ss=str1.split("~");
				 
				String ss2=ss[1].split("\\.")[1];
				int id1=ss2.indexOf("(");
				int id2=ss2.indexOf("(",id1+1);
				while(id2>0) {
					id1=id2;
					 id2=ss2.indexOf("(",id1+1);
				}
				String ns=ss2.substring(0,id1);
				String bh=ss2.substring(id1+1,ss2.length()-1);
				sql.append(",'");
				 sql.append(ns);
				 sql.append("'");
				 sql.append(",'");
				 sql.append(ss[0]);
				 sql.append("'");
				 sql.append(",'");
				 sql.append(bh);
				 sql.append("'");
				 sql.append(");\r\n");
				 fos.write(sql.toString().getBytes());
				 //break;
			 }
			
			 
		
				fos.flush();
				fos.close();
	}catch (FailingHttpStatusCodeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}		
	public static void main(String[] args) {
		//getqiye();
	//	scqy();
		//getjyqiye();
		 //getXq() ;
		//getgcy();
		//test();
		//System.out.println(countStr("<tr><tr><tr><tr><tr><tr><tr><tr><tr><tr>","<tr>"));
		//System.out.println(getSms(2,"哈药集团制药六厂"));
		//System.out.println(getSms(3,"哈药集团制药六厂"));
		//getSms("哈药集团制药六厂");
		System.out.println("test");
		
		//scqySms();
		//jiexiSms() ;
		//scqy() ;
		//getgcy2();
		//scqypc();
		//getgcy4();
		//downSms();
		ypscqySql();
	 
	}

}
