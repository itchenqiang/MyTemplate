package com.a1zu.xiangyucustomer.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

import com.a1zu.xiangyucustomer.application.MyApplication;

/**
 * Description: 获取手机信息
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public class SystemInfoUtils {

    private static final String TAG = SystemInfoUtils.class.getSimpleName();

    /**
     * 获取版本号
     *
     * @return 版本号
     */
    public static String getVersionName() {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = MyApplication.getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(MyApplication.getContext().getPackageName(), 0);
            versionName = pi.versionName;
            // versioncode = pi.versionCode;
            if (versionName == null) {
                return "";
            }
        } catch (Exception e) {
            LogUtil.e(TAG, "VersionInfo Exception: " + e);
        }
        return versionName;
    }

    private static TelephonyManager getDeviceInfo() {
        return (TelephonyManager) MyApplication.getContext()
                .getSystemService(Application.TELEPHONY_SERVICE);
    }

    /**
     * 获取设备id
     *
     * @return 设备id
     */
    public static String getDeviceId() {
        return getDeviceInfo().getDeviceId();
    }

    /**
     * 获取设备类型
     *
     * @return 设备类型
     */
    public static String getDeviceType() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取屏幕宽
     *
     * @return 屏幕宽
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = MyApplication.getContext().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高
     *
     * @return 屏幕高
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = MyApplication.getContext().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 判断是否有网络
     *
     * @return true：有网络
     */
    public static boolean hasInternet() {
        ConnectivityManager cm = (ConnectivityManager) MyApplication.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.isAvailable() && info.isConnected();
    }

}
