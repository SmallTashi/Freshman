package com.mredrock.cyxbs.freshman.essential;

import com.mredrock.cyxbs.freshman.data.EssentialDataBean;

import java.util.ArrayList;

public class ModelEssential implements PresenterContractEssential.DataProvider {


    @Override
    public ArrayList<EssentialDataBean> get(int count) {

        if (count == 0) {
            ArrayList<EssentialDataBean> list = new ArrayList<>();
            //TODO 发起网络请求，并返回数据
            return list;
        }
        return null;
    }
}
