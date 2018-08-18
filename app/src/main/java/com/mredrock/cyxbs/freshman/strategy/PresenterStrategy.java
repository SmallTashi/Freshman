package com.mredrock.cyxbs.freshman.strategy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.data.StrategyData;

import java.util.List;

public class PresenterStrategy implements PresenterContractStrategy.ChangeFragment, PresenterContractStrategy.callback {
    private List<StrategyData.ArrayBean> list;
    private PresenterContractStrategy.get get = new ModelStrategy(this);
    private StrategyMainFragment mainFragment;
    private FragmentManager manager;

    private FragmentTransaction transaction;

    public PresenterStrategy(FragmentManager manager) {
        this.manager = manager;
    }


    @Override
    public void addMainFragment(StrategyMainFragment fragment) {
        this.mainFragment = fragment;
        transaction = manager.beginTransaction();
        transaction.add(R.id.strategy_fragment, mainFragment, "main")
                .commit();
    }

    @Override
    public List<StrategyData.ArrayBean> getList(String s) {
        get.getData(s);
        return list;
    }

    @Override
    public void into(String s) {
        transaction = manager.beginTransaction();

        StrategyDetailFragment detailFragment = StrategyDetailFragment.getInstance(s);
        transaction.hide(mainFragment)
                .addToBackStack(null)
                .add(R.id.strategy_fragment, detailFragment)
                .commit();

    }


    @Override
    public void loadData(List<StrategyData.ArrayBean> data) {
        list = data;
    }

    @Override
    public void onFailed() {

    }
}
