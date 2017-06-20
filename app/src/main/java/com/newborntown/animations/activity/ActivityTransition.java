package com.newborntown.animations.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.newborntown.animations.R;

/**
 * Created by sunzhishuai on 17/6/15.
 * E-mail itzhishuaisun@sina.com
 */

public class ActivityTransition extends BaseActivity implements View.OnClickListener {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        findViewById(R.id.textView2).setOnClickListener(this);
        findViewById(R.id.textView1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView2:
                startActivity(new Intent(this, StartActivity.class));
                break;
            case R.id.textView1:
                startActivity(new Intent(this, SoloSurfaceActivity.class));
                break;
        }
    }
}
