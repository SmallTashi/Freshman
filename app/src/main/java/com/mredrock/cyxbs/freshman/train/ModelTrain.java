package com.mredrock.cyxbs.freshman.train;

import com.mredrock.cyxbs.freshman.data.TrainMediaData;
import com.mredrock.cyxbs.freshman.data.TrainTipsData;

import java.util.ArrayList;

public class ModelTrain implements PresenterContractTrain.get {
    @Override
    public ArrayList<TrainTipsData.TipsBean> loadTips() {
        ArrayList<TrainTipsData.TipsBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TrainTipsData.TipsBean a = new TrainTipsData.TipsBean();
            a.setName("军训贴士");
            a.setContent("1.军训期间请假遵守一事一请假的原则，无特 殊事由不得请假； " +
                    "2.学生在军训场上感到不适，可直接通过“打 报告的形式直接向…… " +
                    "3.军训期间请假遵守一事一请假的原则，无特 殊事由不得请假； " +
                    "4.学生在军训场上感到不适，可直接通过“打 报告的形式直接向…… " +
                    "5.军训期间请假遵守一事一请假的原则，无特 殊事由不得请假； " +
                    "6.学生在军训场上感到不适，可直接通过“打 报告的形式直接向……");
            data.add(a);
        }
        return data;
    }

    @Override
    public ArrayList<TrainMediaData.PictureBean> loadPic() {
        ArrayList<TrainMediaData.PictureBean> beans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TrainMediaData.PictureBean l = new TrainMediaData.PictureBean();
            l.setUrl("https://ww1.sinaimg.cn/large/0073sXn7ly1fubd7e0lb7g304e04rati");
            l.setName("gank.io");
        }
        return beans;
    }

    @Override
    public ArrayList<TrainMediaData.VideoBean> loadVideo() {
        ArrayList<TrainMediaData.VideoBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TrainMediaData.VideoBean d = new TrainMediaData.VideoBean();
            d.setName("123123123123321");
            data.add(d);
        }
        return data;
    }
}
