package com.newborntown.animations.opengl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunzhishuai on 17/6/19.
 * E-mail itzhishuaisun@sina.com
 */

public abstract class SoloSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private int mScreenMinWidth = 100;
    private int mScreenMinHeight = 100;
    private SurfaceHolder mHolder;
    private int backgroundColor = Color.parseColor("#00ca77");
    public boolean isDrawing;
    private int counts = 0; //周期绘制次数;

    private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5); //线程池
    private long periodMillis = setPeriod(); //周期;

    public SoloSurfaceView(Context context) {
        this(context, null);
    }

    public SoloSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SoloSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initConfig();
    }

    /**
     * 初始化设置
     */
    private void initConfig() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mHolder = this.getHolder();
        mHolder.addCallback(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST) {
            widthSize = mScreenMinWidth;
        }
        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = mScreenMinHeight;
        }
        setMeasuredDimension(widthSize, heightSize);
    }

    /**
     * 重写了 但是我们什么都不做 为的是 我们自己在子线程中处理绘制 达到流畅目的
     *
     * @param canvas 画板
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawing = true;
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (isDrawing) {
            if (periodMillis > 0) {
                scheduledThreadPool.scheduleAtFixedRate(this, 0, periodMillis, TimeUnit.MILLISECONDS);
            } else {
                invalidateOutUiThread();
            }
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false;
        stopInvalidate();
    }

    @Override
    public void run() {
        if (isDrawing) {
            Canvas mCanvas = mHolder.lockCanvas();
            clearCanvas(mCanvas);
            drawBackground(mCanvas);
            onDrawOutUiThread(mCanvas, counts * periodMillis);
            mHolder.unlockCanvasAndPost(mCanvas);
        }
        if (periodMillis > 0) {
            counts++;
        }
    }

    protected void clearCanvas(Canvas canvas) {
        // 清屏
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }


    /**
     * 子线程绘制 重写
     *
     * @param canvas 画板
     * @param time   绘制时间  （周期绘制时候使用）
     */
    public abstract void onDrawOutUiThread(Canvas canvas, long time);


    /**
     * 引起view在非ui线程重新绘制
     */
    public void invalidateOutUiThread() {
        if (isDrawing) {
            scheduledThreadPool.schedule(this, 0, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * 延迟引起view在非ui线程重新绘制
     */

    public void invalidateOutUiThreadDelayed(long delayMillis) {
        if (isDrawing) {
            scheduledThreadPool.schedule(this, delayMillis, TimeUnit.MILLISECONDS);
        }
    }


    /**
     * 停止绘制
     */
    public void stopInvalidate() {
        this.periodMillis = 0;
        scheduledThreadPool.shutdown();
    }


    /**
     * 绘制背景颜色
     */
    private void drawBackground(Canvas canvas) {
        canvas.drawColor(backgroundColor);
    }

    /**
     * 设置view 最小宽高 也就是 wrap_content 时候默认尺寸
     *
     * @param width  宽
     * @param height 高
     */
    public void setmScreenMinSize(int width, int height) {
        mScreenMinWidth = width;
        mScreenMinHeight = height;
    }

    /**
     * 设置背景色方法
     *
     * @param color 背景颜色
     */
    public void setBackgroundColor(int color) {
        this.backgroundColor = color;
    }

    /**
     * 返回view是否正在绘制
     *
     * @return 绘制状态
     */
    public boolean getDrawState() {
        return isDrawing;
    }

    /**
     * 设置绘制周期 需要周期绘制时候必须重写
     *
     * @return 绘制周期
     */
    public long setPeriod() {

        return 0;
    }
}
