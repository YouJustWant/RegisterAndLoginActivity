package com.bwie.registerandloginactivity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
/**
 * Author:杨帅
 * Date:
 * Description：
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        initView();
        initData();
        bindEvent();
    }

    //绑定布局
    protected abstract int bindLayout();

    //初始化控件
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //绑定监听
    protected abstract void bindEvent();

    //找控件
    public <T extends View> T bindView(int id) {
        return findViewById(id);
    }
}
