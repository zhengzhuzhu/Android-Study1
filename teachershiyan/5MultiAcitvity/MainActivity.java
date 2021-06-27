package com.app.cxh.multiacitvity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnOne, btnTwo, btnThree, btnQuit;
    private TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = (Button)findViewById(R.id.btnOne);
        btnTwo = (Button)findViewById(R.id.btnTwo);
        btnThree = (Button)findViewById(R.id.btnThree);
        btnQuit = (Button)findViewById(R.id.btnQuit);
        tvDisplay = (TextView)findViewById(R.id.tvDisplay);

        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        btnOne.setOnClickListener(onClick);
        btnTwo.setOnClickListener(onClick);
        btnThree.setOnClickListener(onClick);
        btnQuit.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btnOne:
                    //Toast.makeText(MainActivity.this,"One", Toast.LENGTH_LONG);
                    tvDisplay.setText("one");
                    intent = new Intent(MainActivity.this, One.class);
                    intent.putExtra("msg", "main -> one");  // 数据单传
                    startActivity(intent);
                    break;
                case R.id.btnTwo:
                    //Toast.makeText(MainActivity.this,"Two", Toast.LENGTH_LONG);
                    tvDisplay.setText("Two");
                    intent = new Intent(MainActivity.this, Two.class);
                    Bundle bundle = new Bundle(); //批量多传
                    bundle.putString("name","CXH");
                    bundle.putInt("height",177);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case R.id.btnThree:
                    //Toast.makeText(MainActivity.this,"Three", Toast.LENGTH_LONG);
                    tvDisplay.setText("Three");
                    intent = new Intent(MainActivity.this, Three.class);
                    intent.putExtra("msg", "main -> Three");  // 数据单传
                    startActivityForResult(intent, 0);
                    break;
                case R.id.btnQuit:
                    //Toast.makeText(MainActivity.this,"Quit", Toast.LENGTH_LONG);
                    tvDisplay.setText("Quit");
                    finish();
                    break;
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:
                tvDisplay.setText(data.getStringExtra("backMsg"));
                break;
        }
    }
}
