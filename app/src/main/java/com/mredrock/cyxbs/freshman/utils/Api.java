package com.mredrock.cyxbs.freshman.utils;

import com.mredrock.cyxbs.freshman.data.EssentialDataBean;
import com.mredrock.cyxbs.freshman.data.StrategyData;
import com.mredrock.cyxbs.freshman.data.TrainMediaData;
import com.mredrock.cyxbs.freshman.data.TrainTipsData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Api {

    String URL_ESSENTIAL_TIPS = "data/get/describe";

    String URL_TRAIN_MEDIA = "data/get/junxun";

    String URL_STRATEGY = "data/get/byindex";

    String BASE_URL = "http://47.106.33.112:8080/welcome2018/";

    @GET(URL_ESSENTIAL_TIPS)
    Call<TrainTipsData> getTips(@Query("index") String index);

    @GET(URL_ESSENTIAL_TIPS)
    Call<EssentialDataBean> getEssential(@Query("index") String index);

    @GET(URL_STRATEGY)
    Call<StrategyData> getStrategy(@QueryMap Map<String, String> options);

    @GET(URL_TRAIN_MEDIA)
    Call<TrainMediaData> getTrainMedia();

}
