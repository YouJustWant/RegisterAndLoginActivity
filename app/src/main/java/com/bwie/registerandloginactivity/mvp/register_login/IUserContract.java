package com.bwie.registerandloginactivity.mvp.register_login;

import com.bwie.registerandloginactivity.net.NetCallBack;

import java.util.Map;

/**
 * Author:杨帅
 * Date:
 * Description：
 */
public interface IUserContract {
    // View 层
    interface IUserView {
        void showResutl(String result);
    }

    // Model 层
    interface IUserModel {
        void doPost(String url,Map<String, String> params, NetCallBack callBack);
    }

    // Presenter 层
    interface IUserPresenter {
        //绑定视图
        void attach(IUserView view);

        //解绑
        void detach();

        //注册
        void doRegister(String url, Map<String, String> params);

        //登录
        void doLogin(String url, Map<String, String> params);
    }
}
