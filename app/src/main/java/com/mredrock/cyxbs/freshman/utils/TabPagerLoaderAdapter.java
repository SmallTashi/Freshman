package com.mredrock.cyxbs.freshman.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabPagerLoaderAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private int flag;
    private ArrayList<String> title = null;

    TabPagerLoaderAdapter(FragmentManager fm, List<Fragment> fragments, int flag, ArrayList<String> title) {
        super(fm);
        if (this.title != null) {
            this.title.clear();
        }

        this.fragments = fragments;
        this.flag = flag;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return title.get(position);
    }

    @Override
    public int getCount() {
        return title.size();
    }
}
