package com.fortune.hitesh.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fortune.hitesh.R;
import com.fortune.hitesh.api.DataObserver;
import com.fortune.hitesh.api.RequestCode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ABC on 9/6/2017.
 */

public class ActivityUploadPhoto extends AppCompatActivity implements DataObserver {

    @BindView(R.id.img_menu)
    ImageView imgMenu;
    @BindView(R.id.tv_headerTitle)
    TextView tvHeaderTitle;
    @BindView(R.id.reltiveHeader)
    RelativeLayout reltiveHeader;
    @BindView(R.id.lin_main_image)
    LinearLayout linMainImage;
//    @BindView(R.id.circularProgressBar)
//    ProgressBar circularProgressBar;
//    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.img_f)
    ImageView imgF;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);
        ButterKnife.bind(this);


    }


    @Override
    public void onSuccess(RequestCode mRequestCode, Object mObject) {

    }

    @Override
    public void onFailure(RequestCode mRequestCode, String mError) {

    }
}