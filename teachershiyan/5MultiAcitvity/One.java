package com.app.cxh.multiacitvity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class One extends AppCompatActivity {
    private Button btnBack;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //该方法将生成另一个新的主调窗口，不是回原主调窗口
                Intent intent = new Intent(One.this, MainActivity.class);
                startActivity(intent);
                finish();  // 同时结束本窗口
            }
        });

        //接收Activity间数据传递，单传
        tv = (TextView)findViewById(R.id.tv);
        String msg = getIntent().getStringExtra("msg");
        tv.setText(msg);

    }
}
