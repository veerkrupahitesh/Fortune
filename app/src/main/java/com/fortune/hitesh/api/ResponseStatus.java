package com.fortune.hitesh.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by VEER7 on 6/20/2017.
 */

public class ResponseStatus implements Serializable
{

    @SerializedName("is_error")
    @Expose
    private boolean isError;
    @SerializedName("error_code")
    @Expose
    private int errorNumber;
    @SerializedName("error")
    @Expose
    private String error;


    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}



