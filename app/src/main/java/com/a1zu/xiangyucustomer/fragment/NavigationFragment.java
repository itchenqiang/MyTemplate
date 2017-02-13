package com.a1zu.xiangyucustomer.fragment;

import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.a1zu.xiangyucustomer.R;
import com.a1zu.xiangyucustomer.base.BaseFragment;
import com.a1zu.xiangyucustomer.widget.BorderShape;
import com.a1zu.xiangyucustomer.widget.NavigationButton;

import java.util.List;

/**
 * Description: 底部导航栏
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public class NavigationFragment extends BaseFragment implements View.OnClickListener {

    private NavigationButton mCurrentNavigationButton;
    private FragmentManager mFragmentManager;
    private int mContentId;
    private OnNavigationReselectListener mOnNavigationReselectListener;
    private NavigationButton mNbProduct;
    private NavigationButton mNbMy;
    private NavigationButton mNbMore;

    public interface OnNavigationReselectListener {
        void onReselect(NavigationButton navigationButton);
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_navagation;
    }

    @Override
    public void initView(View view) {
        ShapeDrawable lineDrawable = new ShapeDrawable(new BorderShape(new RectF(0, 1, 0, 0)));
        lineDrawable.getPaint().setColor(getResources().getColor(R.color.navigation_divider_color));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{
                new ColorDrawable(Color.WHITE),
                lineDrawable
        });
        view.setBackground(layerDrawable);
        mNbProduct = (NavigationButton) view.findViewById(R.id.nb_product);
        mNbMy = (NavigationButton) view.findViewById(R.id.nb_my);
        mNbMore = (NavigationButton) view.findViewById(R.id.nb_more);
    }

    @Override
    public void initData() {
        super.initData();
        mNbProduct.init(R.drawable.tab_icon_new,
                R.string.main_tab_name_product,
                ProductFragment.class);

        mNbMy.init(R.drawable.tab_icon_tweet,
                R.string.main_tab_name_my,
                MyFragment.class);

        mNbMore.init(R.drawable.tab_icon_explore,
                R.string.main_tab_name_more,
                MoreFragment.class);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mNbProduct.setOnClickListener(this);
        mNbMy.setOnClickListener(this);
        mNbMore.setOnClickListener(this);
    }

    public void setup(FragmentManager fragmentManager, int contentId, OnNavigationReselectListener listener) {
        mFragmentManager = fragmentManager;
        mContentId = contentId;
        mOnNavigationReselectListener = listener;

        // do clear
        clearOldFragment();
        // do select first
        doSelect(mNbProduct);
    }

    private void clearOldFragment() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        List<Fragment> fragments = mFragmentManager.getFragments();
        if (transaction == null || fragments == null || fragments.isEmpty())
            return;
        boolean doCommit = false;
        for (Fragment fragment : fragments) {
            if (fragment != this) {
                transaction.remove(fragment);
                doCommit = true;
            }
        }
        if (doCommit)
            transaction.commit();
    }

    @Override
    public void onClick(View view) {
        if (view instanceof NavigationButton) {
            NavigationButton navigationButton = (NavigationButton) view;
            doSelect(navigationButton);
        }
    }

    private void doSelect(NavigationButton newNavigationButton) {
        NavigationButton oldNavigationButton = null;
        if (mCurrentNavigationButton != null) {
            oldNavigationButton = mCurrentNavigationButton;
            if (oldNavigationButton == newNavigationButton) {
                //重新刷新页面
                mOnNavigationReselectListener.onReselect(oldNavigationButton);
                return;
            }
            oldNavigationButton.setSelected(false);
        }
        newNavigationButton.setSelected(true);
        doTabChanged(oldNavigationButton, newNavigationButton);
        mCurrentNavigationButton = newNavigationButton;
    }

    private void doTabChanged(NavigationButton oldNavigationButton, NavigationButton newNavigationButton) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (oldNavigationButton != null) {
            if (oldNavigationButton.getFragment() != null) {
                fragmentTransaction.detach(oldNavigationButton.getFragment());
            }
        }
        if (newNavigationButton != null) {
            if (newNavigationButton.getFragment() == null) {
                Fragment fragment = Fragment.instantiate(mContext, newNavigationButton.getClx().getName(), null);
                fragmentTransaction.add(mContentId, fragment, newNavigationButton.getTag());
                newNavigationButton.setFragment(fragment);
            } else {
                fragmentTransaction.attach(newNavigationButton.getFragment());
            }
        }
        fragmentTransaction.commit();
    }
}
