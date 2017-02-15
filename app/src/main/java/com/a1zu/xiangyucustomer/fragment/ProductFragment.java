package com.a1zu.xiangyucustomer.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.a1zu.xiangyucustomer.R;
import com.a1zu.xiangyucustomer.adapter.ProductAdapter;
import com.a1zu.xiangyucustomer.base.BaseFragment;
import com.a1zu.xiangyucustomer.interf.OnBottomTabReselectListener;
import com.a1zu.xiangyucustomer.utils.LogUtil;
import com.a1zu.xiangyucustomer.widget.TitleBar;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Description: 产品
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public class ProductFragment extends BaseFragment implements OnBottomTabReselectListener {
    @Override
    protected int getContentView() {
        return R.layout.fragment_product;
    }

    @Override
    protected void initTitleBar(View view) {
        TitleBar mTitleBar = (TitleBar) view.findViewById(R.id.title_bar);
        mTitleBar.setLeftText(getResources().getText(R.string.location));

    }

    @Override
    public void initView(View view) {
        XRecyclerView mXrvProduct = (XRecyclerView) view.findViewById(R.id.xrv_product);
        mXrvProduct.setLoadingMoreEnabled(false);
        mXrvProduct.setPullRefreshEnabled(false);
        View headerView = mInflater.inflate(R.layout.fragmen_product_header,
                (ViewGroup) view.findViewById(android.R.id.content), false);
        LinearLayout.LayoutParams layoutParams
                = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        headerView.setLayoutParams(layoutParams);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mXrvProduct.setLayoutManager(layoutManager);
        mXrvProduct.addHeaderView(headerView);
        ProductAdapter productAdapter = new ProductAdapter();
        mXrvProduct.setAdapter(productAdapter);

    }

    @Override
    public void onTabReselect() {
        LogUtil.d("再次点击产品");
    }
}
