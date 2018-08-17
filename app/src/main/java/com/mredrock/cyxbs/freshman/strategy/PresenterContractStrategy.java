package com.mredrock.cyxbs.freshman.strategy;


import com.mredrock.cyxbs.freshman.data.StrategyData;

import java.util.ArrayList;

public interface PresenterContractStrategy {

    interface Show {
        void changeList(String s);

    }


    interface ChangeFragment {
        void addMainFragment(StrategyMainFragment fragment);

        void into(String s);
    }

    interface get {
        ArrayList<StrategyData.Data> getData(String type);
    }


}
