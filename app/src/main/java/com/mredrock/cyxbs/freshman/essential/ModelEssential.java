package com.mredrock.cyxbs.freshman.essential;

import com.mredrock.cyxbs.freshman.data.EssentialDataBean;
import com.mredrock.cyxbs.freshman.utils.Api;
import com.mredrock.cyxbs.freshman.utils.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelEssential implements PresenterContractEssential.DataProvider {
    private PresenterContractEssential.callback callback;
    private Api api = RetrofitManager.get();

    public ModelEssential(PresenterContractEssential.callback callback) {
        this.callback = callback;
    }
    @Override
    public void get() {
        Call<EssentialDataBean> tips = api.getEssential("入学必备");
        tips.enqueue(new Callback<EssentialDataBean>() {
            @Override
            public void onResponse(Call<EssentialDataBean> call, Response<EssentialDataBean> response) {
                callback.loadData(response.body().getDescribe());
            }

            @Override
            public void onFailure(Call<EssentialDataBean> call, Throwable t) {
                callback.onFailed("网络请求失败");
            }
        });
    }
}
