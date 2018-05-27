package com.yexiaomo.classdemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtStartMain2;
    private ViewPager mViewpager;
    private TextView mTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTvText = (TextView) findViewById(R.id.tv_text);
    }
}
