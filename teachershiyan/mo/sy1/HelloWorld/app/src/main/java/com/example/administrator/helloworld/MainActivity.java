package com.example.administrator.helloworld;

import android.app.AppOpsManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends ActionBarActivity {
    private TextView Text;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text=(TextView)findViewById(R.id.TextView);
        button=(Button)findViewById(R.id.button);
        // 注册默认的未捕捉异常处理类
        Thread.setDefaultUncaughtExceptionHandler(AppException.getAppExceptionHandler());
        AppManager.getAppManager().addActivity(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setText("您好");
                //Toast输出信息
                Toast.makeText(MainActivity.this, R.string.default_button, Toast.LENGTH_SHORT).show();
                btn(view);
            }
        });
    }
    public void btn(View view) {
        // 除零错误，程序会崩溃
        int c = 1/0;
    }

}
