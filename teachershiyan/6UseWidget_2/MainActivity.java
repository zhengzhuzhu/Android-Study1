package com.app.cxh.usewidget_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDisplay1,rvDisplay2,rvDisplay3,rvDisplay4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 数据列表
        List<String> listItem = new ArrayList<>();
        for(int i=1;i<=36;i++){listItem.add("item CXH "+i);}

        // 第一个RecyclerView（线性布局/默认）
        MyAdapter myAdapter1 = new MyAdapter(this,listItem);
        rvDisplay1 = (RecyclerView)findViewById(R.id.rvDisplay1);
        rvDisplay1.setLayoutManager(new LinearLayoutManager(this));
        rvDisplay1.setAdapter(myAdapter1);

        // 第二个RecyclerView （线性布局/横向）
        MyAdapter myAdapter2 = new MyAdapter(this,listItem);
        rvDisplay2 = (RecyclerView)findViewById(R.id.rvDisplay2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvDisplay2.setLayoutManager(linearLayoutManager);
        rvDisplay2.setAdapter(myAdapter2);

        // 第三个RecyclerView（列表布局）
        MyAdapter myAdapter3 = new MyAdapter(this,listItem);
        rvDisplay3 = (RecyclerView)findViewById(R.id.rvDisplay3);
        rvDisplay3.setLayoutManager(new GridLayoutManager(this,3));
        rvDisplay3.setAdapter(myAdapter3);

        //第四个RecyclerView（瀑布流）
        MyAdapter_pro myAdapter4 = new MyAdapter_pro(this);
        rvDisplay4 = (RecyclerView)findViewById(R.id.rvDisplay4);
        rvDisplay4.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        rvDisplay4.setAdapter(myAdapter4);
    }
}
