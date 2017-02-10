package com.a1zu.xiangyucustomer.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Description: Toast辅助类
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public class ToastUtil {
    private static Toast sToast;

    public static void showToast(Context context, String message) {
        if (context == null) {
            return;
        }
        if (sToast == null) {
            sToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

    public static void showToast(Context context, int res) {
        if (context == null) {
            return;
        }
        if (sToast != null) {
            sToast.setText(context.getString(res));
        } else {
            sToast = Toast.makeText(context, context.getString(res), Toast.LENGTH_SHORT);
        }
        sToast.show();
    }
}
