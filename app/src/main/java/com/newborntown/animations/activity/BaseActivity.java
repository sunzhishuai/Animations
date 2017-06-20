package com.newborntown.animations.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;

/**
 * Created by sunzhishuai on 17/6/15.
 * E-mail itzhishuaisun@sina.com
 */

public class BaseActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        super.onCreate(savedInstanceState);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);
        Slide slide = new Slide();
        slide.setDuration(800);
        Explode explode = new Explode();
        explode.setDuration(800);
        slide.setSlideEdge(Gravity.TOP);

        getWindow().setEnterTransition(slide);
//        getWindow().setExitTransition(fade);
//        getWindow().setReenterTransition(slide);
        getWindow().setReturnTransition(explode);

    }
}
