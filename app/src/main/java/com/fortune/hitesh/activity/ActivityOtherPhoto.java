package com.fortune.hitesh.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ABC on 9/7/2017.
 */

public class ActivityOtherPhoto extends AppCompatActivity implements DataObserver {


    @BindView(R.id.img_menu)
    ImageView imgMenu;
    @BindView(R.id.tv_headerTitle)
    TextView tvHeaderTitle;
    @BindView(R.id.reltiveHeader)
    RelativeLayout reltiveHeader;
    @BindView(R.id.appbarLayout)
    AppBarLayout appbarLayout;
    @BindView(R.id.img_take_photo)
    ImageView imgTakePhoto;
    @BindView(R.id.img_take_photo1)
    ImageView imgTakePhoto1;
    @BindView(R.id.linUlodedImage)
    LinearLayout linUlodedImage;
    @BindView(R.id.txv_main_image)
    TextView txvMainImage;
    @BindView(R.id.btn_take_photo)
    Button btnTakePhoto;
    @BindView(R.id.circular_ProgressBar)
    ProgressBar circularProgressBar;
    @BindView(R.id.txv_Photo_name)
    TextView txvPhotoName;
    @BindView(R.id.txv_photo_size)
    TextView txvPhotoSize;
    @BindView(R.id.img_true)
    ImageView imgTrue;
    @BindView(R.id.linProgress)
    LinearLayout linProgress;
    @BindView(R.id.circular_ProgressBar1)
    ProgressBar circularProgressBar1;
    @BindView(R.id.txv_photo_name1)
    TextView txvPhotoName1;
    @BindView(R.id.txv_hoto_size1)
    TextView txvHotoSize1;
    @BindView(R.id.img_true1)
    ImageView imgTrue1;
    @BindView(R.id.linProgress1)
    LinearLayout linProgress1;
    @BindView(R.id.img_f)
    ImageView imgF;
    @BindView(R.id.lin_main_image)
    LinearLayout linMainImage;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_photo);
        ButterKnife.bind(this);

        txvMainImage.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        btnTakePhoto.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        txvPhotoName.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        txvPhotoSize.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        txvPhotoName1.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        txvHotoSize1.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
    }

    @Override
    public void onSuccess(RequestCode mRequestCode, Object mObject) {

    }

    @Override
    public void onFailure(RequestCode mRequestCode, String mError) {

    }
}
