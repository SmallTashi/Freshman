package com.mredrock.cyxbs.freshman.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.data.StrategyData;
import com.mredrock.cyxbs.freshman.data.TrainMediaData;
import com.mredrock.cyxbs.freshman.data.TrainTipsData;
import com.mredrock.cyxbs.freshman.strategy.StrategyDetailFragment;
import com.mredrock.cyxbs.freshman.utils.DataTypeManager;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<?> data;
    private int mFlag;
    private List<TrainTipsData.DescribeBean> temp;
    private ArrayList<TrainTipsData.DescribeBean> tipsBeans;
    private Context context;
    private ArrayList<String> imageUrl;
    private ArrayList<String> url;

    public BaseAdapter(List<?> data, int flag, Context context) {
        this.mFlag = flag;
        this.context = context;
        this.data = data;
        if (mFlag == DataTypeManager.DataBean.TRAIN_MEDIA_IMAGE) {
            imageUrl = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                imageUrl.add(((TrainMediaData.PictureBean) data.get(i)).getUrl());
            }
        }
        if (mFlag == DataTypeManager.DataBean.TRAIN_TIPS) {
            tipsBeans = new ArrayList<>();
            temp = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                tipsBeans.add((TrainTipsData.DescribeBean) data.get(i));
            }
            tipsBeans.get(1).setProperty(tipsBeans.get(0).getContent());
            tipsBeans.get(3).setProperty(tipsBeans.get(2).getContent());
            temp.add(tipsBeans.get(1));
            temp.add(tipsBeans.get(3));
            tipsBeans = null;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mFlag;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case DataTypeManager.DataBean.TRAIN_TIPS:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.freshman_train_tips_item, parent, false);
                return new BaseViewHolderPool.TipsViewHold(v);
            case DataTypeManager.DataBean.TRAIN_MEDIA_VIDEO:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.freshman_train_media_video_item, parent, false);
                return new BaseViewHolderPool.MediaVideoViewHolder(v);
            case DataTypeManager.DataBean.TRAIN_MEDIA_IMAGE:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.freshman_train_media_image_item, parent, false);
                return new BaseViewHolderPool.MediaImageViewHolder(v);
            case DataTypeManager.DataBean.STRATEGY:
                Log.d(StrategyDetailFragment.Tag, "bindItem");
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.strategy_five_item, parent, false);
                return new BaseViewHolderPool.StrategyViewHolder(v);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case DataTypeManager.DataBean.TRAIN_TIPS:
                BaseViewHolderPool.TipsViewHold tips = (BaseViewHolderPool.TipsViewHold) holder;
                tips.tipsBigTitle.setText("军训纪律");
                tips.tipsContent.setText(temp.get(position).getContent());
                tips.tipTitle.setText(temp.get(position).getProperty());
                break;
            case DataTypeManager.DataBean.TRAIN_MEDIA_VIDEO:
                ArrayList<TrainMediaData.VideoBean> videoBeans = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    videoBeans.add((TrainMediaData.VideoBean) data.get(i));
                }
                BaseViewHolderPool.MediaVideoViewHolder videoImage = (BaseViewHolderPool.MediaVideoViewHolder) holder;
                videoImage.mediaName.setText(videoBeans.get(position).getName());
                Glide.with(context).load(videoBeans.get(position).getUrl()).into(videoImage.mediaImage);
                break;
            case DataTypeManager.DataBean.TRAIN_MEDIA_IMAGE:
                ArrayList<TrainMediaData.PictureBean> imageBeans = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    imageBeans.add((TrainMediaData.PictureBean) data.get(i));
                }
                BaseViewHolderPool.MediaImageViewHolder image = (BaseViewHolderPool.MediaImageViewHolder) holder;
                image.name.setText(imageBeans.get(position).getName());
//                image.image.setAdapter(new ImagePagerAdapter(context,imageUrl,image.image));
                break;
            case DataTypeManager.DataBean.STRATEGY:
                ArrayList<StrategyData.ArrayBean> beans = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    beans.add((StrategyData.ArrayBean) data.get(i));
                }
                BaseViewHolderPool.StrategyViewHolder strategy = (BaseViewHolderPool.StrategyViewHolder) holder;
                strategy.content.setText(beans.get(position).getContent());
                strategy.name.setText(beans.get(position).getName());
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (mFlag == DataTypeManager.DataBean.TRAIN_TIPS) {
            return data.size() / 2;
        }
        return data.size();
    }

    public void refreshItem(List<StrategyData.ArrayBean> list) {
        this.data = list;
        notifyItemRangeChanged(0, list.size());
    }
}
