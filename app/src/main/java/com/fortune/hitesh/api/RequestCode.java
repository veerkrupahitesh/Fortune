package com.fortune.hitesh.api;


import com.fortune.hitesh.models.CityModel;
import com.fortune.hitesh.models.CountryModel;
import com.fortune.hitesh.models.LoginUserModel;
import com.fortune.hitesh.models.StateModel;

/**
 * Created by ${hitesh} on 12/7/2016.
 */

public enum RequestCode {


    Login(LoginUserModel.class),

    ForgotPassword(LoginUserModel.class);


    Class mLocalClass;

    RequestCode(Class mLocalClass) {

        this.mLocalClass = mLocalClass;
    }

    public Class getLocalClass() {
        return mLocalClass;
    }

    public void setLocalClass(Class mLocalClass) {
        this.mLocalClass = mLocalClass;
    }
}
