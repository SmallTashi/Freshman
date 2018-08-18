package com.mredrock.cyxbs.freshman.train;

import com.mredrock.cyxbs.freshman.data.TrainMediaData;
import com.mredrock.cyxbs.freshman.data.TrainTipsData;

import java.util.List;

public interface PresenterContractTrain {
    interface get {
        void loadTips();

        void loadPic();

        void loadVideo();
    }

    interface callback {
        void onFailed();

        void loadVideo(List<TrainMediaData.VideoBean> tips);

        void loadImage(List<TrainMediaData.PictureBean> images);

        void loadTips(List<TrainTipsData.DescribeBean> video);
    }

    interface ItemClickListener {
        void onItemClick(String s);
    }

    interface showTips {
        void addToast(String s);
    }

    interface showMedia {
        void intent(String s);

        void addToast();

    }


}
