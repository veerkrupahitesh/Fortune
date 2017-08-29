package com.fortune.hitesh.models;

import com.fortune.hitesh.api.RestClient;
import com.fortune.hitesh.helper.PrefHelper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by VEER7 on 6/20/2017.
 */

public class LoginUserModel implements Serializable {

    public static LoginUserModel getLoginUserModel() {

        return RestClient.getGsonInstance().fromJson(PrefHelper.getInstance().getString(PrefHelper.CLIENT_CREDENTIALS, ""), LoginUserModel.class);
//        return (LoginUserModel) stringToObject(PrefHelper.getInstance().getString(PrefHelper.CLIENT_CREDENTIALS, ""));
    }

    public static void setLoginCredentials(String loginCredentials) {

        PrefHelper.getInstance().setString(PrefHelper.CLIENT_CREDENTIALS, loginCredentials);
    }
}
