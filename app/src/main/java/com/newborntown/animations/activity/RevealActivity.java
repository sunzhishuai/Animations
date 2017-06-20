package com.newborntown.animations.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.newborntown.animations.R;

/**
 * Created by sunzhishuai on 17/6/15.
 * E-mail itzhishuaisun@sina.com
 */

public class RevealActivity extends BaseActivity implements View.OnClickListener {
    private View mSample;
    private Animator circularReveal;
    private RadioButton mLeftTop;
    private CheckBox mReverse;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reveal_layout);
        mSample = findViewById(R.id.iv_sample);
        mSample.setOnClickListener(this);
        mLeftTop = (RadioButton) findViewById(R.id.rb_left_top);
        mReverse = (CheckBox) findViewById(R.id.rb_reverse);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    /**
     * 简单使用
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initSampleAnimation(boolean isCenter, boolean isReverse) {
        int width = mSample.getWidth();
        int height = mSample.getHeight();
        int r = 0;
        int centerX = 0, centerY = 0;
        if (isCenter) {
            centerX = width / 2;
            centerY = height / 2;
            r = (int) (Math.max(width / 2, height / 2) * 1.5);
        } else {
            centerX = centerY = 0;
            r = (int) (Math.max(width, height) * 1.5);
        }
        if (isReverse) {
            circularReveal = ViewAnimationUtils.createCircularReveal(mSample, centerX, centerY, r, 0);
        } else {
            circularReveal = ViewAnimationUtils.createCircularReveal(mSample, centerX, centerY, 0, r);
        }
        circularReveal.setDuration(1800);
        circularReveal.setInterpolator(new OvershootInterpolator());
        circularReveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (isReverse) {
                    mSample.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        boolean checked = mLeftTop.isChecked();
        initSampleAnimation(!checked, mReverse.isChecked());
        switch (v.getId()) {
            case R.id.iv_sample:
                circularReveal.start();
                break;
            case R.id.btn:
                mSample.setVisibility(View.VISIBLE);
                break;
        }
    }
}
