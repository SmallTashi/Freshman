package com.mredrock.cyxbs.freshman.essential;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mredrock.cyxbs.freshman.activity.EssentialActivity;
import com.mredrock.cyxbs.freshman.adapter.EssentialAdapter;
import com.mredrock.cyxbs.freshman.data.EssentialDataBean;

import java.util.ArrayList;

import static com.mredrock.cyxbs.freshman.activity.BaseActivity.NORMSL_MODE;

public class PresenterEssential {
    private PresenterContractEssential.ViewShow view;
    private PresenterContractEssential.ActionCallBack callBack;
    private ArrayList<EssentialDataBean> itemList;
    private int count = 0;
    private RecyclerView recycler;


    public void setRecycler(RecyclerView recycler, Context context, EssentialActivity activity) {
        this.recycler = recycler;
        this.view = activity;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
    }

    ArrayList<EssentialDataBean> initItem() {
        itemList = new ArrayList<>();
        //TODO 测试数据
        for (int i = 0; i < 15; i++) {
            EssentialDataBean dataBean = new EssentialDataBean("非必需Item" + String.valueOf(i), false, false);
            dataBean.setType(EssentialDataBean.CHILD_ITEM);
            dataBean.setExpand(true);
            dataBean.setProperty("非必须");
            if (i < 5) {
                dataBean.setProperty("必须");
                dataBean.setName("必须Item" + String.valueOf(i));
            }
            itemList.add(dataBean);
        }
        String index = "入学必备";
        return itemList;
    }

    public void addItem(String in) {
        callBack.addItem(in);
    }

    public void CompleteEdit() {
        callBack.changeModeTo(EssentialActivity.EDIT_MODE);
        callBack.reloadAfterDel();
    }


    public void loadData() {
        PresenterContractEssential.DataProvider requestData = new ModelEssential();
//        itemList = requestData.get(count);
        count = 1;
        EssentialAdapter adapter = new EssentialAdapter(initItem(), recycler);
        recycler.setAdapter(adapter);
        this.callBack = adapter;
//        callBack.notifyAll();
    }

    public void beSure(Context context) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.setMessage("是否删除这" + callBack.getCount() + "项")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        callBack.changeModeTo(NORMSL_MODE);
                    }
                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        callBack.changeModeTo(NORMSL_MODE);
                    }
                }).create();
        view.ShowDialog(dialog);
    }
}
