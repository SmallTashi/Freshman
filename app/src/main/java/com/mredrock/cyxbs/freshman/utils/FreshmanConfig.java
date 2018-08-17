package com.mredrock.cyxbs.freshman.utils;

public class FreshmanConfig {
    /*
     *https://wx.idsbllp.cn/welcome2018/data/describe/getamount?index=
     *
     * */

    //?index
    public static final String URL_BASE = "data/describe/getamount";

    //?index=
    //index：页面名，取值为"入学必备","军训小贴士" 其中之一
    public static final String URL_ESSENTIAL = "data/get/describe";
    public static final String URL_TRAIN = "";

    //"学生食堂","周边美食","附近景点","校园环境","附近银行","公交线路","快递收发"

    //?index=&pagenum=&pagesize=
    public static final String URL_STRATEGY = "data/get/byindex?index={index}&pagenum={pageNum}&pagesize={pageSize}";
}
