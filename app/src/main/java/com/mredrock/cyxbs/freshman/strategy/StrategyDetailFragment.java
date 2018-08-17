package com.mredrock.cyxbs.freshman.strategy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.activity.StrategyMainActivity;
import com.mredrock.cyxbs.freshman.adapter.BaseAdapter;
import com.mredrock.cyxbs.freshman.data.StrategyData;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class StrategyDetailFragment extends Fragment implements PresenterContractStrategy.Show {

    public static final String Tag = "detailFragment";
    private static String flag;
    @BindView(R.id.strategy_recycler_list)
    public RecyclerView recycler;
    Unbinder unbinder;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private ArrayList<StrategyData.Data> list;
    private BaseAdapter adapter = null;
    private String mflag;

    public static StrategyDetailFragment getInstance(String s) {
        StrategyDetailFragment fragment = new StrategyDetailFragment();
        flag = s;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.strategy_five_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        Log.e(Tag, "CreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout.setVisibility(View.GONE);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        Log.e(Tag, "ViewCreated");
        if (this.adapter == null) {
            Log.d(Tag, "bindAdapter");
            this.list = dataTest(flag);
            adapter = new BaseAdapter(list, DataTypeManager.DataBean.STRATEGY, getContext());
            recycler.setAdapter(adapter);
        } else {
            this.list = dataTest(mflag);
            Log.d(Tag, "refreshItem");
            adapter.refreshItem(list);
        }
    }

    private ArrayList<StrategyData.Data> dataTest(String s) {
        ArrayList<StrategyData.Data> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StrategyData.Data bean = new StrategyData.Data();
            bean.setName(s);
            bean.setContent("很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长");
            bean.setId(++i);
            data.add(bean);
        }
        return data;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public ArrayList<StrategyData.Data> getList() {
        dataTest(flag);
        return this.list;
    }

    @Override
    public void changeList(String s) {
        mflag = s;
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("detail", "onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("detail", "onStop");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("detail", "onAttach");
    }

    @Override
    public void onPause() {
        super.onPause();
        StrategyMainActivity activity = (StrategyMainActivity) getActivity();
        activity.setBar("校园攻略");

        Log.d("detail", "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("detail", "onPause");
    }
}
