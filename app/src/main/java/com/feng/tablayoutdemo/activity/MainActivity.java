package com.feng.tablayoutdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.feng.tabdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mStyleOneButton;
    private Button mStyleTwoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mStyleOneButton = findViewById(R.id.btn_style_one);
        mStyleOneButton.setOnClickListener(this);

        mStyleTwoButton = findViewById(R.id.btn_style_two);
        mStyleTwoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_style_one:
//                startActivity(new Intent(MainActivity.this, StyleOneActivity.class));
                startActivity(new Intent(MainActivity.this, TestActivity.class));
                break;
            case R.id.btn_style_two:
                startActivity(new Intent(MainActivity.this, StyleTwoActivity.class));
                break;
            default:
                break;
        }
    }
}
