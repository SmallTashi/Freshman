package com.mredrock.cyxbs.freshman.essential;

import android.app.Dialog;

import com.mredrock.cyxbs.freshman.data.EssentialDataBean;

import java.util.ArrayList;

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

    }

    interface DataProvider {
        ArrayList<EssentialDataBean> get(int count);

    }
}