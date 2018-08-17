package com.mredrock.cyxbs.freshman.train;

import com.mredrock.cyxbs.freshman.data.TrainMediaData;
import com.mredrock.cyxbs.freshman.data.TrainTipsData;

import java.util.ArrayList;

public interface PresenterContractTrain {
    interface get {
        ArrayList<TrainTipsData.TipsBean> loadTips();

        ArrayList<TrainMediaData.PictureBean> loadPic();

        ArrayList<TrainMediaData.VideoBean> loadVideo();
    }

    interface loadData {
        ArrayList<TrainMediaData.VideoBean> loadVideo();

        ArrayList<TrainMediaData.PictureBean> loadImage();

        ArrayList<TrainTipsData.TipsBean> loadTips();
    }

    interface showTips {
        void addToast();
    }

    interface showMedia {

        void addToast();

    }


}
