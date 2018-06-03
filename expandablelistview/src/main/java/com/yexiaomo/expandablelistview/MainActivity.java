package com.yexiaomo.expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.yexiaomo.expandablelistview.adapter.MyBaseExpandableListAdapter;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView mExpendList;
    private String[] groupStrings = {"西游记","水浒传","三国演义","红楼梦"};
    private String[][] childStrings = {
            {"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
            {"宋江", "林冲", "李逵", "鲁智深"},
            {"曹操", "刘备", "孙权", "诸葛亮", "周瑜"},
            {"贾宝玉", "林黛玉", "薛宝钗", "王熙凤"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        // 添加适配器
        mExpendList.setAdapter(new MyBaseExpandableListAdapter(groupStrings, childStrings));
    }

    private void initView() {
        mExpendList = (ExpandableListView) findViewById(R.id.expend_list);
    }
}
