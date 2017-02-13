package com.a1zu.xiangyucustomer.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * Description: Gson帮助类
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public class GsonUtils {

    public static String toJsonString(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static <T> T toObject(String jsonString, Class<T> cls) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, cls);
    }

    public static <T> List<T> toList(String gsonString, Class<T> cls) {
        Gson gson = new Gson();
        return gson.fromJson(gsonString, new TypeToken<List<T>>() {
        }.getType());
    }


    public static <T> List<Map<String, T>> toListMaps(String jsonString) {
        List<Map<String, T>> list;
        Gson gson = new Gson();
        list = gson.fromJson(jsonString, new TypeToken<List<Map<String, T>>>() {
        }.getType());
        return list;
    }

    public static <T> Map<String, T> toMaps(String jsonString) {
        Map<String, T> map;
        Gson gson = new Gson();
        map = gson.fromJson(jsonString, new TypeToken<Map<String, T>>() {
        }.getType());
        return map;
    }
}
