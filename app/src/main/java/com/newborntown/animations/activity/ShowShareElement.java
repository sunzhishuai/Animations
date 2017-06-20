package com.newborntown.animations.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

import com.newborntown.animations.R;
import com.newborntown.animations.utils.DataUtils;

/**
 * Created by sunzhishuai on 17/6/18.
 * E-mail itzhishuaisun@sina.com
 */

public class ShowShareElement extends BaseActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int position = getIntent().getIntExtra("position", -1);
        setContentView(R.layout.show_share_element);
        ImageView iVshow = (ImageView) findViewById(R.id.iv_icon);
        Drawable drawable = getResources().getDrawable(DataUtils.getDrawbles().get(position));
        iVshow.setBackground(drawable);
    }
}
