package com.newborntown.animations.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.newborntown.animations.R;

/**
 * Created by sunzhishuai on 17/6/15.
 * E-mail itzhishuaisun@sina.com
 */

public class SampleTransition2 extends BaseActivity implements View.OnClickListener {

    private ViewGroup mRootView;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_teanstion_layout_screen3);
        mRootView = (ViewGroup) findViewById(R.id.rl_container);
        findViewById(R.id.iv_sample0).setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_sample0:
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setDuration(1000);
                changeBounds.addTarget(R.id.iv_sample0);
                changeBounds.addTarget(R.id.iv_sample5);
                Scene scene2 = Scene.getSceneForLayout(mRootView, R.layout.sample_teanstion_layout_screen4, this);
                TransitionManager.go(scene2, changeBounds);
                break;
        }

    }
}
