package com.newborntown.animations.utils;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.newborntown.animations.drawable.RoundDrawable;

/**
 * Created by sunzhishuai on 17/6/18.
 * E-mail itzhishuaisun@sina.com
 */

public class DrawableUtils {
    /**
     * 获取圆形图片
     *
     * @param drawable
     * @return
     */
    public static RoundDrawable getRoundDrawable(Drawable drawable) {
        return new RoundDrawable((BitmapDrawable) drawable);
    }
}
