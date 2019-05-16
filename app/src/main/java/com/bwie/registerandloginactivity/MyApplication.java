package com.bwie.registerandloginactivity;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Author:杨帅
 * Date:
 * Description：
 */
public class MyApplication extends Application {

    private static RequestQueue queue;
    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getQueue(){
        return queue;
    }
}
