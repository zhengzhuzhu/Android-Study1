package com.app.cxh.layoutdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.app.cxh.layoutdesign.R.id.btnLinear;

public class MainActivity extends AppCompatActivity {
    private Button btnLinear, btnRelative, btnLLogin, btnRLogin, btnQuit;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinear = (Button)findViewById(R.id.btnLinear);
        btnRelative = (Button)findViewById(R.id.btnRelative);
        btnLLogin = (Button)findViewById(R.id.btnLLogin);
        btnRLogin = (Button)findViewById(R.id.btnRLogin);
        btnQuit = (Button)findViewById(R.id.btnQuit);
        tv = (TextView)findViewById(R.id.tv);

        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        btnLinear.setOnClickListener(onClick);
        btnRelative.setOnClickListener(onClick);
        btnLLogin.setOnClickListener(onClick);
        btnRLogin.setOnClickListener(onClick);
        btnQuit.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btnLinear:
                    intent = new Intent(MainActivity.this, LinearLayout.class);
                    startActivity(intent);
                    break;
                case R.id.btnRelative:
                    intent = new Intent(MainActivity.this, RelativeLayout.class);
                    startActivity(intent);
                    break;
                case R.id.btnLLogin:
                    intent = new Intent(MainActivity.this, LinearLogin.class);
                    startActivity(intent);
                    break;
                case R.id.btnRLogin:
                    intent = new Intent(MainActivity.this, RelativeLogin.class);
                    startActivity(intent);
                    break;
                case R.id.btnQuit:
                    finish();
                    break;
            }
        }
    }

}
