package com.mredrock.cyxbs.freshman.train;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mredrock.cyxbs.freshman.adapter.BaseAdapter;
import com.mredrock.cyxbs.freshman.data.TrainMediaData;
import com.mredrock.cyxbs.freshman.data.TrainTipsData;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;
import com.mredrock.cyxbs.freshman.utils.TabPagerLoader;

import java.util.ArrayList;
import java.util.List;

public class PresenterTrain implements PresenterContractTrain.callback, PresenterContractTrain.ItemClickListener {
    private PresenterContractTrain.get get = new ModelTrain(this);
    private PresenterContractTrain.showTips show;
    private PresenterContractTrain.showMedia media;
    private ViewPager pager;
    private ViewPager ImagePager;
    private TabLayout tabBar;
    private RecyclerView TipsRecyclerView;
    private RecyclerView VideoRecyclerView;
    private Context ImageContext;
    private Context context;
    private Context VideoContext;

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
        this.TipsRecyclerView = recycler;
        this.context = context;
        get.loadTips();
    }

    void setImageAdapter(ViewPager pager, Context context, TrainMediaFragment mediaFragment) {
        this.media = mediaFragment;
        this.ImagePager = pager;
        this.ImageContext = context;
        get.loadPic();
    }

    void setVideoAdapter(RecyclerView recyclerView, Context context) {
        this.VideoContext = context;
        this.VideoRecyclerView = recyclerView;
        get.loadVideo();
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
    public void onFailed() {
        show.addToast("数据加载失败");
    }

    @Override
    public void loadVideo(List<TrainMediaData.VideoBean> videoBeans) {
        LinearLayoutManager manager = new LinearLayoutManager(VideoContext);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        VideoRecyclerView.setLayoutManager(manager);
        BaseAdapter adapter = new BaseAdapter(videoBeans, DataTypeManager.DataBean.TRAIN_MEDIA_VIDEO, VideoContext);
        VideoRecyclerView.setAdapter(adapter);
    }

    @Override
    public void loadImage(List<TrainMediaData.PictureBean> images) {
        ArrayList<String> url = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            url.add(images.get(i).getUrl());
        }
//        ImagePagerAdapter pagerAdapter = new ImagePagerAdapter(ImageContext, url, ImagePager);
//        ImagePager.setAdapter(pagerAdapter);
//        ImagePager.addOnPageChangeListener(pagerAdapter);
    }

    @Override
    public void loadTips(List<TrainTipsData.DescribeBean> tipsBeans) {
        BaseAdapter adapter = new BaseAdapter(tipsBeans, DataTypeManager.DataBean.TRAIN_TIPS, context);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        TipsRecyclerView.setLayoutManager(manager);
        TipsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(String s) {
        media.intent(s);
    }
}
