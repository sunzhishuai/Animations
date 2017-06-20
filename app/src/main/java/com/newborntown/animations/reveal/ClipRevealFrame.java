package com.newborntown.animations.reveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by sunzhishuai on 17/6/20.
 * E-mail itzhishuaisun@sina.com
 */

public class ClipRevealFrame  extends FrameLayout{
    private Path mRevealPath;
    boolean mClipOutlines;
    float mCenterX;
    float mCenterY;
    float mRadius;

    public ClipRevealFrame(Context context) {
        super(context);
        init();
    }

    public ClipRevealFrame(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipRevealFrame(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRevealPath = new Path();
        mClipOutlines = false;
        setWillNotDraw(false);//引起viewgroup 的ondraw 方法回调
    }

    public void setClipOutLines(boolean shouldClip) {
        mClipOutlines = shouldClip;
    }

    public void setClipCenter(final int x, final int y) {
        mCenterX = x;
        mCenterY = y;
    }

    public void setClipRadius(final float radius) {
        mRadius = radius;
        invalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        if (!mClipOutlines) {
            super.draw(canvas);
            return;
        }
        //切割canvas
        final int state = canvas.save();
        mRevealPath.reset();
        mRevealPath.addCircle(mCenterX, mCenterY, mRadius, Path.Direction.CW);
        canvas.clipPath(mRevealPath);
        super.draw(canvas);
        canvas.restoreToCount(state);
    }
}
