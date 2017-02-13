package com.a1zu.xiangyucustomer.fragment;

import android.view.View;

import com.a1zu.xiangyucustomer.R;
import com.a1zu.xiangyucustomer.base.BaseFragment;
import com.a1zu.xiangyucustomer.interf.OnBottomTabReselectListener;
import com.a1zu.xiangyucustomer.utils.LogUtil;

/**
 * Description: 我的
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public class MyFragment extends BaseFragment implements OnBottomTabReselectListener {
    @Override
    protected int getContentView() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void onTabReselect() {
        LogUtil.d("再次点击我的");
    }
}