package com.newborntown.animations.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by sunzhishuai on 17/6/15.
 * E-mail itzhishuaisun@sina.com
 */

public class RoundDrawable extends Drawable {
    private Paint mPaint;
    private Bitmap mBitmap;
    private int r;

    public RoundDrawable(Bitmap bitmap) {
        mBitmap = bitmap;
        r = Math.min(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(bitmapShader);
    }

    public RoundDrawable(BitmapDrawable bitmapDrawable) {
        mBitmap = bitmapDrawable.getBitmap();
        r = Math.min(mBitmap.getWidth() / 2, mBitmap.getHeight() / 2);
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(bitmapShader);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(r, r, r, mPaint);
    }

    @Override
    public int getIntrinsicWidth() {
        return r * 2;
    }

    @Override
    public int getIntrinsicHeight() {
        return r * 2;
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
