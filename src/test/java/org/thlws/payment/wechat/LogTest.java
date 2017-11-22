package org.thlws.payment.wechat;

import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import com.xiaoleilu.hutool.log.level.Level;
import org.junit.Test;

/**
 * Created by HanleyTang on 2017/11/22
 *
 * @author Hanley[hanley@thlws.com]
 * @version 1.0
 */
public class LogTest {

    private static final Log log = LogFactory.get();

    @Test
    public void testLogs(){
        log.info("这是Hanley测试的{} 级别日志", Level.INFO);
    }
}
