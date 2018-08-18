package com.mredrock.cyxbs.freshman.strategy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;
import com.mredrock.cyxbs.freshman.utils.TabPagerLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class StrategPageryFragment extends Fragment {

    private static String flag;
    @BindView(R.id.strategy_fragment_pager)
    ViewPager strategyFragmentPager;
    @BindView(R.id.strategy_fragment_tab)
    TabLayout strategyFragmentTab;
    Unbinder unbinder;

    public static StrategyDetailFragment getInstance(String s) {
        StrategyDetailFragment fragment = new StrategyDetailFragment();
        flag = s;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_strategy_dormitory_pager, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        strategyFragmentTab.setVisibility(View.VISIBLE);
        ArrayList<Fragment> fragments = new ArrayList<>();
        TabPagerLoader loader;
        switch (flag) {
            case DataTypeManager.STRATEGY.DORMITORY:
                fragments.add(StrategyTabFragment.getInstance(DataTypeManager.STRATEGY.DOR_ONE));
                fragments.add(StrategyTabFragment.getInstance(DataTypeManager.STRATEGY.DOR_TWO));
                fragments.add(StrategyTabFragment.getInstance(DataTypeManager.STRATEGY.DOR_THREE));
                fragments.add(StrategyTabFragment.getInstance(DataTypeManager.STRATEGY.DOR_FOUR));
                loader = new TabPagerLoader(this.getFragmentManager(), fragments, DataTypeManager.Ui.STRATEGY_DORMITORY);
                loader.setUi(strategyFragmentPager, strategyFragmentTab);
                break;
            case DataTypeManager.STRATEGY.DATA:
                fragments.add(StrategyDetailFragment.getInstance("男女比例"));
                loader = new TabPagerLoader(this.getFragmentManager(), fragments, DataTypeManager.Ui.STRATEGY_DATA);
                loader.setUi(strategyFragmentPager, strategyFragmentTab);
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
