package com.yexiaomo.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yexiaomo.viewpagerdemo.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewpager;
    private TextView mTvText;
    private String[] texts = {"蒲公英","海星","开始使用"};
    private int[] imgs = {R.drawable.a1, R.drawable.a2, R.drawable.a3};
    private List<ImageView> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();
        initData();
        // 适配器
        mViewpager.setAdapter(new MyViewPagerAdapter(mList));
        // 监听viewpager滑动
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTvText.setText(texts[position]);
                if (position == texts.length - 1){
                    // 最后一页
                    mTvText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(MainActivity.this,Main2Activity.class));
                            finish();
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        ImageView iv = null;
        for (int i=0; i<imgs.length; i++) {
            iv = new ImageView(this);
            iv.setImageResource(imgs[i]);
            mList.add(iv);
        }
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTvText = (TextView) findViewById(R.id.tv_text);
        mTvText.setText(texts[0]); // 初始化文字
    }
}
