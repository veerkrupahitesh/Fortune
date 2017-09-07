package com.fortune.hitesh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fortune.hitesh.MyApplication;
import com.fortune.hitesh.R;
import com.fortune.hitesh.api.DataObserver;
import com.fortune.hitesh.api.RequestCode;
import com.fortune.hitesh.listener.OnBackPressedEvent;
import com.fortune.hitesh.listener.OnClickEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ABC on 9/7/2017.
 */

public class ActivitySelectOtherTitle extends AppCompatActivity implements DataObserver, OnClickEvent,OnBackPressedEvent {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_headerTitle)
    TextView tvHeaderTitle;
    @BindView(R.id.reltiveHeader)
    RelativeLayout reltiveHeader;
    @BindView(R.id.appbarLayout)
    AppBarLayout appbarLayout;
    @BindView(R.id.tv_select_store)
    TextView tvSelectStore;
    @BindView(R.id.img_down)
    ImageView imgDown;
    @BindView(R.id.lin_select_title)
    LinearLayout linSelectTitle;
    @BindView(R.id.tv_any_other)
    TextView tvAnyOther;
    @BindView(R.id.img_down1)
    ImageView imgDown1;
    @BindView(R.id.lin_select_any_other)
    LinearLayout linSelectAnyOther;
    @BindView(R.id.txv_description)
    EditText txvDescription;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.img_f)
    ImageView imgF;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_other_title);
        ButterKnife.bind(this);

        txvDescription.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);

    }

    @Override
    public void onSuccess(RequestCode mRequestCode, Object mObject) {

    }

    @Override
    public void onFailure(RequestCode mRequestCode, String mError) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            /*case R.id.lin_select_any_other:

                Intent intent = new Intent(ActivitySelectOtherTitle.this, HomeActivity.class);
                startActivity(intent);
                break;*/

            case R.id.img_back:
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {

        finish();
    }
}
