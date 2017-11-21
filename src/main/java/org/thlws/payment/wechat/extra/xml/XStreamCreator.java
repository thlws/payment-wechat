package org.thlws.payment.wechat.extra.xml;

import com.thoughtworks.xstream.XStream;

/**
 * Created by HanleyTang on 2017/11/21
 *
 * @author Hanley[hanley@thlws.com]
 * @version 1.0
 */
public class XStreamCreator {

    public static XStream create(){
        return new XStream(new ThlwsXppDriver());
    }

}
