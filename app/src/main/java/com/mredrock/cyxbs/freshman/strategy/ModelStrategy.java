package com.mredrock.cyxbs.freshman.strategy;

import com.mredrock.cyxbs.freshman.data.StrategyData;
import com.mredrock.cyxbs.freshman.utils.Api;
import com.mredrock.cyxbs.freshman.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelStrategy implements PresenterContractStrategy.get {
    private Api api = RetrofitManager.get();
    private PresenterContractStrategy.callback callback;
    private Map<String, String> map = new HashMap<>();

    ModelStrategy(PresenterContractStrategy.callback callback) {
        this.callback = callback;
        map.put("pagenum", "1");
        map.put("pagesize", "10");
    }


    @Override
    public void getData(String type) {
        map.put("index", type);
        Call<StrategyData> data = api.getStrategy(map);
        data.enqueue(new Callback<StrategyData>() {
            @Override
            public void onResponse(Call<StrategyData> call, Response<StrategyData> response) {

                callback.loadData(response.body().getArray());
            }

            @Override
            public void onFailure(Call<StrategyData> call, Throwable t) {
                callback.onFailed();
            }
        });

    }

}

