package com.bwie.registerandloginactivity.mvp.register_login;

import com.bwie.registerandloginactivity.mvp.register_login.IUserContract;
import com.bwie.registerandloginactivity.mvp.register_login.UserModelImpl;
import com.bwie.registerandloginactivity.net.NetCallBack;

import java.util.Map;

/**
 * Author:杨帅
 * Date:
 * Description：
 */
public class UserPresenter implements IUserContract.IUserPresenter {
    private IUserContract.IUserView view;
    private IUserContract.IUserModel model;

    @Override
    public void attach(IUserContract.IUserView view) {
        this.view = view;
        model = new UserModelImpl();
    }

    @Override
    public void detach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
        System.gc();
    }

    @Override
    public void doRegister(String url, Map<String, String> params) {
        model.doPost(url, params, new NetCallBack() {
            @Override
            public void onSuccess(String data) {
                view.showResutl(data);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Override
    public void doLogin(String url, Map<String, String> params) {
        model.doPost(url, params, new NetCallBack() {
            @Override
            public void onSuccess(String data) {
                view.showResutl(data);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
