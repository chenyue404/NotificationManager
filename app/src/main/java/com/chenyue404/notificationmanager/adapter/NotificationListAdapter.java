package com.chenyue404.notificationmanager.adapter;

import android.app.Notification;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chenyue404.notificationmanager.R;
import com.chenyue404.notificationmanager.bean.NotificationBean;
import com.chenyue404.notificationmanager.utils.CommonUtils;

import java.util.ArrayList;

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<NotificationBean> dataList;

    public NotificationListAdapter(Context context, ArrayList<NotificationBean> list) {
        super();
        this.mContext = context;
        this.dataList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_notification, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NotificationBean notificationBean = dataList.get(position);
        holder.tv_title.setText(notificationBean.getTitle());
        holder.tv_content.setText(notificationBean.getText());
        holder.tv_time.setText(CommonUtils.getTimeStr(notificationBean.getPostTime()));
    }

    @Override
    public int getItemCount() {
        if (dataList == null) {
            return 0;
        } else {
            return dataList.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_title, tv_content, tv_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }
}
