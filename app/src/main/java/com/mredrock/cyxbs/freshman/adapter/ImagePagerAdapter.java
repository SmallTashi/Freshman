package com.mredrock.cyxbs.freshman.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mredrock.cyxbs.freshman.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ImagePagerAdapter extends PagerAdapter implements View.OnTouchListener, ViewPager.OnPageChangeListener {
    private boolean isAuto = true;
    private ArrayList<String> url;
    private Disposable subscribe;
    private int currentPage = 1;
    private ViewPager pager;
    private Context context;

    public ImagePagerAdapter(Context context, ArrayList<String> list, ViewPager pager) {
        this.url = list;
        this.pager = pager;
        this.context = context;
    }

    @Override
    public int getCount() {
        return url.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    private void start() {
        subscribe = io.reactivex.Observable.interval(2, 2, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        if (isAuto && url.size() > 0)
                            currentPage++;
                        pager.setCurrentItem(currentPage);
                    }
                });
    }

    private void stop() {
        if (!subscribe.isDisposed()) {
            subscribe.dispose();
        }

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.freshman_train_media_image_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.train_image);
        Glide.with(context).load(url.get(position)).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                stop();
                break;
            case MotionEvent.ACTION_UP:
                start();
                break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            // 闲置中
            case ViewPager.SCROLL_STATE_IDLE:
                // “偷梁换柱”
                if (pager.getCurrentItem() == 0) {
                    pager.setCurrentItem(url.size(), false);
                } else if (pager.getCurrentItem() == url.size() + 1) {
                    pager.setCurrentItem(1, false);
                }
                currentPage = pager.getCurrentItem();
                break;
        }
    }
}
