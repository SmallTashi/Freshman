package com.mredrock.cyxbs.freshman.train;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.activity.WebViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TrainMediaFragment extends Fragment implements PresenterContractTrain.showMedia {
    @BindView(R.id.train_image_text)
    TextView imageText;
    @BindView(R.id.train_image_pager)
    ViewPager imagePager;
    @BindView(R.id.train_video_text)
    TextView videoText;
    @BindView(R.id.train_video_pager)
    RecyclerView videoPager;
    Unbinder unbinder;
    private PresenterTrain p = new PresenterTrain(this);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freshman_train_fragment_media, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        p.setVideoAdapter(videoPager, getContext());

        p.setImageAdapter(imagePager, getContext(), this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void intent(String s) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("url", s);
        startActivity(intent);
    }

    @Override
    public void addToast() {

    }


}
