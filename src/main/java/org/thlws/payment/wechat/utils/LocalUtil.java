/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.thlws.payment.wechat.utils;

import java.net.InetAddress;

/**
 * Created by HanleyTang on 16/10/14.
 */
public class LocalUtil {

    public static String getLocalIP(){

        String ip = "127.0.0.1";
        try{
            InetAddress addr = InetAddress.getLocalHost();
            ip=addr.getHostAddress().toString();
        }catch (Exception e){
            ip = "127.0.0.1";
        }

        return  ip;
    }
}
