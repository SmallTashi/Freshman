package com.mredrock.cyxbs.freshman.strategy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.adapter.BaseAdapter;
import com.mredrock.cyxbs.freshman.data.StrategyData;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class StrategyTabFragment extends Fragment implements PresenterContractStrategy.callback {

    @BindView(R.id.strategy_fragment_recycler)
    RecyclerView strategyFragmentRecycler;
    Unbinder unbinder;
    private String flag;
    List<StrategyData.ArrayBean> list;
    ModelStrategy get = new ModelStrategy(this);

    public static StrategyTabFragment getInstance(String s) {
        StrategyTabFragment f = new StrategyTabFragment();
        f.flag = s;
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_strategy_dormitory_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        strategyFragmentRecycler.setLayoutManager(manager);
        get.getData(flag);
        BaseAdapter adapter = new BaseAdapter(list, DataTypeManager.Ui.STRATEGY_DORMITORY, getContext());
        strategyFragmentRecycler.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void loadData(List<StrategyData.ArrayBean> data) {
        this.list = data;
    }

    @Override
    public void onFailed() {
        Toast.makeText(getContext(), "数据加载失败", Toast.LENGTH_SHORT).show();
    }
}
