package com.newborntown.animations.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.newborntown.animations.opengl.SparkView;

/**
 * Created by sunzhishuai on 17/6/19.
 * E-mail itzhishuaisun@sina.com
 */

public class StartActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SparkView sparkView = new SparkView(this);
        setContentView(sparkView);
    }
}
