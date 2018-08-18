package com.mredrock.cyxbs.freshman.strategy;


import com.mredrock.cyxbs.freshman.data.StrategyData;

import java.util.List;

public interface PresenterContractStrategy {


    interface Show {
        void addToast(String s);

    }


    interface ChangeFragment {
        void addMainFragment(StrategyMainFragment fragment);

        List<StrategyData.ArrayBean> getList(String s);

        void into(String s);

    }

    interface callback {
        void loadData(List<StrategyData.ArrayBean> data);

        void onFailed();
    }

    interface get {
        void getData(String type);
    }


}
