package com.bwie.registerandloginactivity.mvp.register_login;

import com.bwie.registerandloginactivity.mvp.register_login.IUserContract;
import com.bwie.registerandloginactivity.net.HttpUtils;
import com.bwie.registerandloginactivity.net.NetCallBack;

import java.util.Map;

/**
 * Author:杨帅
 * Date:
 * Description：
 */
public class UserModelImpl implements IUserContract.IUserModel {

    private HttpUtils instance;

    public UserModelImpl() {
        instance = HttpUtils.getInstance();
    }

    @Override
    public void doPost(String url, Map<String, String> params, NetCallBack callBack) {
        instance.doVolleyPost(url,params,callBack);
    }
}
