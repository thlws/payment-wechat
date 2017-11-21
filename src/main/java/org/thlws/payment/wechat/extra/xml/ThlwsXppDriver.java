package org.thlws.payment.wechat.extra.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class ThlwsXppDriver extends XppDriver {

	public ThlwsXppDriver() {
		super(new ThlwsNameCoder());
	}

	public ThlwsXppDriver(NameCoder nameCoder) {
		super(nameCoder);
	}
}
