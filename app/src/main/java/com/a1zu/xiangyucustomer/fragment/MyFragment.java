package com.a1zu.xiangyucustomer.fragment;

import android.view.View;
import android.widget.TextView;

import com.a1zu.xiangyucustomer.R;
import com.a1zu.xiangyucustomer.base.BaseFragment;
import com.a1zu.xiangyucustomer.interf.OnBottomTabReselectListener;
import com.a1zu.xiangyucustomer.utils.LogUtil;
import com.a1zu.xiangyucustomer.utils.UIHelper;

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
        final TextView mTvLogin = (TextView) view.findViewById(R.id.tv_login);
        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showLogin(mContext);
            }
        });
    }

    @Override
    public void onTabReselect() {
        LogUtil.d("再次点击我的");
    }
}
