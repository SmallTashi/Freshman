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

    private Context context;

    public BaseAdapter(List<?> data, int flag, Context context) {
        this.mFlag = flag;
        this.context = context;
        this.data = data;
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
                ArrayList<TrainTipsData.TipsBean> tipsBeans = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    tipsBeans.add((TrainTipsData.TipsBean) data.get(i));
                }
                BaseViewHolderPool.TipsViewHold tips = (BaseViewHolderPool.TipsViewHold) holder;
                tips.tipsContent.setText(tipsBeans.get(position).getContent());
                tips.tipTitle.setText(tipsBeans.get(position).getName());
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
            case DataTypeManager.DataBean.STRATEGY:
                ArrayList<StrategyData.Data> beans = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    beans.add((StrategyData.Data) data.get(i));
                }
                BaseViewHolderPool.StrategyViewHolder strategy = (BaseViewHolderPool.StrategyViewHolder) holder;
                strategy.content.setText(beans.get(position).getContent());
                strategy.name.setText(beans.get(position).getName());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void refreshItem(ArrayList<StrategyData.Data> list) {
        this.data = list;
        notifyItemRangeChanged(0, list.size());
    }
}
