package com.mredrock.cyxbs.freshman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.train.PresenterTrain;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrainingActivity extends BaseActivity {
    @BindView(R.id.train_tabbar)
    TabLayout tabBar;
    @BindView(R.id.train_tab_pager)
    ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freshman_activity_training);
        ButterKnife.bind(this);
        setBar();
        PresenterTrain presenterTrain = new PresenterTrain(pager, tabBar);
        presenterTrain.setUi(getSupportFragmentManager());
    }

    private void setBar() {
        leftIcon.setVisibility(View.VISIBLE);
        detail.setVisibility(View.GONE);
        edit.setVisibility(View.GONE);
        title.setVisibility(View.VISIBLE);
        title.setText("军训特辑");
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrainingActivity.this, TestActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
