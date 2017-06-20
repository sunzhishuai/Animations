package com.newborntown.animations.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

import com.newborntown.animations.R;
import com.newborntown.animations.animation.ChangeColor;

/**
 * Created by sunzhishuai on 17/6/14.
 * E-mail itzhishuaisun@sina.com
 */

public class ColorActivity extends BaseActivity implements View.OnClickListener {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_layout);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        LinearLayout viewById = (LinearLayout) findViewById(R.id.ll_container);
        viewById.setBackgroundColor(Color.BLUE);
        ChangeColor colorChange = new ChangeColor();
        colorChange.setDuration(1000);
        colorChange.setInterpolator(new LinearInterpolator());
        TransitionManager.beginDelayedTransition(viewById, colorChange);
        viewById.setBackgroundColor(Color.YELLOW);
    }
}
