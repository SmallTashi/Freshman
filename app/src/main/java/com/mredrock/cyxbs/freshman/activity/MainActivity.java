package com.mredrock.cyxbs.freshman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mredrock.cyxbs.freshman.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.freshman_essential)
    Button essential;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freshman_activity_main);
        ButterKnife.bind(this);
        essential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EssentialActivity.class);
                startActivity(intent);
                finish();
            }
        });
        setBar();
    }

    void setBar() {
        leftIcon.setVisibility(View.INVISIBLE);
        title.setText("主页");
        detail.setVisibility(View.INVISIBLE);
        edit.setVisibility(View.INVISIBLE);
    }


}
