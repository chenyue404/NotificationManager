package com.chenyue404.notificationmanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chenyue404.notificationmanager.adapter.NotificationListAdapter;
import com.chenyue404.notificationmanager.bean.NotificationBean;
import com.chenyue404.notificationmanager.greendao.DaoSession;
import com.chenyue404.notificationmanager.greendao.NotificationBeanDao;

import java.util.ArrayList;

public class NotificationListFragment extends Fragment {

    private View rootView;
    private RecyclerView rv_list;
    private NotificationBeanDao notificationBeanDao;
    private SwipeRefreshLayout srl_root;
    private NotificationListAdapter notificationListAdapter;
    private ArrayList<NotificationBean> dataList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_notification_list, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView();
        initData();
        initList();
    }

    private void bindView() {
        srl_root = rootView.findViewById(R.id.srl_root);
        rv_list = rootView.findViewById(R.id.rv_list);
    }

    private void initData() {
        MyApp myApp = (MyApp) getActivity().getApplication();
        DaoSession daoSession = myApp.getDaoSession();
        notificationBeanDao = daoSession.getNotificationBeanDao();
        dataList = (ArrayList<NotificationBean>) notificationBeanDao.loadAll();
        Toast.makeText(getContext(), dataList.size() + "", Toast.LENGTH_SHORT).show();
    }

    private void initList() {
        notificationListAdapter = new NotificationListAdapter(getContext(), dataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv_list.setLayoutManager(linearLayoutManager);
        rv_list.setAdapter(notificationListAdapter);

        srl_root.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataList = (ArrayList<NotificationBean>) notificationBeanDao.loadAll();
                notificationListAdapter.notifyDataSetChanged();
                srl_root.setRefreshing(false);
            }
        });
    }
}
