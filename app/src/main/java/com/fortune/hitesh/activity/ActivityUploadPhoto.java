package com.fortune.hitesh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fortune.hitesh.MyApplication;
import com.fortune.hitesh.R;
import com.fortune.hitesh.api.DataObserver;
import com.fortune.hitesh.api.RequestCode;
import com.fortune.hitesh.listener.OnBackPressedEvent;
import com.fortune.hitesh.listener.OnClickEvent;
import com.fortune.hitesh.utility.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ABC on 9/6/2017.
 */

public class ActivityUploadPhoto extends AppCompatActivity implements DataObserver, OnClickEvent, OnBackPressedEvent {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_headerTitle)
    TextView tvHeaderTitle;
    @BindView(R.id.reltiveHeader)
    RelativeLayout reltiveHeader;
    @BindView(R.id.appbarLayout)
    AppBarLayout appbarLayout;
    @BindView(R.id.img_take_photo)
    ImageView imgTakePhoto;
    @BindView(R.id.txv_main_image)
    TextView txvMainImage;
    @BindView(R.id.btn_take_photo)
    Button btnTakePhoto;
    @BindView(R.id.circular_ProgressBar)
    ProgressBar circularProgressBar;
    @BindView(R.id.txv_photo_name)
    TextView txvPhotoName;
    @BindView(R.id.txv_photo_size)
    TextView txvPhotoSize;
    @BindView(R.id.linProgress)
    LinearLayout linProgress;
    @BindView(R.id.img_f)
    ImageView imgF;
    @BindView(R.id.lin_main_image)
    LinearLayout linMainImage;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);
        ButterKnife.bind(this);

        txvMainImage.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        btnTakePhoto.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        txvPhotoName.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        txvPhotoSize.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);

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

            case R.id.btn_take_photo:

                Intent intent = new Intent(ActivityUploadPhoto.this, ActivityOtherPhoto.class);
                  //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear the stack of activities
                startActivity(intent);
                break;

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
