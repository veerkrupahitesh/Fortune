package com.fortune.hitesh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.fortune.hitesh.MyApplication;
import com.fortune.hitesh.R;
import com.fortune.hitesh.api.ApiList;
import com.fortune.hitesh.api.DataObserver;
import com.fortune.hitesh.api.RequestCode;
import com.fortune.hitesh.api.RestClient;
import com.fortune.hitesh.helper.PrefHelper;
import com.fortune.hitesh.helper.ToastHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hitesh on 29-08-2017.
 */

public class SignInActivity extends AppCompatActivity implements DataObserver {

    @BindView(R.id.edt_userName)
    AppCompatEditText edtUserName;
    @BindView(R.id.input_layout_userName)
    TextInputLayout inputLayoutUserName;
    @BindView(R.id.edt_password)
    AppCompatEditText edtPassword;
    @BindView(R.id.input_layout_password)
    TextInputLayout inputLayoutPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_forgetPassword)
    TextView tvForgetPassword;
    @BindView(R.id.lin_forgotPassword)
    LinearLayout linForgotPassword;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    private String userName;
    private String password;
    private Map<String, String> params;
//private JSONObject params;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);


        edtUserName.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        edtPassword.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
        btnLogin.setTypeface(MyApplication.getInstance().ARIAL_ROUNDED_MT_BOLD);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login:

                if (validateLoginForm()) {
                    params = new HashMap<>();
                   // params = new JSONObject();
                    try {
                        params.put("user_login", userName);
                        params.put("user_pass", password);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    RestClient.getInstance().post(this, Request.Method.POST, params,
                            ApiList.LOGIN, true, RequestCode.Login, this);
                }

                break;

        }
    }

    private boolean validateLoginForm() {

        userName = edtUserName.getText().toString().trim();
        password = edtPassword.getText().toString().trim();

        if (userName.isEmpty()) {
            edtUserName.requestFocus();
            edtUserName.setError(getString(R.string.enter_username));
            return false;
        } else if (password.isEmpty()) {

            edtPassword.requestFocus();
            edtPassword.setError(getString(R.string.enter_password));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onSuccess(RequestCode mRequestCode, Object mObject) {
        switch (mRequestCode) {
            case Login:
                PrefHelper.getInstance().setBoolean(PrefHelper.IS_LOGIN, true);
                Intent intent = new Intent(SignInActivity.this, ActivityUploadPhoto.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear the stack of activities
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                // ToastHelper.getInstance().showMessage("success");
                break;

        }
    }

    @Override
    public void onFailure(RequestCode mRequestCode, String mError) {
        ToastHelper.getInstance().showMessage(mError);
    }
}
