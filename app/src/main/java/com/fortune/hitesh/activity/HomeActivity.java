package com.fortune.hitesh.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fortune.hitesh.MyApplication;
import com.fortune.hitesh.R;
import com.fortune.hitesh.listener.OnBackPressedEvent;
import com.fortune.hitesh.listener.OnClickEvent;
import com.fortune.hitesh.utility.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hitesh on 29-08-2017.
 */

public class HomeActivity extends AppCompatActivity implements OnClickEvent,OnBackPressedEvent {


    @BindView(R.id.img_back)
    ImageView imgMenu;
    @BindView(R.id.tv_headerTitle)
    TextView tvHeaderTitle;
    @BindView(R.id.reltiveHeader)
    RelativeLayout reltiveHeader;
    @BindView(R.id.tv_select_store)
    TextView tvSelectStore;
    @BindView(R.id.img_down)
    ImageView imgDown;
    @BindView(R.id.lin_select_store)
    LinearLayout linSelectStore;
    @BindView(R.id.img_f)
    ImageView imgF;
    private Dialog mDialog;

    private ListView listView;
    private String names[] = {
            "HTML",
            "CSS",
            "Java Script",
            "Wordpress"
    };


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        /*AdpStoreList customList = new AdpStoreList(this);

        listView = (ListView) findViewById(R.id.lv_select_store);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"You Clicked "+names[i],Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.lin_select_store:

                /*Intent intent = new Intent(HomeActivity.this, ActivityUploadPhoto.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear the stack of activities
                startActivity(intent);*/
                showAddBreed(this,false);
                break;
        }
    }


    @Override
    public void onBackPressed() {
        finish();
    }
    public void showAddBreed(Context mContext, boolean mIsCancelable) {

        mDialog = new Dialog(mContext, R.style.dialogStyle);
        //@SuppressLint("InflateParams")
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_dialog_select_store, null, false);
        mDialog.setContentView(view);
        Utils.setupOutSideTouchHideKeyboard(view);
         /* Set Dialog width match parent */
        mDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        // mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialog.setCancelable(mIsCancelable);

        final Button submit = (Button) mDialog.findViewById(R.id.btn_cancel);
        submit.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        //appointmentRejectModel.setRejectionRemarks(edtOtherReason.getText().toString().trim());
        //submit.setTag(appointmentRejectModel);
        if (mDialog != null) {
            if (!isDialogShowing()) {
                mDialog.show();
            }
        }
    }
    public boolean isDialogShowing() {

        return mDialog != null && mDialog.isShowing();
    }
    public void dismiss() {
        try {
            if (mDialog != null) {
                if (isDialogShowing()) {
                    mDialog.dismiss();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
