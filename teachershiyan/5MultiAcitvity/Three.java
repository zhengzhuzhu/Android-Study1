package com.app.cxh.multiacitvity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Three extends AppCompatActivity {
    private Button btnBack;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        setTitle("Three+Three");  // 通过代码设置界面的标题（方法一）

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //该方法不会生成新窗口，即回到原窗口
                Intent intent = new Intent();
                intent.putExtra("backMsg","I come back!");
                setResult(Activity.RESULT_OK,intent);  //回传
                //startActivity(intent);
                finish();  // 同时结束本窗口
            }
        });

        //接收Activity间数据传递，单传
        tv = (TextView)findViewById(R.id.tv);
        String msg = getIntent().getStringExtra("msg");
        tv.setText(msg);
    }
}
