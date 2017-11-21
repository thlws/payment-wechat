package org.thlws.payment.wechat.extra.xml;

import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * 自定义Coder
 * 1.Java Bean 中包含$符号特殊处理,保证xmlToObj and ObjToxml 可以正常工作
 * 2.Java Bean 中若包含下划线 _ 时，转换(xmlToObj and ObjToxml)可正常工作
 */
public class ThlwsNameCoder extends XmlFriendlyNameCoder {

	public ThlwsNameCoder() {
        super("_-", "_");
    }
	
}
