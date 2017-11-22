package org.thlws.payment.wechat.extra.xml;

import com.thoughtworks.xstream.XStream;

/**
 * Created by HanleyTang on 2017/11/21
 *
 * @author Hanley[hanley@thlws.com]
 * @version 1.0
 */
public class XStreamCreator {

    public static XStream create(Class cls){
        XStream xStream = new XStream(new ThlwsXppDriver());
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypesByWildcard(new String[] {
                "org.thlws.payment.wechat.**"
        });
        xStream.alias("xml",cls);
        return  xStream;
    }

}
