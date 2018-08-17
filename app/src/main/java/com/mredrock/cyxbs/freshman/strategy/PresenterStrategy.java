package com.mredrock.cyxbs.freshman.strategy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.data.StrategyData;

import java.util.ArrayList;

public class PresenterStrategy implements PresenterContractStrategy.ChangeFragment {

    private static PresenterContractStrategy.get get = new ModelStrategy();
    private StrategyMainFragment mainFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    public PresenterStrategy(FragmentManager manager) {
        this.manager = manager;
    }

    PresenterStrategy() {
    }


    private ArrayList<StrategyData.Data> loadData(String s) {
        return get.getData(s);
    }

    @Override
    public void addMainFragment(StrategyMainFragment fragment) {
        this.mainFragment = fragment;
        transaction = manager.beginTransaction();
        transaction.add(R.id.strategy_fragment, mainFragment, "main")
                .commit();
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

}
