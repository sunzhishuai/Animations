package com.newborntown.animations.activity;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.newborntown.animations.R;
import com.newborntown.animations.utils.DataUtils;

/**
 * Created by sunzhishuai on 17/6/15.
 * E-mail itzhishuaisun@sina.com
 */

public class ShareElementTransition extends AppCompatActivity implements BelleAdapter.OnItemClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_element_transition);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rl_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        BelleAdapter belleAdapter = new BelleAdapter(DataUtils.getDrawbles());
        mRecyclerView.setAdapter(belleAdapter);
        belleAdapter.setOnItemClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, ShowShareElement.class);
        intent.putExtra("position",position);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this, view, "share").toBundle());
    }
}
