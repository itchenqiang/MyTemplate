package com.a1zu.xiangyucustomer.network;


import com.a1zu.xiangyucustomer.utils.SPUtils;
import com.a1zu.xiangyucustomer.utils.SystemInfoUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/**
 * Description: OKHttp辅助类
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public class HttpHelper {

    private HttpHelper() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("okHttp", true))
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    /**
     * get请求
     *
     * @param url       请求地址
     * @param paramList 请求参数，没有传null
     * @param callback  回调
     */
    public static void get(String url, List<Param> paramList, Callback<String> callback) {
        GetBuilder getBuilder = OkHttpUtils.get().url(url);
        if (!paramList.isEmpty()) {
            for (Param param : paramList) {
                getBuilder.addParams(param.key, param.value);
            }
        }
        getBuilder.build().execute(callback);
    }

    /**
     * json方式post请求
     *
     * @param url        请求地址
     * @param JsonString 请求参数
     * @param callback   回调
     */
    public static void postJson(String url, String JsonString, Callback<String> callback) {
        OkHttpUtils
                .postString()
                .url(url)
                .content(JsonString)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(callback);
    }

    /**
     * 普通POST
     *
     * @param url       请求地址
     * @param paramList 请求参数，没有传null
     * @param callback  回调
     */
    public static void postString(String url, List<Param> paramList, Callback<String> callback) {
        PostFormBuilder builder = OkHttpUtils.post().url(url);
        if (!paramList.isEmpty()) {
            for (Param param : paramList) {
                builder.addParams(param.key, param.value);
            }
        }
        builder.build().execute(callback);
    }

    /**
     * 上传文件
     *
     * @param url      请求地址
     * @param file     文件（图片。。。）
     * @param callback 回调
     */
    public static void postFile(String url, File file, Callback<String> callback) {
        OkHttpUtils
                .postFile()
                .url(url)
                .file(file)
                .build()
                .execute(callback);
    }

    /**
     * 下载
     *
     * @param url      请求地址
     * @param callback 回调
     */
    public static void downloadFile(String url, Callback<File> callback) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 请求参数类
     */
    public static class Param {

        String key;
        String value;

        public Param() {
        }

        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    public static ArrayList<Param> getParamList() {
        ArrayList<Param> paramArrayList = new ArrayList<>();
        paramArrayList.add(new HttpHelper.Param("deviceType", SystemInfoUtils.getDeviceType()));
        paramArrayList.add(new HttpHelper.Param("deviceID", SystemInfoUtils.getDeviceId()));
        paramArrayList.add(new HttpHelper.Param("token", SPUtils.getString("token", "")));
        paramArrayList.add(new HttpHelper.Param("version", SystemInfoUtils.getVersionName()));
        return paramArrayList;
    }


}
