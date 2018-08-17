package com.mredrock.cyxbs.freshman.utils;

import com.mredrock.cyxbs.freshman.data.EssentialDataBean;
import com.mredrock.cyxbs.freshman.data.StrategyData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET(FreshmanConfig.URL_ESSENTIAL)
    Call<EssentialDataBean> getByIndex(@Query("index") String index);

    @GET(FreshmanConfig.URL_STRATEGY)
    Call<StrategyData> getStrategyData(@Path("index") String index, @Path("pagenum") String page, @Path("pagesize") String size);


}
