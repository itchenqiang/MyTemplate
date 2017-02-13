package com.a1zu.xiangyucustomer.base;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a1zu.xiangyucustomer.R;
import com.a1zu.xiangyucustomer.interf.BaseFragmentInterface;
import com.a1zu.xiangyucustomer.network.HttpHelper;
import com.a1zu.xiangyucustomer.utils.DialogHelper;
import com.a1zu.xiangyucustomer.utils.LogUtil;
import com.a1zu.xiangyucustomer.utils.SystemInfoUtils;
import com.a1zu.xiangyucustomer.utils.ToastUtil;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Description: fragment基类
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public abstract class BaseFragment extends Fragment implements BaseFragmentInterface {

    private ProgressDialog mProgressDialog;
    protected Context mContext;
    /**
     * 网络请求回调
     */
    protected StringCallback mStringCallback = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {
            ToastUtil.showToast(mContext, R.string.request_error);
            LogUtil.d(e.toString());
        }

        @Override
        public void onResponse(String response, int id) {
            onSuccess(response, id);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(getContentView(), container, false);
        initView(view);
        initData();
        initListener();
        return view;
    }

    /**
     * 设置布局
     *
     * @return 布局id
     */
    protected abstract int getContentView();

    /**
     * 子类实现
     */
    @Override
    public void initData() {

    }

    /**
     * 点击事件统一处理,子类选择性实现
     */
    protected void initListener() {
    }

    /**
     * 发起网络请求，子类需要网络请求重写该方法
     */
    protected void requestServer() {
        if (!SystemInfoUtils.hasInternet()) {
            ToastUtil.showToast(mContext, R.string.net_error);
            return;
        }
    }

    /**
     * 访问网络成功后，实现该类
     *
     * @param response 返回结果
     * @param id       id
     */
    protected void onSuccess(String response, int id) {

    }

    @Override
    public void showLoading() {
        if (mProgressDialog == null) {
            mProgressDialog = DialogHelper.getProgressDialog(mContext, R.string.loading, false);
        }
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.hide();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideLoading();
        HttpHelper.getInstance().cancelRequest(mContext);
        mContext = null;
    }
}
