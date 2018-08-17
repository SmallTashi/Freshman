package com.mredrock.cyxbs.freshman.train;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mredrock.cyxbs.freshman.adapter.BaseAdapter;
import com.mredrock.cyxbs.freshman.adapter.ImagePagerAdapter;
import com.mredrock.cyxbs.freshman.data.TrainMediaData;
import com.mredrock.cyxbs.freshman.data.TrainTipsData;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;
import com.mredrock.cyxbs.freshman.utils.TabPagerLoader;

import java.util.ArrayList;

public class PresenterTrain implements PresenterContractTrain.loadData {

    private static PresenterContractTrain.get get = new ModelTrain();
    private PresenterContractTrain.showTips show;
    private PresenterContractTrain.showMedia media;
    private ViewPager pager;
    private TabLayout tabBar;

    PresenterTrain(TrainTipsFragment tips) {
        this.show = tips;
    }


    public PresenterTrain(ViewPager pager, TabLayout tab) {
        this.pager = pager;
        this.tabBar = tab;
    }

    PresenterTrain(TrainMediaFragment video) {
        this.media = video;
    }

    void setTipAdapter(RecyclerView recycler, Context context, TrainTipsFragment tipsFragment) {
        this.show = tipsFragment;
        BaseAdapter adapter = new BaseAdapter(loadTips(), DataTypeManager.DataBean.TRAIN_TIPS, context);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
    }

    void setImageAdapter(ViewPager pager, Context context, TrainMediaFragment mediaFragment) {
        this.media = mediaFragment;
        ArrayList<String> url = new ArrayList<>();
        for (TrainMediaData.PictureBean bean :
                loadImage()) {
            url.add(bean.getUrl());
        }
        ImagePagerAdapter pagerAdapter = new ImagePagerAdapter(context, url, pager);
        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(pagerAdapter);
    }

    void setVideoAdapter(RecyclerView recyclerView, Context context) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        BaseAdapter adapter = new BaseAdapter(loadVideo(), DataTypeManager.DataBean.TRAIN_MEDIA_VIDEO, context);
        recyclerView.setAdapter(adapter);
    }

    public void setUi(FragmentManager manager) {
        TrainMediaFragment mediaFragment = new TrainMediaFragment();
        TrainTipsFragment tipsFragment = new TrainTipsFragment();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(mediaFragment);
        fragments.add(tipsFragment);
        TabPagerLoader loader = new TabPagerLoader(manager, fragments, DataTypeManager.Ui.TRAIN);
        loader.setUi(pager, tabBar);
    }

    @Override
    public ArrayList<TrainMediaData.VideoBean> loadVideo() {
        return get.loadVideo();
    }

    @Override
    public ArrayList<TrainMediaData.PictureBean> loadImage() {

        return get.loadPic();
    }

    @Override
    public ArrayList<TrainTipsData.TipsBean> loadTips() {
        get.loadVideo();
        return get.loadTips();
    }
}
