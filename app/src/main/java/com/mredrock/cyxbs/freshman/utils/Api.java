package com.mredrock.cyxbs.freshman.utils;

import com.mredrock.cyxbs.freshman.data.EssentialDataBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET(FreshmanConfig.URL_ESSENTIAL)
    Call<EssentialDataBean> getByIndex(@Query("index") String index);


}
