package com.newborntown.animations.opengl;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import java.util.Random;

/**
 * Created by sunzhishuai on 17/6/19.
 * E-mail itzhishuaisun@sina.com
 */

public class SoloSample extends SoloSurfaceView {
    private float r;
    private Paint paint;

    public SoloSample(Context context) {
        this(context, null);
    }

    public SoloSample(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SoloSample(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);

    }

    @Override
    public void onDrawOutUiThread(Canvas canvas, long time) {
        Random random = new Random();
        paint.setColor(Color.rgb(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
        if(r<=200){
            canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, r, paint);
        }
        if (r > 200) {
            canvas.drawRect(canvas.getWidth() / 2 - r / 2, canvas.getHeight() / 2 - r / 2,
                    canvas.getWidth() / 2 + r / 2, canvas.getHeight() / 2 + r / 2, paint);
        }
        if (r > 400) {
            r = 0;
        }
        r = r + 5;
    }

    @Override
    public long setPeriod() {
        return 1000;
    }


}