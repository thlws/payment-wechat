package payment.wechat.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class DataUtil {

	
	/**
	 * Object to Map (will ignore null properties)
	 * @author HanleyTang
	 * @param o
	 * @return
	 */
	public static Map<String, Object> data2Map(Object o){
		
		Map<String, Object> map = new HashMap<String, Object>();
		String text = JSONObject.toJSONString(o);
		JSONObject jsonObject = JSONObject.parseObject(text);
		Set<String> set = jsonObject.keySet();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()){
			String key = itr.next();
			map.put(key, jsonObject.getString(key));
		}
		return map;
	}
	
	
	/***
	 * 去除空值
	 * @author HanleyTang
	 * @param map
	 * @return
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
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
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
     * map数据转换为GET URL后的参数 eg: name=hanley&age=22&address=SH
     * @author HanleyTang
     * @param mapData
     * @return
     */
    public static String map2Param(Map<String,Object> mapData){
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
    
    
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass){

		Object obj = null;
		try {
			obj = beanClass.newInstance();
			org.apache.commons.beanutils.BeanUtils.populate(obj, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	/***
	 * add by hanley
	 * @param type
	 * @param map
     * @return
     */
//	public static Object mapToObject(Map map,Class type) {
//
//		Object obj = null;
//		try{
//			BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
//			obj = type.newInstance(); // 创建 JavaBean 对象
//
//			// 给 JavaBean 对象的属性赋值
//			PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
//			for (int i = 0; i< propertyDescriptors.length; i++) {
//				PropertyDescriptor descriptor = propertyDescriptors[i];
//				String propertyName = descriptor.getName();
//
//				if (map.containsKey(propertyName)) {
//					// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
//					Object value = map.get(propertyName);
//
//					Object[] args = new Object[1];
//					args[0] = value;
//
//					descriptor.getWriteMethod().invoke(obj, args);
//				}
//			}
//		}catch (Exception e){
//
//		}
//
//		return obj;
//	}



	/***
     * generate MD5 text 
     * @author HanleyTang
     * @param data
     * @return
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
    
    
    public static String md5(Map<String, Object> sPara,String key){
		String prestr = createLinkString(sPara);
		prestr +="&key="+key;
		String mysign = getMD5(prestr).toUpperCase();
		return mysign;
	}
    
    
    /***
     * 随机数产生
     * @author HanleyTang
     * @param length 产生长度
     * @return
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
	
}
