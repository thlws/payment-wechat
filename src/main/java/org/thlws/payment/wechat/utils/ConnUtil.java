package org.thlws.payment.wechat.utils;

import java.io.*;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thlws.payment.wechat.config.WechatConfig;


/***
 * 远程连接工具
 * @author iQuickgo.Hanley
 * @date 2015年9月9日
 * @email hltang@enjar.cn,hanley@hanley.cn
 * @since JDK1.6
 * @version 2.0
 */
public final class ConnUtil {
	
	static final protected Logger log = LoggerFactory.getLogger(ConnUtil.class);
	
	/**连接超时时间,单位ms*/
	public static final int CONNECTION_TIMEOUT = 1000*10;
	
	/**Socket超时时间,单位ms*/
	public static final int SOCKET_TIMEOUT = 1000*10;
	
	/**连接请求超时时间*/
	public static final int CONNECTION_REQUEST_TIMEOUT = 1000 * 30;
	
	/**状态*/
	public static final String STATUS = "status";
	
	/**警告*/
	public static final String WARN = "warn";
	
	/**成功*/
	public static final String SUCCESS = "success";
	
	/**失败*/
	public static final String ERROR = "error";
	
	/**消息体*/
	public static final String MESSAGE = "message";

	
	/***
	 * 远程访问请求,数据格式默认JSON [POST]
	 * @author HanleyTang
	 * @param request
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String connRemote(String request,String url) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			result = connRemoteWithJson(result,url);
		} catch (Exception e) {
			log.error("can't request: "+e.getMessage());
			throw new Exception(e.getMessage());
		}finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				log.error("httpClient close error:"+e.getMessage());
			}
		}
		return result;
	}
	
	
	/**
	 * 使用json数据格式,远程请求. [POST]
	 * @author HanleyTang
	 * @param json
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String connRemoteWithJson(String json,String url) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			RequestConfig.Builder b = RequestConfig.custom();
			b.setSocketTimeout(SOCKET_TIMEOUT);
			b.setConnectTimeout(CONNECTION_TIMEOUT);
			RequestConfig config = b.build();
			
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(config);
			StringEntity entity = new StringEntity(json,ContentType.APPLICATION_JSON);
			
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			int code = response.getStatusLine().getStatusCode();
			System.out.println(code);
			result = EntityUtils.toString(response.getEntity(),"UTF-8");
		} catch (Exception e) {
			log.error("can't request: "+e.getMessage());
			throw new Exception(e.getMessage());
		}finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				log.error("httpClient close error:"+e.getMessage());
			}
		}
		return result;
	}
	
	
	/***
	 * 远程请求[xml数据传输格式 POST] 
	 * @author HanleyTang
	 * @param xml
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String connRemoteWithXml(String xml,String url) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			RequestConfig.Builder b = RequestConfig.custom();
			b.setSocketTimeout(SOCKET_TIMEOUT);
			b.setConnectTimeout(CONNECTION_TIMEOUT);
			RequestConfig config = b.build();
			
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(config);
			StringEntity entity = new StringEntity(xml,ContentType.TEXT_XML);
			entity.setContentEncoding("UTF-8");
			httpPost.setEntity(entity);
			
			HttpResponse response = httpClient.execute(httpPost);
			result = EntityUtils.toString(response.getEntity(),"UTF-8");
		} catch (Exception e) {
			log.error("can't request: "+e.getMessage());
			throw new Exception(e.getMessage());
		}finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				log.error("httpClient close error:"+e.getMessage());
			}
		}
		return result;
	}
	
	
	/***
	 * 微信退款加密请求
	 * @author HanleyTang
	 * @param data
	 * @param url
	 * @param pwd 证书密码,同时也是商户号
	 * @param absoluteFile 证书文件绝对路径
	 * @return
	 */
	public static String encryptPost(String data,String url,String pwd,String absoluteFile){
		//使用证书前，要在服务器上安装给证书。
		log.info("请求网关："+url);
		log.info("证书号："+pwd);
		log.info("p12本地文件保存地址："+absoluteFile);
		
		String result = null;
		
		try {
			File p12File = new File(absoluteFile);
			if(!p12File.exists()){
				log.error("p12文件不存在,请检查路径下是否存在p12:"+absoluteFile);
			}
			
			//读取证书，初始化http相关参数
			KeyStore keyStore  = KeyStore.getInstance(WechatConfig.PKCS12);
			FileInputStream instream = new FileInputStream(new File(absoluteFile));
			try {
				keyStore.load(instream, pwd.toCharArray());
			} finally {
				instream.close();
			}
			
			// Trust own CA and all self-signed certs
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, pwd.toCharArray()).build();
			// Allow TLSv1 protocol only
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, WechatConfig.SUPPORTED_PROTOCOLS,null,SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			RequestConfig.Builder b = RequestConfig.custom();
			b.setSocketTimeout(SOCKET_TIMEOUT);
			b.setConnectTimeout(CONNECTION_TIMEOUT);
			b.setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT);
			b.setStaleConnectionCheckEnabled(false);
			RequestConfig config = b.build();
			
			try {
				HttpPost post = new HttpPost(url);
				post.setConfig(config);
				//updated by hanley
				StringEntity entity = new StringEntity(data,ContentType.create("text/xml", Consts.UTF_8));
				entity.setContentEncoding("UTF-8");
				post.setEntity(entity);
				HttpResponse response = httpclient.execute(post);
				result = EntityUtils.toString(response.getEntity(),"UTF-8");
			}finally{
				httpclient.close();
			}
		} catch (Exception e) {
			result = e.getMessage();
		}
		
		return result;
	}
	
	
	/***
	 * Get 方式请求数据,参数附加在URL中
	 * @author HanleyTang
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String connURL(String url) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			RequestConfig.Builder b = RequestConfig.custom();
			b.setSocketTimeout(SOCKET_TIMEOUT);
			b.setConnectTimeout(CONNECTION_TIMEOUT);
			RequestConfig config = b.build();
			
			HttpGet httpGet = new HttpGet(url);
			httpGet.setConfig(config);
			
			HttpResponse response = httpClient.execute(httpGet);
			result = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			log.error("can't request: "+e.getMessage());
			throw new Exception(e.getMessage());
		}finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				log.error("httpClient close error:"+e.getMessage());
			}
		}
		return result;
	}
	
	
	
	/**
	 * 验证URL是否存在并可正常返回数据
	 * @author HanleyTang
	 * @param url
	 * @return
	 */
	public static boolean verifyURL(String url){
		boolean result = false;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			RequestConfig.Builder b = RequestConfig.custom();
			b.setSocketTimeout(1000*2);
			b.setConnectTimeout(1000*2);
			RequestConfig config = b.build();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(config);
			HttpResponse response = httpClient.execute(httpPost);
			int code = response.getStatusLine().getStatusCode();
			if(200 == code){
				long length = response.getEntity().getContentLength();
				result = length > 0;
			}else{
				result = false;
			}
		} catch (Exception e) {
			log.error("can't request: "+e.getMessage());
			result = false;
		}finally{
			try {
				httpClient.close();
			} catch (Exception e) {
				log.error("httpClient close error:"+e.getMessage());
			}
		}
		return result;
	}


	/***
	 * 提交数据至微信
	 * @param xml
	 * @param url
	 * @return
	 */
	public static String postDataToWechat(String xml, String url) {
		String result = null;
		HttpClient client = new HttpClient();
		PostMethod method = null;
		try {
			method = new PostMethod(url);
			method.addRequestHeader("Content-Type", "text/xml; charset=utf-8");
			RequestEntity entity = new StringRequestEntity(xml, null, "utf-8");
			method.setRequestEntity(entity);
			client.executeMethod(method);
			int responseCode = method.getStatusCode();
			if (responseCode == HttpStatus.SC_OK) {
				InputStream resStream = method.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(resStream, "utf-8"));
				StringBuffer resBuffer = new StringBuffer();
				String resTemp = "";
				while ((resTemp = br.readLine()) != null) {
					resBuffer.append(resTemp);
				}
				log.info("postDataToWechat():resBuffer=" + resBuffer);
				result = resBuffer.toString();
				br.close();
				resStream.close();
			} else {
				log.error(" Error===" + responseCode + ",requestUrl:" + url);
			}
		} catch (IOException e) {
			log.error("IO Exeception: " + e.getMessage());
		} finally {
			if (method != null)
				method.releaseConnection();
		}
		return result;
	}

}