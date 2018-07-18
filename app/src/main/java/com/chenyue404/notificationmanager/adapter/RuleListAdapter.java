package com.chenyue404.notificationmanager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenyue404.notificationmanager.R;

import org.json.JSONArray;

public class RuleListAdapter extends RecyclerView.Adapter<RuleListAdapter.MyViewHolder> {

    private Context mContext;
    private JSONArray dataList;

    public RuleListAdapter(Context context, JSONArray list) {
        super();
        this.mContext = context;
        this.dataList = list;
    }

    @Override
    public RuleListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_rule, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RuleListAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (dataList == null) {
            return 0;
        } else {
            return dataList.length();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_title, tv_content, tv_time;
        public ImageView sdv_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_time = itemView.findViewById(R.id.tv_time);
            sdv_icon = itemView.findViewById(R.id.sdv_icon);
        }
    }
}
