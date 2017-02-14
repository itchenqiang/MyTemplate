package com.a1zu.xiangyucustomer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.a1zu.xiangyucustomer.R;
import com.a1zu.xiangyucustomer.fragment.NavigationFragment;
import com.a1zu.xiangyucustomer.interf.OnBottomTabReselectListener;
import com.a1zu.xiangyucustomer.widget.NavigationButton;

/**
 * Description: 主页
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public class MainActivity extends AppCompatActivity implements
        NavigationFragment.OnNavigationReselectListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    public void initView() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        NavigationFragment ft_bottom =
                (NavigationFragment) supportFragmentManager.findFragmentById(R.id.fg_navigation);
        ft_bottom.setup(supportFragmentManager, R.id.fl_content, this);
    }

    @Override
    public void onReselect(NavigationButton navigationButton) {
        Fragment fragment = navigationButton.getFragment();
        if (fragment != null
                && fragment instanceof OnBottomTabReselectListener) {
            OnBottomTabReselectListener listener = (OnBottomTabReselectListener) fragment;
            listener.onTabReselect();
        }
    }
}
