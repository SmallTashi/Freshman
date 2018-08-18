package com.mredrock.cyxbs.freshman.essential;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mredrock.cyxbs.freshman.activity.EssentialActivity;
import com.mredrock.cyxbs.freshman.adapter.EssentialAdapter;
import com.mredrock.cyxbs.freshman.data.EssentialDataBean;

import java.util.List;

import static com.mredrock.cyxbs.freshman.activity.BaseActivity.NORMSL_MODE;

public class PresenterEssential implements PresenterContractEssential.callback {
    private PresenterContractEssential.ViewShow view;
    private PresenterContractEssential.ActionCallBack adapterAction;
    private Context context;
    private RecyclerView recycler;
    private PresenterContractEssential.DataProvider requestData = new ModelEssential(this);


    public void setAdapter(RecyclerView recycler, Context context, EssentialActivity activity) {
        this.recycler = recycler;
        this.view = activity;
        this.context = context;
        requestData.get();
    }



    public void addItem(String in) {
        adapterAction.addItem(in);
    }

    public void CompleteEdit() {
        adapterAction.changeModeTo(EssentialActivity.EDIT_MODE);
        adapterAction.reloadAfterDel();
    }

    public void beSure(Context context) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.setMessage("是否删除这" + adapterAction.getCount() + "项")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        adapterAction.changeModeTo(NORMSL_MODE);
                    }
                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapterAction.changeModeTo(NORMSL_MODE);
                    }
                }).create();
        view.ShowDialog(dialog);
    }

    @Override
    public void loadData(List<EssentialDataBean.DescribeBean> data) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        EssentialAdapter adapter = new EssentialAdapter(data);
        recycler.setAdapter(adapter);
        this.adapterAction = adapter;
    }

    @Override
    public void onFailed(String s) {
        view.addToast(s);
    }
}
