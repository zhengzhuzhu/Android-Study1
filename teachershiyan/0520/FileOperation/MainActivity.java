package com.app.cxh.fileoperation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button btnInWrite,btnInRead,btnOutWrite,btnOutRead;
    private EditText etInData,etOutData;
    private TextView tvInData,tvOutData;

    // 定义存储的文件名，用final修饰，不能更改
    private final String myInFileName = "my_in_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInWrite = (Button)findViewById(R.id.btnInWrite);
        btnInRead = (Button)findViewById(R.id.btnInRead);
        etInData = (EditText)findViewById(R.id.etInData);
        tvInData = (TextView)findViewById(R.id.tvInData);

        btnOutWrite = (Button)findViewById(R.id.btnOutWrite);
        btnOutRead = (Button)findViewById(R.id.btnOutRead);
        etOutData = (EditText)findViewById(R.id.etOutData);
        tvOutData = (TextView)findViewById(R.id.tvOutData);

        // 点击事件：内部文件——写
        btnInWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWrite(etInData.getText().toString());  //从文本框读数据，再写入
                etInData.setText("");
            }
        });
        // 点击事件：内部文件——读
        btnInRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInData.setText(myRead());
            }
        });
    }

    // 写入数据方法
    private void myWrite(String strWriteData){
        FileOutputStream fo = null;
        try {
            fo = openFileOutput(myInFileName,MODE_PRIVATE);
            fo.write(strWriteData.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fo != null){
                try {
                    fo.close();  // 关闭文件，这个重要
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // 读取数据方法
    private String myRead(){
        FileInputStream fi =null;
        try {
            fi = openFileInput(myInFileName);
            // 文件流是以字节流读取的，以1024为单位读
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len = fi.read(buff))>0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
