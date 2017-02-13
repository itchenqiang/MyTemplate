package com.a1zu.xiangyucustomer.interf;

import android.view.View;

/**
 * Description: fragment基类
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public interface BaseFragmentInterface {

    void initView(View view);

    void initData();

    void showLoading();

    void hideLoading();
}
