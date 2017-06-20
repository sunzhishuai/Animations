package com.newborntown.animations.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.newborntown.animations.R;
import com.newborntown.animations.utils.DrawableUtils;

import java.util.List;

/**
 * Created by sunzhishuai on 17/6/16.
 * E-mail itzhishuaisun@sina.com
 */

public class BelleAdapter extends RecyclerView.Adapter<BelleAdapter.BelleViewHolder> implements View.OnClickListener {
    private List<Integer> list;
    private Context context;

    public BelleAdapter(List<Integer> list) {
        this.list = list;
    }

    @Override
    public BelleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        BelleViewHolder belleViewHolder = new BelleViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
        return belleViewHolder;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(BelleViewHolder holder, int position) {
        Integer id = list.get(position);
        Drawable drawable = context.getResources().getDrawable(id);
        holder.mIcon.setBackground(DrawableUtils.getRoundDrawable(drawable));
        holder.mIcon.setTag(position);
        holder.mIcon.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (listener != null) {
            listener.onItemClick(v, position);
        }
    }

    class BelleViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIcon;

        public BelleViewHolder(View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);


    }
}
