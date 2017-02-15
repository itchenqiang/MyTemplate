package com.a1zu.xiangyucustomer.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.a1zu.xiangyucustomer.R;

/**
 * Description: 标题栏
 * Creator: Chenqiang
 * Date: 2017/2/14
 */

public class TitleBar extends FrameLayout {


    private TextView mTvLeft;
    /**
     * 中间标题
     */
    private TextView mTvTitle;
    private TextView mTvRight;

    public TitleBar(Context context) {
        super(context);
        init();
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_title_bar, this, true);
        mTvLeft = (TextView) findViewById(R.id.tv_left);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvRight = (TextView) findViewById(R.id.tv_right);
    }

    /**
     * 左侧更换图标
     *
     * @param id 资源id
     */
    public void setLeftBacgroud(@DrawableRes int id) {
        mTvLeft.setBackgroundResource(id);
    }

    /**
     * 左侧文字
     *
     * @param text text
     */
    public void setLeftText(CharSequence text) {
        mTvLeft.setText(text);
    }

    /**
     * 右侧更换图标
     *
     * @param id 资源id
     */
    public void setRightBacgroud(@DrawableRes int id) {
        mTvRight.setBackgroundResource(id);
    }

    /**
     * 设置标题
     *
     * @param id 字符串id
     */
    public void setTitle(int id) {
        mTvTitle.setText(getResources().getText(id));
    }

    /**
     * 左侧点击事件处理
     */
    public void setLeftClickLisener(OnClickListener listener) {
        mTvLeft.setOnClickListener(listener);
    }
}
