package com.fortune.hitesh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fortune.hitesh.MyApplication;
import com.fortune.hitesh.R;
import com.fortune.hitesh.helper.PrefHelper;
import com.fortune.hitesh.utility.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Admin on 5/10/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.tv_poweredBy)
    TextView tvPoweredBy;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        tvPoweredBy.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
               /* if (!PrefHelper.getInstance().getBoolean(PrefHelper.FIRST_TIME_APP_OPEN, false)) {
                    Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
                    startActivity(i);
                    finish();
                } else {*/

//                int i = 1 / 0;
//                Debug.trace(String.valueOf(i));

                Utils.printFbKeyHash();
                PrefHelper.getInstance().setLong(PrefHelper.IMAGE_CACHE_FLAG, System.currentTimeMillis());

                if (PrefHelper.getInstance().getBoolean(PrefHelper.IS_LOGIN, false)) {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    //intent.putExtra(Constants.IS_FROM_SIGN_UP, false);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();

                } else {
                    Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }

            }
        };
        handler.postDelayed(runnable, 1000);
    }
}
