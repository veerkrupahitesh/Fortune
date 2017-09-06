package com.fortune.hitesh.activity;

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

import com.fortune.hitesh.MyApplication;
import com.fortune.hitesh.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hitesh on 29-08-2017.
 */

public class SignInActivity extends AppCompatActivity {

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

    private String password;
    private String email;

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


        }
    }

    private boolean validateLoginForm() {

        email = edtUserName.getText().toString().trim();
        password = edtPassword.getText().toString().trim();

        if (email.isEmpty()) {
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
}
