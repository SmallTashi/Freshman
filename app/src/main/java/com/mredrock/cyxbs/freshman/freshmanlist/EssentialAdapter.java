package com.mredrock.cyxbs.freshman.freshmanlist;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.data.EssentialDataBean;
import com.mredrock.cyxbs.freshman.essential.PresenterContractEssential;

import java.util.ArrayList;

import static com.mredrock.cyxbs.freshman.activity.EssentialActivity.TAG;

public class EssentialAdapter extends RecyclerView.Adapter<EssentialAdapter.EditViewHolder> implements PresenterContractEssential.ActionCallBack {

    private static final int EDIT_MODE = 1;
    private static final int NORMAL_MODE = 2;
    private boolean mShouldScroll;

    private int mToPosition;
    private int Flag = 0;
    private int count = 0;
    private int get = 0;
    private RecyclerView recyclerView;
    private Context context;

    private ArrayList<EssentialDataBean> itemList;

    public EssentialAdapter(ArrayList<EssentialDataBean> item, RecyclerView recyclerView, Context context) {
        this.itemList = item;
        Log.d(TAG, "initAdapter");
        this.recyclerView = recyclerView;
        setRecyclerScrollListener(recyclerView);

        this.context = context;
    }


    @Override
    public EditViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        Log.d(TAG, "createViewHolder");
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.freshman_essential_list_item, parent, false);
        return new EditViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EditViewHolder holder, final int position) {
        holder.textView.setText(itemList.get(position).getName());
        holder.textView.setPaintFlags(holder.textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        if (itemList.get(position).isGet()) {
            holder.textView.getResources().getColor(R.color.essential_del_text);
            holder.textView.setPaintFlags(holder.textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.textView.getResources().getColor(R.color.freshman_essential_intro_color_text);
            holder.textView.setPaintFlags(holder.textView.getPaintFlags() & (Paint.STRIKE_THRU_TEXT_FLAG));
        }
        if (itemList.get(position).isCustom()) {
            holder.button.setVisibility(View.INVISIBLE);
        }
        if (Flag == EDIT_MODE) {
            if (itemList.get(position).isProprity()) {
                holder.image.setVisibility(View.INVISIBLE);
            } else {
                holder.image.setVisibility(View.VISIBLE);
            }
            if (itemList.get(position).isSelect()) {
                holder.image.setImageResource(R.mipmap.freshman_edit_del_sel_blue_farm);
            } else {
                holder.image.setImageResource(R.mipmap.freshman_edit_del_blue_frame);
            }
            holder.image.setTag(position);
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int) v.getTag();
                    //item 由选中设置为未选中
                    if (itemList.get(pos).isSelect()) {
                        holder.image.setImageResource(R.mipmap.freshman_edit_del_blue_frame);
                        itemList.get(pos).setSelect(false);
                        count--;
                    }
                    //item 由未选中设置为选中
                    else {
                        holder.image.setImageResource(R.mipmap.freshman_edit_del_sel_blue_farm);
                        itemList.get(pos).setSelect(true);
                        count++;
                    }
                }
            });
        } else {
            holder.image.setVisibility(View.VISIBLE);
            if (itemList.get(position).isGet()) {
                holder.textView.getResources().getColor(R.color.essential_del_text);
                holder.textView.setPaintFlags(holder.textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                holder.image.setImageResource(R.drawable.freshman_nesy_blue_frame_sel);
            } else {
                holder.image.setImageResource(R.drawable.freshman_nesy_blue_frame);
            }
            holder.image.setTag(position);
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int) v.getTag();
                    if (itemList.get(pos).isGet()) {
                        holder.textView.getResources().getColor(R.color.freshman_essential_intro_color_text);
                        holder.textView.setPaintFlags(holder.textView.getPaintFlags() & (Paint.STRIKE_THRU_TEXT_FLAG));
                        holder.image.setImageResource(R.drawable.freshman_nesy_blue_frame);
                        itemList.get(pos).setGet(false);
                        ItemMove(pos);
                    } else {
                        holder.image.setImageResource(R.drawable.freshman_nesy_blue_frame_sel);
                        itemList.get(pos).setGet(true);
                        ItemMove(pos);
                    }

                }
            });
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int Scroll() {
        return get;
    }

    @Override
    public void ItemMove(int fromPosition) {
        EssentialDataBean s = itemList.get(fromPosition);
        if (itemList.get(fromPosition).isGet()) {
            s.setGet(true);
            notifyItemMoved(fromPosition, 0);
            itemList.remove(fromPosition);
            itemList.add(0, s);
            get++;
            notifyItemRangeChanged(get + 1, itemList.size() - get);

        } else {

            itemList.remove(fromPosition);
            itemList.add(s);
            notifyItemMoved(fromPosition, itemList.size());
            get--;
            notifyItemRangeChanged(itemList.size(), 1);


        }

    }

    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));

        if (position < firstItem) {
            // 如果跳转位置在第一个可见位置之前，就smoothScrollToPosition可以直接跳转
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 跳转位置在第一个可见项之后，最后一个可见项之前
            // smoothScrollToPosition根本不会动，此时调用smoothScrollBy来滑动到指定位置
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 如果要跳转的位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }

    }

    private void setRecyclerScrollListener(final RecyclerView mRecyclerView) {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mShouldScroll) {
                    mShouldScroll = false;
                    smoothMoveToPosition(mRecyclerView, mToPosition);
                }
            }
        });
    }

    @Override
    public void reloadAfterDel() {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).isSelect()) {
                notifyItemRemoved(i);
                itemList.remove(i);
                i--;
            }
        }
        count = 0;
        notifyItemRangeChanged(0, itemList.size());
    }

    @Override
    public void addItem(String inputString) {
        EssentialDataBean dataBean = new EssentialDataBean();
        dataBean.setName(inputString);
        dataBean.setCustom(true);
        itemList.add(dataBean);
        notifyItemInserted(itemList.size());
        notifyItemRangeChanged(get, itemList.size());
    }

    @Override
    public void addItem(EssentialDataBean d) {
        itemList.add(d);
        notifyItemInserted(itemList.size());
        notifyDataSetChanged();
    }

    @Override
    public void changeMode(int i) {
        if (EDIT_MODE == i) {
            this.Flag = EDIT_MODE;
            notifyItemRangeChanged(0, itemList.size());
        } else {
            this.Flag = NORMAL_MODE;
            if (count != 0) {
                reloadAfterDel();
            } else {
                notifyItemRangeChanged(0, itemList.size());
            }
        }
    }


    static class EditViewHolder extends RecyclerView.ViewHolder {

        private ImageButton button;
        private TextView textView;
        private ImageView image;

        EditViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.essential_radio_box_text);
            button = (ImageButton) itemView.findViewById(R.id.essential_radio_box_fold);
            image = (ImageView) itemView.findViewById(R.id.essential_image);
        }
    }
}
