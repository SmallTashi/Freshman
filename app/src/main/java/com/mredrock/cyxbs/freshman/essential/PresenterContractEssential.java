package com.mredrock.cyxbs.freshman.essential;

import android.app.Dialog;

import com.mredrock.cyxbs.freshman.data.EssentialDataBean;

import java.util.List;

public interface PresenterContractEssential {

    interface ActionCallBack {
        int getCount();

        int Scroll();

        void ItemMove(int fromPosition);

        void reloadAfterDel();

        void addItem(String inputString);

        void changeModeTo(int i);
    }


    interface ViewShow {
        void ShowDialog(Dialog dialog);

        void addToast(String s);
    }

    interface DataProvider {
        void get();
    }

    interface callback {
        void loadData(List<EssentialDataBean.DescribeBean> data);

        void onFailed(String s);
    }
}