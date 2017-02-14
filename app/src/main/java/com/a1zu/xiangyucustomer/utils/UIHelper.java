package com.a1zu.xiangyucustomer.utils;

import android.content.Context;

import com.a1zu.xiangyucustomer.activity.LoginActivity;

/**
 * Description:
 * Creator: Chenqiang
 * Date: 2017/2/14
 */

public class UIHelper {

    /**
     * 显示登录页面
     *
     * @param context context
     */
    public static void showLogin(Context context) {
        LoginActivity.actionStart(context);
    }
}
