package com.yexiaomo.expandablelv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.yexiaomo.expandablelv.adapter.MyExpendableListAdapter;

public class MainActivity extends AppCompatActivity {

    private String[] groupStrings = {"西游记", "水浒传", "三国演义", "红楼梦"};
    private String[][] childStrings = {
            {"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
            {"宋江", "林冲", "李逵", "鲁智深"},
            {"曹操", "刘备", "孙权", "诸葛亮", "周瑜"},
            {"贾宝玉", "林黛玉", "薛宝钗", "王熙凤"}
    };
    private ExpandableListView mExpandLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mExpandLv.setAdapter(new MyExpendableListAdapter(groupStrings, childStrings));
    }

    private void initView() {
        mExpandLv = (ExpandableListView) findViewById(R.id.expend_lv);
    }
}
