package com.test.myapplication.util;

/**
 Created by apple on 2017/3/20.
 * 接口链接IP/PORT统一管理类
 */
public class URLS {
        private static final String IP = "172.20.10.5";
    private static final String PORT = "8080";
    private static final String HOSTNAME = "http://" + IP + ":" + PORT + "/App_Server/";
    //发送验证码接口
    public static final String URL_CONSHOW = HOSTNAME + "conshow";
    public static final String URL_DETAILSHOW=HOSTNAME+"detailshow";
    public static final String URL_LOGIN=HOSTNAME+"login";

}
