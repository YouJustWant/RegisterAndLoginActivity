package com.bwie.registerandloginactivity.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bwie.registerandloginactivity.R;

public class MessageActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        textView = findViewById(R.id.tv_message);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        textView.setText(key);
    }
}
