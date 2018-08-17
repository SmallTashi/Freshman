package com.mredrock.cyxbs.freshman.strategy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.adapter.BaseAdapter;
import com.mredrock.cyxbs.freshman.data.StrategyData;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class StrategyTabFragment extends Fragment {

    @BindView(R.id.strategy_fragment_recycler)
    RecyclerView strategyFragmentRecycler;
    Unbinder unbinder;
    private String flag;

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
        BaseAdapter adapter = new BaseAdapter(dataTest(flag), DataTypeManager.Ui.STRATEGY_DORMITORY, getContext());
        strategyFragmentRecycler.setAdapter(adapter);
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


}
