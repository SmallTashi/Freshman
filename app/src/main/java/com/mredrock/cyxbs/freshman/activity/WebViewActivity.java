package com.mredrock.cyxbs.freshman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.mredrock.cyxbs.freshman.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        setBar();
        Intent i = getIntent();
        String url = i.getStringExtra("url");
        webView.loadUrl(url);
    }

    public void setBar() {
        leftIcon.setVisibility(View.VISIBLE);
        detail.setVisibility(View.INVISIBLE);
        edit.setVisibility(View.INVISIBLE);
        title.setVisibility(View.VISIBLE);
        title.setText("军训视频");
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
