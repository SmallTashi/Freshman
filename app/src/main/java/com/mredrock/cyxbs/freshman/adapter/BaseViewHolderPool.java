package com.mredrock.cyxbs.freshman.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.R;

public class BaseViewHolderPool {


    public static class MediaVideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mediaName;
        public ImageView mediaImage;

        MediaVideoViewHolder(View itemView) {
            super(itemView);
            mediaName = (TextView) itemView.findViewById(R.id.train_video_text);
            mediaImage = (ImageView) itemView.findViewById(R.id.train_video_image);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.train_video_image:
                    //TODO 跳转视屏播放
            }
        }
    }

    public static class MediaImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public MediaImageViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public static class TipsViewHold extends RecyclerView.ViewHolder {
        public TextView tipsBigTitle;
        public TextView tipTitle;
        public TextView tipsContent;

        TipsViewHold(View itemView) {
            super(itemView);
            tipsBigTitle = (TextView) itemView.findViewById(R.id.train_big_title);
            tipTitle = (TextView) itemView.findViewById(R.id.train_title);
            tipsContent = (TextView) itemView.findViewById(R.id.train_content);
        }
    }

    public static class StrategyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView content;

        StrategyViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.strategy_name);
            content = (TextView) v.findViewById(R.id.strategy_content);

        }
    }
}
