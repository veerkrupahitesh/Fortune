package com.fortune.hitesh.api;


import com.fortune.hitesh.models.LoginUserModel;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ${hitesh} on 12/8/2016.
 */

public class ResponseManager {

    public static <T> Object parseResponse(String mResponse, RequestCode mRequestCode, Gson mGson) {

        Object object = null;

        try {

            JSONObject jsonObject = new JSONObject(mResponse);

            switch (mRequestCode) {



                case Login:
                    object = mGson.fromJson(jsonObject.getJSONObject("login").toString(), mRequestCode.getLocalClass());
                    LoginUserModel.setLoginCredentials(jsonObject.getJSONObject("login").toString());
                    //  PrefHelper.getInstance().setString(PrefHelper.CLIENT_CREDENTIALS, jsonObject.getJSONObject("Login").toString());
                    break;


                case ForgotPassword:

                    object = mGson.fromJson(jsonObject.getJSONObject("ForgotPassword").toString(), mRequestCode.getLocalClass());
                    break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }
}
