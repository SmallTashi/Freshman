package com.mredrock.cyxbs.freshman.strategy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.activity.StrategyMainActivity;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;
import com.mredrock.cyxbs.freshman.widget.JCardView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class StrategyMainFragment extends Fragment {
    @BindView(R.id.strategy_hall)
    JCardView strategyHall;
    @BindView(R.id.strategy_dormitory)
    JCardView strategyDormitory;
    @BindView(R.id.strategy_food)
    JCardView strategyFood;
    @BindView(R.id.strategy_scenic)
    JCardView strategyScenic;
    @BindView(R.id.strategy_surroundings)
    JCardView strategySurroundings;
    @BindView(R.id.strategy_data)
    JCardView strategyData;
    @BindView(R.id.strategy_bank)
    JCardView strategyBank;
    @BindView(R.id.strategy_bus)
    JCardView strategyBus;
    @BindView(R.id.strategy_express)
    JCardView strategyExpress;
    Unbinder unbinder;
    private PresenterStrategy presenterStrategy;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_strategy_fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.presenterStrategy = ((StrategyMainActivity) getActivity()).p;
//        strategyExpress.setOnClickListener(this);
//        strategyBus.setOnClickListener(this);
//        strategyBank.setOnClickListener(this);
//        strategyDormitory.setOnClickListener(this);
//        strategyData.setOnClickListener(this);
//        strategySurroundings.setOnClickListener(this);
//        strategyFood.setOnClickListener(this);
//        strategyScenic.setOnClickListener(this);
//        strategyHall.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.strategy_hall, R.id.strategy_dormitory, R.id.strategy_food, R.id.strategy_scenic, R.id.strategy_surroundings, R.id.strategy_data, R.id.strategy_bank, R.id.strategy_bus, R.id.strategy_express})
    public void onViewClicked(View view) {
        StrategyMainActivity activity = (StrategyMainActivity) getActivity();
        switch (view.getId()) {
            case R.id.strategy_hall:
                activity.setBar(DataTypeManager.STRATEGY.HALL);
                presenterStrategy.into(DataTypeManager.STRATEGY.HALL);
                break;
            case R.id.strategy_dormitory:
                activity.setBar(DataTypeManager.STRATEGY.DORMITORY);
                presenterStrategy.into(DataTypeManager.STRATEGY.DORMITORY);
                break;
            case R.id.strategy_food:
                activity.setBar(DataTypeManager.STRATEGY.FOOD);
                presenterStrategy.into(DataTypeManager.STRATEGY.FOOD);
                break;
            case R.id.strategy_scenic:
                activity.setBar(DataTypeManager.STRATEGY.SCENIC);
                presenterStrategy.into(DataTypeManager.STRATEGY.SCENIC);
                break;
            case R.id.strategy_surroundings:
                activity.setBar(DataTypeManager.STRATEGY.SURROUNDINGS);
                presenterStrategy.into(DataTypeManager.STRATEGY.SURROUNDINGS);
                break;
            case R.id.strategy_data:
                activity.setBar(DataTypeManager.STRATEGY.DATA);
                presenterStrategy.into(DataTypeManager.STRATEGY.DATA);
                break;
            case R.id.strategy_bank:
                activity.setBar(DataTypeManager.STRATEGY.BANK);
                presenterStrategy.into(DataTypeManager.STRATEGY.BANK);
                break;
            case R.id.strategy_bus:
                activity.setBar(DataTypeManager.STRATEGY.BUS);
                presenterStrategy.into(DataTypeManager.STRATEGY.BUS);
                break;
            case R.id.strategy_express:
                activity.setBar(DataTypeManager.STRATEGY.EXPRESS);
                presenterStrategy.into(DataTypeManager.STRATEGY.EXPRESS);
                break;
        }
    }


}
