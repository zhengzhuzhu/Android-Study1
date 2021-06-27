package com.app.cxh.usefragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 声明Fragment
    private MyFragment_1 myFragment_1;
    private MyFragment_2 myFragment_2;
    private Button btnChange;
    private MyFragment_pro myFragment_pro;  // 传参Fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 实例化Fragment
        myFragment_1 = new MyFragment_1();
        myFragment_2 = new MyFragment_2();

        // 将Fragment添加到Activity中
        getFragmentManager().beginTransaction().add(R.id.flTitle,myFragment_1).commitAllowingStateLoss();

        btnChange = (Button)findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.flTitle,myFragment_2).commitAllowingStateLoss();
            }
        });

        // 传参Fragment
        myFragment_pro = MyFragment_pro.newInstance("我就来自主调程序的参数");
        getFragmentManager().beginTransaction().add(R.id.flText,myFragment_pro).commitAllowingStateLoss();
    }
    // 给Fragment调用,用于回传数据（定义一个方法）
    public void getFromFragment(String strText){
        TextView tvMain = (TextView)findViewById(R.id.tvMain);
        tvMain.setText(strText);
    }
}
