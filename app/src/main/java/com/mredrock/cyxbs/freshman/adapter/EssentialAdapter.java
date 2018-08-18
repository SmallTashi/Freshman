package com.mredrock.cyxbs.freshman.adapter;

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

import java.util.List;

import static com.mredrock.cyxbs.freshman.activity.EssentialActivity.TAG;

public class EssentialAdapter extends RecyclerView.Adapter<EssentialAdapter.EditViewHolder> implements PresenterContractEssential.ActionCallBack {

    private static final int EDIT_MODE = 1;
    private static final int NORMAL_MODE = 2;
    private boolean mShouldScroll;

    private int mToPosition;
    private int Flag = 0;
    private int count = 0;
    private int get = 0;

    private List<EssentialDataBean.DescribeBean> itemList;

    public EssentialAdapter(List<EssentialDataBean.DescribeBean> item) {
        this.itemList = item;
        Log.d(TAG, "initAdapter");
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
        if (itemList.get(position).isGet()) {
            holder.textView.getResources().getColor(R.color.essential_del_text);
        } else {
            holder.textView.getResources().getColor(R.color.freshman_essential_intro_color_text);
        }
        if (itemList.get(position).isCustom()) {
            holder.button.setVisibility(View.INVISIBLE);
        }
        if (Flag == EDIT_MODE) {
            holder.image.setVisibility(View.VISIBLE);
            holder.image.setImageResource(R.mipmap.freshman_edit_del_blue_frame);
            if (itemList.get(position).isProperty()) {
                holder.image.setVisibility(View.INVISIBLE);
            }
            if (itemList.get(position).isSelect()) {
                holder.image.setImageResource(R.mipmap.freshman_edit_del_sel_blue_farm);
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
                    if (itemList.get(position).isExpand()) {
                        //TODO
                    }
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
        EssentialDataBean.DescribeBean s = itemList.get(fromPosition);
        if (itemList.get(fromPosition).isGet()) {
            s.setGet(true);
            notifyItemMoved(fromPosition, 0);
            itemList.remove(fromPosition);
            itemList.add(0, s);
            get++;

            notifyItemRangeChanged(0, itemList.size());
        } else {
            itemList.remove(fromPosition);
            itemList.add(s);
            notifyItemRemoved(fromPosition);
            get--;
            notifyItemRangeChanged(get + 1, itemList.size() - get);
            notifyDataSetChanged();
        }

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
        EssentialDataBean.DescribeBean dataBean = new EssentialDataBean.DescribeBean();
        dataBean.setName(inputString);
        dataBean.setCustom(true);
        dataBean.setId(itemList.size() + 1);
        itemList.add(dataBean);
        notifyItemInserted(itemList.size());
        notifyItemRangeChanged(get, itemList.size());
    }


    @Override
    public void changeModeTo(int i) {
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
            textView = (TextView) itemView.findViewById(R.id.essential_titile);
            button = (ImageButton) itemView.findViewById(R.id.essential_fold);
            image = (ImageView) itemView.findViewById(R.id.essential_image);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


    }
}