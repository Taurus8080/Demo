package com.yexiaomo.viewpagertest;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yexiaomo.viewpagertest.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TextView mTvText;
    private String[] texts = {"蒲公英","海星","开始使用"};
    private int[] imgsId = {R.drawable.a1, R.drawable.a2, R.drawable.a3};
    private List<ImageView> imgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();
        initData();

        mViewPager.setAdapter(new MyPagerAdapter(imgList));

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                            startActivity(new Intent(MainActivity.this, Main2Activity.class));
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
        for (int i=0; i<imgsId.length; i++){
            ImageView iv = new ImageView(this);
            iv.setImageResource(imgsId[i]);
            imgList.add(iv);
        }

    }

    private void initView() {
        mViewPager = findViewById(R.id.view_pager);
        mTvText = findViewById(R.id.tv_text);
        mTvText.setText(texts[0]);
    }
}
