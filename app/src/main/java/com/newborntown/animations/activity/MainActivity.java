package com.newborntown.animations.activity;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.newborntown.animations.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView mShow;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        mShow = (TextView) findViewById(R.id.tv_show);
        TextPaint paint = mShow.getPaint();
        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.mipmap.color);
        paint.setShader(new BitmapShader(drawable.getBitmap(), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        initTransitionAnimation();

    }

    /**
     * 添加 过度动画
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initTransitionAnimation() {
        Slide slide = new Slide();
        slide.setDuration(800);
        Fade fade = new Fade();
        fade.setDuration(800);
        Explode explode = new Explode();
        explode.setDuration(800);
        slide.setSlideEdge(Gravity.BOTTOM);
//        getWindow().setEnterTransition(slide);
        getWindow().setExitTransition(slide);
        getWindow().setReenterTransition(fade);
//        getWindow().setReturnTransition(fade);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                //揭露动画
                startActivity(new Intent(this, RevealActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                break;
            case R.id.button2:
                //简单转场动画
                startActivity(new Intent(this, SampleTransition.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                break;
            case R.id.button3:
                //简单转场动画
                startActivity(new Intent(this, SampleTransition2.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                break;
            case R.id.button4:
                //Activity转场动画
                startActivity(new Intent(this, ActivityTransition.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.button5:
                //共享元素
                startActivity(new Intent(this, ShareElementTransition.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.button6:
                startActivity(new Intent(this, ColorActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
        }
    }
}
