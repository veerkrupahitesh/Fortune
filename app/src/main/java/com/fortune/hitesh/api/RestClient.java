package com.fortune.hitesh.api;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.fortune.hitesh.MyApplication;
import com.fortune.hitesh.R;
import com.fortune.hitesh.customdialog.CustomDialog;
import com.fortune.hitesh.utility.Debug;
import com.fortune.hitesh.utility.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${hitesh} on 12/6/2016.
 */
public class RestClient {

    private static RestClient ourInstance = new RestClient();

    private RestClient() {
    }

    public static RestClient getInstance() {
        return ourInstance;
    }

    public static Gson getGsonInstance() {

        return new GsonBuilder().setPrettyPrinting().create();
    }

    private static String getAbsoluteUrl(String url) {
        return ServerConfig.SERVER_LIVE_URL + url;
    }

    public void post(Context mContext, int mRequestMethod, /*final Map<String, String> mapParams,*/
                     JSONObject mPostParams, String url, boolean isDialogRequired, final RequestCode mRequestCode,
                     final DataObserver dataObserver) {

        try {
            if (Utils.isInternetAvailable()) {


                if (isDialogRequired) {
                    CustomDialog.getInstance().showProgress(mContext, "", false);
                }

                String postUrl = getAbsoluteUrl(url);

                Debug.trace("postUrl", postUrl);


                JsonRequest mPostRequest = new JsonRequest(mRequestMethod, postUrl, mPostParams.toString(),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                CustomDialog.getInstance().dismiss();

                                verifyResponse(response.toString(), mRequestCode, dataObserver);
                                //checkResponse(response, dataObserver, mRequestCode);
                                //  Object object = ResponseManager.parseResponse(response.toString(), mRequestCode, getGsonInstance());
                                //  dataObserver.onSuccess(mRequestCode, object);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        CustomDialog.getInstance().dismiss();

                        String message = null;
                        if (volleyError instanceof NetworkError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof ServerError) {
                            message = "The server could not be found. Please try again after some time!!";
                        } else if (volleyError instanceof AuthFailureError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof ParseError) {
                            message = "Parsing error! Please try again after some time!!";
                        } else if (volleyError instanceof TimeoutError) {
                            message = "Internet Connection is too slow! Please check your internet connection.";
                        }

                        dataObserver.onFailure(mRequestCode, message);

                    }
                }) {
                    @Override
                    protected Response parseNetworkResponse(NetworkResponse networkResponse) {

                        try {
                            String jsonString = new String(networkResponse.data,
                                    HttpHeaderParser
                                            .parseCharset(networkResponse.headers));
                            return Response.success(new JSONArray(jsonString),
                                    HttpHeaderParser
                                            .parseCacheHeaders(networkResponse));
                        } catch (UnsupportedEncodingException e) {
                            return Response.error(new ParseError(e));
                        } catch (JSONException je) {
                            return Response.error(new ParseError(je));
                        }
                        // return null;
                    }
                };

                MyApplication.getInstance().addToRequestQueue(mPostRequest, mContext.getClass().getSimpleName());

            } else {

                CustomDialog.getInstance().showAlert(mContext, mContext.getString(R.string.str_no_internet_connection_available), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void verifyResponse(String response, RequestCode mRequestCode, DataObserver dataObserver) {

        String formatedResponse = response.substring(3);
        ResponseStatus responseStatus = getGsonInstance().fromJson(formatedResponse, ResponseStatus.class);

        if (responseStatus.isIsError()) {
            dataObserver.onFailure(mRequestCode, responseStatus.getError());
        } else {
            Object object = ResponseManager.parseResponse(formatedResponse, mRequestCode, getGsonInstance());
            dataObserver.onSuccess(mRequestCode, object);
        }
    }



    public void post(Context mContext, int mRequestMethod, final Map<String, String> mapParams, /*JSONObject mPostParams,*/ String url, boolean isDialogRequired, final RequestCode mRequestCode, final DataObserver dataObserver) {

        try {
            if (Utils.isInternetAvailable()) {

                if (isDialogRequired) {
                    CustomDialog.getInstance().showProgress(mContext, "", false);
                }

                String postUrl = getAbsoluteUrl(url);

                Debug.trace("postUrl", postUrl);

                StringRequest mPostRequest = new StringRequest(mRequestMethod, postUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        CustomDialog.getInstance().dismiss();

                        try {
                            verifyResponse(response, mRequestCode, dataObserver);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //Object object = ResponseManager.parseResponse(response, mRequestCode, getGsonInstance());

                        //dataObserver.onSuccess(mRequestCode, object);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        CustomDialog.getInstance().dismiss();
                        String message = null;
                        if (volleyError instanceof NetworkError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof ServerError) {
                            message = "The server could not be found. Please try again after some time!!";
                        } else if (volleyError instanceof AuthFailureError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof ParseError) {
                            message = "Parsing error! Please try again after some time!!";
                        } else if (volleyError instanceof TimeoutError) {
                            message = "Connection TimeOut! Please check your internet connection.";
                        }
                        dataObserver.onFailure(mRequestCode, message);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        mapParams.put("Content-Type", "application/x-www-form-urlencoded");
                        return mapParams;
                    }
                   /* @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {

                        Map<String, String> headers = new HashMap<>();
                        headers.put("Content-Type", "application/x-www-form-urlencoded");

                        return headers;
                    }
*/
                };

                MyApplication.getInstance().addToRequestQueue(mPostRequest, mContext.getClass().getSimpleName());

            } else {

                CustomDialog.getInstance().showAlert(mContext, mContext.getString(R.string.str_no_internet_connection_available), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
