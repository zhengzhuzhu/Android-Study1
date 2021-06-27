package com.app.cxh.mytoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = (TextView)findViewById(R.id.tvTitle);

        getSupportActionBar().hide();  // 隐然默认的标是栏
        Toolbar toolbar = (Toolbar)findViewById(R.id.tbToolbar);
        toolbar.inflateMenu(R.menu.my_menu_option);  // 显示菜单

        // 设置菜单项监听
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.muOpt1:
                        tvTitle.setText("选中：菜单项一");
                        break;
                    case R.id.muOpt2:
                        tvTitle.setText("选中：菜单项二");
                        break;
                    case R.id.muOpt3:
                        tvTitle.setText("选中：菜单项三");
                        break;
                }
                return false;
            }
        });


    }
}
