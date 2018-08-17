package com.mredrock.cyxbs.freshman.utils;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class TabPagerLoader {

    private FragmentManager manager;
    private ArrayList<Fragment> fragments;
    private int flag;

    public TabPagerLoader(FragmentManager manager, ArrayList<Fragment> fragments, int flag) {
        this.flag = flag;
        this.manager = manager;
        this.fragments = fragments;
    }

    public void setUi(ViewPager pager, TabLayout tabBar) {
        ArrayList<String> name = null;
        switch (flag) {
            case DataTypeManager.Ui.TRAIN:
                tabBar.addTab(tabBar.newTab());
                tabBar.addTab(tabBar.newTab());
                name = new ArrayList<>();
                name.add("军训风采");
                name.add("小贴士");
                TabPagerLoaderAdapter train = new TabPagerLoaderAdapter(manager, fragments, DataTypeManager.Ui.TRAIN, name);
                pager.setAdapter(train);
                tabBar.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager));
                pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabBar));
                tabBar.setupWithViewPager(pager);
                break;
            case DataTypeManager.Ui.STRATEGY_DATA:
                for (int i = 0; i < 4; i++) {
                    tabBar.addTab(tabBar.newTab());
                }
                name = new ArrayList<>();
                name.add("男女比例");
                name.add("最难科目");
                TabPagerLoaderAdapter data = new TabPagerLoaderAdapter(manager, fragments, DataTypeManager.Ui.STRATEGY_DATA, name);
                pager.setAdapter(data);
                tabBar.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager));
                tabBar.setupWithViewPager(pager);
                break;
        }

    }


}
