package com.a1zu.xiangyucustomer.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Description: glide辅助类
 * Creator: Chenqiang
 * Date: 2017/2/13
 */

public class ImageLoader {

    /**
     * 加载图片
     *
     * @param url       图片地址
     * @param imageView imageView
     * @param type      默认图片类型
     */
    public static synchronized void displayImage(String url, ImageView imageView, int type) {

        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(getDefaultPic(type))
                .error(getDefaultPic(type))
                .crossFade(500)
                .into(imageView);
    }

    /**
     * 加载圆角图
     *
     * @param imageView imageView
     * @param imageUrl  图片地址
     */
    public static synchronized void displayCircle(ImageView imageView, int imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    /**
     * 默认图片
     *
     * @param type 默认图片类型
     * @return 图片id
     */
    private static int getDefaultPic(int type) {
        return 0;
    }
}
