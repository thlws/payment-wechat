package org.thlws.payment.wechat.extra.xml;

import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * 自定义Coder
 * <ol>
 *     <li>Java Bean 中包含$符号特殊处理,保证xmlToObj and ObjToxml 可以正常工作</li>
 *     <li>Java Bean 中若包含下划线 _ 时，转换(xmlToObj and ObjToxml)可正常工作</li>
 * </ol>
 */
public class ThlwsNameCoder extends XmlFriendlyNameCoder {

    /**
     * Instantiates a new Thlws name coder.
     */
    public ThlwsNameCoder() {
        super("_-", "_");
    }
	
}
