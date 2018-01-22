package org.thlws.payment.wechat.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cn.hutool.core.bean.BeanUtil;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import cn.hutool.core.bean.BeanUtil;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * The type Data util.
 *
 * @author Hanley Tang | hanley@thlws.com
 * @version 1.0
 */
public class ThlwsBeanUtil {


	/**
	 * Object to Map (will ignore null properties)
	 *
	 * @param o the o
	 * @return map
	 * @author HanleyTang
	 */
	public static Map<String, Object> ObjectToMap(Object o){

		Map<String, Object> map = BeanUtil.beanToMap(o,false,true);
		return map;
	}


	/***
	 * 去除空值
	 * @param map the map
	 * @return map
	 * @author HanleyTang
	 */
	public static Map<String, Object> dataFilter(Map<String, Object> map) {

		Map<String, Object> result = new HashMap<String, Object>();
		if (map == null || map.size() <= 0)
			return result;
		for (String key : map.keySet()) {
			Object value = map.get(key);
			if (value == null || value.equals(""))
				continue;
			result.put(key, value);
		}

		return result;
	}


	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用 &amp; 字符拼接成字符串
	 *
	 * @param params 需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串 string
	 */
	public static String createLinkString(Map<String, Object> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = params.get(key);
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                sb.append(key).append("=").append(value);
            } else {
                sb.append(key).append("=").append(value).append("&");
            }
        }
        return sb.toString();
    }


	/**
	 * map数据转换为GET URL后的参数
	 * @param mapData the map data
	 * @return string
	 * @author HanleyTang
	 */
	public static String mapToParams(Map<String,Object> mapData){
        StringBuffer sb = new StringBuffer();
        if(mapData.isEmpty()){
            return "" ;
        }else{
            for(String key: mapData.keySet()){
                String value = (String)mapData.get(key);
                if(sb.length()<1){
                    sb.append(key).append("=").append(value);
                }else{
                    sb.append("&").append(key).append("=").append(value);
                }
            }
            return sb.toString();
        }
    }


	/**
	 * Map to object object.
	 *
	 * @param map       the map
	 * @param beanClass the bean class
	 * @return the object
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass){

		Object obj = BeanUtil.mapToBean(map,beanClass,true);
		return obj;
	}


	/***
	 * generate MD5 text
	 * @param data the data
	 * @return md 5
	 * @author HanleyTang
	 */
	public static String getMD5(String data) {
  	   String s = null;
  	   char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };// 用来将字节转换成16进制表示的字符
  	   try {
  		   byte[] source = data.getBytes("UTF-8");
  		   java.security.MessageDigest md = java.security.MessageDigest .getInstance("MD5");
  		   md.update(source);
  		   byte tmp[] = md.digest();// MD5 的计算结果是一个 128 位的长整数，
  		   // 用字节表示就是 16 个字节
  		   char str[] = new char[16 * 2];
  		   // 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
  		   // 进制需要 32 个字符
  		   int k = 0;
  		   // 表示转换结果中对应的字符位置
  		   for (int i = 0; i < 16; i++) {
  			   // 从第一个字节开始，对 MD5 的每一个字节
  			   // 转换成 16
  			   // 进制字符的转换
  			   byte byte0 = tmp[i];
  			   // 取第 i 个字节
  			   str[k++] = hexDigits[byte0 >>> 4 & 0xf];
  			   // 取字节中高 4 位的数字转换,// >>> // 为逻辑右移，将符号位一起右移
  			   str[k++] = hexDigits[byte0 & 0xf];
  			   // 取字节中低 4 位的数字转换
  		   }
  		   s = new String(str);
  		   // 换后的结果转换为字符串
  	   } catch (Exception e){
  		   //e.printStackTrace();
  	   }
  	   return s;
     }


	/***
	 * 随机数产生
	 * @param length 产生长度
	 * @return random string
	 * @author HanleyTang
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < length; i++) {
	        int number = random.nextInt(base.length());
	        sb.append(base.charAt(number));
	    }
	    return sb.toString();
	 }


	/**
	 * Format xml string.
	 *
	 * @param uglyXml the ugly xml
	 * @return the string
	 */
	public static String formatXml(String uglyXml) {
		try {
			String xmlHeader= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(uglyXml));
			final Document document = db.parse(is);
			OutputFormat format = new OutputFormat(document);
			format.setLineWidth(65);
			format.setIndenting(true);
			format.setIndent(2);
			Writer out = new StringWriter();
			XMLSerializer serializer = new XMLSerializer(out, format);
			serializer.serialize(document);
			return out.toString().replace(xmlHeader,"");
		} catch (Exception e) {
			return "";
		}
	}


}
