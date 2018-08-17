package com.mredrock.cyxbs.freshman.strategy;

import com.mredrock.cyxbs.freshman.data.StrategyData;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;

import java.util.ArrayList;

public class ModelStrategy implements PresenterContractStrategy.get {

    @Override
    public ArrayList<StrategyData.Data> getData(String type) {
        switch (type) {
            case DataTypeManager.STRATEGY.HALL:
                //TODO 网络请求加载数据
                break;
            case DataTypeManager.STRATEGY.DORMITORY:
                break;
            case DataTypeManager.STRATEGY.FOOD:
                break;
            case DataTypeManager.STRATEGY.SCENIC:
                break;
            case DataTypeManager.STRATEGY.SURROUNDINGS:
                break;
            case DataTypeManager.STRATEGY.DATA:
                break;
            case DataTypeManager.STRATEGY.BANK:
                break;
            case DataTypeManager.STRATEGY.BUS:
                break;
            case DataTypeManager.STRATEGY.EXPRESS:
                break;

        }
        return null;
    }
}
