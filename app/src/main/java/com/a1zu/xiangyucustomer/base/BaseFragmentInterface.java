package com.a1zu.xiangyucustomer.base;

import android.view.View;

/**
 * Description:
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public interface BaseFragmentInterface {

    void initView(View view);

    void initData();

    void showLoading();

    void hideLoading();
}
