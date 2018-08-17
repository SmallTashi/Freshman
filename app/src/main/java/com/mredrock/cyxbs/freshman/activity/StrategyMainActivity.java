package com.mredrock.cyxbs.freshman.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.strategy.PresenterStrategy;
import com.mredrock.cyxbs.freshman.strategy.StrategyMainFragment;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StrategyMainActivity extends FragmentActivity {
    public PresenterStrategy p = new PresenterStrategy(getSupportFragmentManager());
    @BindView(R.id.freshman_essential_bar_return)
    ImageView barRetern;
    @BindView(R.id.freshman_essential_bar_title)
    TextView barTitle;
    @BindView(R.id.freshman_essential_bar_detail)
    ImageView barDetail;
    @BindView(R.id.freshman_essential_bar_edit)
    TextView barEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_main);
        ButterKnife.bind(this);
        setBar(DataTypeManager.STRATEGY.TITLE);
        p.addMainFragment(new StrategyMainFragment());
        barRetern.setVisibility(View.VISIBLE);
        barDetail.setVisibility(View.GONE);
        barEdit.setVisibility(View.GONE);
        barTitle.setVisibility(View.VISIBLE);
    }

    public void setBar(String title) {
        barRetern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        barTitle.setText(title);
    }

}
