package com.chenyue404.notificationmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenyue404.notificationmanager.adapter.RuleListAdapter;
import com.chenyue404.notificationmanager.utils.ACache;

import org.json.JSONArray;

public class RulesFragment extends Fragment {
    private static final String KEY_RULE_LIST = "key_rule_list";
    private View rootView;
    private FloatingActionButton fab_add;
    private RecyclerView rv_list;
    private ACache aCache;
    private JSONArray dataList;
    private RuleListAdapter ruleListAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_rules, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        aCache = ACache.get(getContext());
        bindView();
        initData();
        initList();
    }

    private void bindView() {
        rv_list = rootView.findViewById(R.id.rv_list);
        fab_add = rootView.findViewById(R.id.fab_add);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RuleEditActivity.class));
            }
        });
    }

    private void initData() {
        dataList = aCache.getAsJSONArray(KEY_RULE_LIST);
    }

    private void initList() {
        ruleListAdapter = new RuleListAdapter(getContext(), dataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv_list.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        rv_list.setLayoutManager(linearLayoutManager);
        rv_list.setAdapter(ruleListAdapter);
    }
}
