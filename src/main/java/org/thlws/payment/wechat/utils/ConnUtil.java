package org.thlws.payment.wechat.utils;

import java.io.*;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thlws.payment.wechat.config.WechatConfig;


/**
 * The type Conn util.
 */
public final class ConnUtil {
	
	static final private Logger log = LoggerFactory.getLogger(ConnUtil.class);
	
	private static final int CONNECTION_TIMEOUT = 1000*10;

	private static final int SOCKET_TIMEOUT = 1000*10;

	private static final int CONNECTION_REQUEST_TIMEOUT = 1000 * 30;

	/**
	 * Conn remote string.
	 *
	 * @param request the request
	 * @param url     the url
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String connRemote(String request,String url) throws Exception {
		String result = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			result = connRemoteWithJson(result,url);
		} catch (Exception e) {
			log.error("connRemote error: "+e.getMessage());
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
			log.error("connRemoteWithJson error: "+e.getMessage());
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
	
	
	public static String connRemoteWithXml(String xml,String url) throws Exception {
		String result;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			RequestConfig.Builder b = RequestConfig.custom();
			b.setSocketTimeout(SOCKET_TIMEOUT);
			b.setConnectTimeout(CONNECTION_TIMEOUT);
			RequestConfig config = b.build();
			
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(config);
			ContentType contentType = ContentType.create("text/xml",Consts.UTF_8);
			StringEntity entity = new StringEntity(xml,contentType);
			entity.setContentEncoding("UTF-8");
			httpPost.setEntity(entity);

			HttpResponse response = httpClient.execute(httpPost);
			result = EntityUtils.toString(response.getEntity(),"UTF-8");
		} catch (Exception e) {
			log.error("connRemoteWithXml error: "+e.getMessage());
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
	
	
	public static String encryptPost(String data,String url,String pwd,String absoluteFile){
		//使用证书前，要在服务器上安装给证书。
		log.info("请求网关："+url);
		log.info("证书号："+pwd);
		log.info("p12本地文件保存地址："+absoluteFile);
		
		String result;
		
		try {
			File p12File = new File(absoluteFile);
			if(!p12File.exists()){
				log.error("p12文件不存在,请检查路径下是否存在p12:"+absoluteFile);
				throw new Exception("p12文件不存在,请检查路径下是否存在p12:"+absoluteFile);
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
			//SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, WechatConfig.SUPPORTED_PROTOCOLS,null,SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, WechatConfig.SUPPORTED_PROTOCOLS,null, NoopHostnameVerifier.INSTANCE);

			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			RequestConfig.Builder b = RequestConfig.custom();
			b.setSocketTimeout(SOCKET_TIMEOUT);
			b.setConnectTimeout(CONNECTION_TIMEOUT);
			b.setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT);
//			b.setStaleConnectionCheckEnabled(false);
			RequestConfig config = b.build();
			//org.apache.http.impl.conn.PoolingHttpClientConnectionManager#setValidateAfterInactivity(int)}

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
			log.error("encryptPost error:"+e.getMessage());
		}
		
		return result;
	}
	
	
	public static String connURL(String url) throws Exception {
		String result;
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
			log.error("connURL error: "+e.getMessage());
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


}