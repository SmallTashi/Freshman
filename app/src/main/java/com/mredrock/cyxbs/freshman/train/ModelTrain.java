package com.mredrock.cyxbs.freshman.train;

import com.mredrock.cyxbs.freshman.data.TrainMediaData;
import com.mredrock.cyxbs.freshman.data.TrainTipsData;
import com.mredrock.cyxbs.freshman.utils.Api;
import com.mredrock.cyxbs.freshman.utils.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelTrain implements PresenterContractTrain.get {
    public static final int Video = 1;
    public static final int image = 2;
    private PresenterContractTrain.callback callback;
    private Api api = RetrofitManager.get();

    public ModelTrain(PresenterContractTrain.callback callback) {
        this.callback = callback;
    }

    private void getTips() {

        Call<TrainTipsData> tips = api.getTips("军训小贴士");
        tips.enqueue(new Callback<TrainTipsData>() {
            @Override
            public void onResponse(Call<TrainTipsData> call, Response<TrainTipsData> response) {
                callback.loadTips(response.body().getDescribe());
            }

            @Override
            public void onFailure(Call<TrainTipsData> call, Throwable t) {
                callback.onFailed();
            }
        });
    }

    void getMedia(int flag) {
        Call<TrainMediaData> bean = this.api.getTrainMedia();
        switch (flag) {

            case Video:

                bean.enqueue(new Callback<TrainMediaData>() {
                    @Override
                    public void onResponse(Call<TrainMediaData> call, Response<TrainMediaData> response) {
                        callback.loadVideo(response.body().getVideo());
                    }

                    @Override
                    public void onFailure(Call<TrainMediaData> call, Throwable t) {
                        callback.onFailed();
                    }
                });
                break;
            case image:
                bean.enqueue(new Callback<TrainMediaData>() {
                    @Override
                    public void onResponse(Call<TrainMediaData> call, Response<TrainMediaData> response) {
                        callback.loadImage(response.body().getPicture());
                    }

                    @Override
                    public void onFailure(Call<TrainMediaData> call, Throwable t) {
                        callback.onFailed();
                    }
                });
                break;
        }
    }

    @Override
    public void loadTips() {
        getTips();
    }

    @Override
    public void loadPic() {
        getMedia(image);
    }

    @Override
    public void loadVideo() {
        getMedia(Video);
    }
}
