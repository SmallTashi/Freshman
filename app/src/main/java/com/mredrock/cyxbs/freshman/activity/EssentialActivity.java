package com.mredrock.cyxbs.freshman.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mredrock.cyxbs.freshman.R;
import com.mredrock.cyxbs.freshman.essential.PresenterContractEssential;
import com.mredrock.cyxbs.freshman.essential.PresenterEssential;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EssentialActivity extends BaseActivity implements PresenterContractEssential.ViewShow, View.OnClickListener {
    public static final String TAG = "essential";
    public String inputString = null;
    public Dialog d;
    @BindView(R.id.freshman_essential_list)
    RecyclerView recycler;
    @BindView(R.id.freshman_essential_button_add)
    FloatingActionButton add;
    private boolean isEdit = false;
    private PresenterEssential presenterEssential = new PresenterEssential();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freshman_activity_essential);
        ButterKnife.bind(this);
        presenterEssential.setAdapter(recycler, this, this);

        add.setOnClickListener(this);
        edit.setOnClickListener(this);
        leftIcon.setOnClickListener(this);
        detail.setOnClickListener(this);
        showTip();

    }

    private void showTip() {
        d = new Dialog(this);
        d.setContentView(R.layout.freshman_essential_tips);
        d.getWindow().setGravity(Gravity.CENTER);
        d.show();
    }

    public void addToast(String s, boolean Short) {
        if (Short) {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void ShowDialog(Dialog dialog) {
        dialog.show();
    }

    @Override
    public void addToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.freshman_essential_button_add:
                add.setVisibility(View.INVISIBLE);
                show1();
                break;
            case R.id.freshman_essential_bar_return:
                finish();
                break;
            case R.id.freshman_essential_bar_edit:
                if (isEdit) {
                    presenterEssential.beSure(this);
                    edit.setText("编辑");
                    isEdit = false;
                } else {
                    edit.setText("删除");
                    presenterEssential.CompleteEdit();
                    isEdit = true;
                }
                break;
            case R.id.freshman_essential_bar_detail:
                d.show();
                break;
        }
    }


    private void show1() {
        final Dialog bottomDialog = new Dialog(this, R.style.dialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.freshman_essential_layout_add_item, null);
        bottomDialog.setContentView(contentView);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.show();
        final EditText input = (EditText) contentView.findViewById(R.id.essential_edit);
        Button finish = (Button) contentView.findViewById(R.id.essential_button_edit_add);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString = input.getText().toString();
                if (inputString.equals("")) {
                    addToast("请输入待办事项", true);
                } else {
                    presenterEssential.addItem(inputString);
                    bottomDialog.dismiss();
                }
            }
        });
        if (!bottomDialog.isShowing()) {
            add.setVisibility(View.VISIBLE);
        }
    }
}
