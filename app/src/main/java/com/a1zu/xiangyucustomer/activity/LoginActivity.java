package com.a1zu.xiangyucustomer.activity;

import android.content.Context;
import android.content.Intent;

import com.a1zu.xiangyucustomer.R;
import com.a1zu.xiangyucustomer.base.BaseActivity;

/**
 * Description:
 * Creator: Chenqiang
 * Date: 2017/2/14
 */

public class LoginActivity extends BaseActivity {

    public static void actionStart(Context context) {
        Intent mIntent = new Intent(context, LoginActivity.class);
        context.startActivity(mIntent);
    }


    @Override
    protected void initTitleBar() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }
}
