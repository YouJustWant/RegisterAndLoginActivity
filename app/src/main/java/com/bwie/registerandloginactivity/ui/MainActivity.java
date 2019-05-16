package com.bwie.registerandloginactivity.ui;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.registerandloginactivity.R;
import com.bwie.registerandloginactivity.api.UserApi;
import com.bwie.registerandloginactivity.base.BaseActivity;
import com.bwie.registerandloginactivity.mvp.register_login.UserPresenter;
import com.bwie.registerandloginactivity.mvp.register_login.IUserContract;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements IUserContract.IUserView {

    private EditText et_phone;
    private EditText et_pwd;
    private CheckBox remember;
    private IUserContract.IUserPresenter presenter;
    private Intent intent;

    //绑定布局
    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    //找控件
    @Override
    protected void initView() {
        et_phone = bindView(R.id.et_phone);
        et_pwd = bindView(R.id.et_pwd);
        remember = bindView(R.id.rem);
    }

    //设置数据
    @Override
    protected void initData() {
        //获取IUserPresenter对象
        presenter = new UserPresenter();
        presenter.attach(this);

    }

    //绑定监听
    @Override
    protected void bindEvent() {

    }

    //点击注册
    public void register(View view) {
        String phone = et_phone.getText().toString();
        String pwd = et_pwd.getText().toString();
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("pwd", pwd);
        presenter.doRegister(UserApi.BASE_URL + UserApi.REGISTER_URL, params);
    }

    //点击登录
    public void login(View view) {
        String phone = et_phone.getText().toString();
        String pwd = et_pwd.getText().toString();
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("pwd", pwd);
        presenter.doLogin(UserApi.BASE_URL + UserApi.LOGIN_URL, params);
    }

    @Override
    public void showResutl(String result) {
        //Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        try {
            JSONObject object = new JSONObject(result);
            String message = object.getString("message");
            String status = object.getString("status");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            if(status.equals("0000")){
                intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("key",result);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
