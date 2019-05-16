package com.bwie.registerandloginactivity.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bwie.registerandloginactivity.MyApplication;

import java.util.Map;

/**
 * Author:杨帅
 * Date:
 * Description：
 */
public class HttpUtils {
    //懒汉式
    private static HttpUtils httpUtils;

    private HttpUtils() {
    }

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    //判断网络连接状态方法
    public boolean isNetWork(Context context) {
        //获取连接管理者
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取网络状态信息
        NetworkInfo info = manager.getActiveNetworkInfo();
        //判断网络状态
        if (info != null) {
            return info.isConnected();
        }
        return false;
    }

    //请求网络数据方法（GET）
    public void doVolleyGet(String urlStr, final NetCallBack callBack) {
        StringRequest request = new StringRequest(Request.Method.GET, urlStr, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        });
        request.setTag("get");
        MyApplication.getQueue().add(request);
    }
    //请求网络数据方法（POST）
    public void doVolleyPost(String urlStr, final Map<String,String> params, final NetCallBack callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, urlStr, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        request.setTag("post");
        MyApplication.getQueue().add(request);
    }
    //取消tag
    public void cancelTag(String tag){
        MyApplication.getQueue().cancelAll(tag);
    }
}
