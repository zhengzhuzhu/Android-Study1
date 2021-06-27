package com.app.cxh.listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView t1;
    private Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.T1);

        b1=(Button)findViewById(R.id.B1);

        b2=(Button)findViewById(R.id.B2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("B222222222");
            }
        });

        b3=(Button)findViewById(R.id.B3);
        b4=(Button)findViewById(R.id.B4);

        setListeners();
    }

    public void b1_onClick(View v){
        t1.setText("B11111111");
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        b3.setOnClickListener(onClick);
        b4.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        public void onClick(View v){
            switch(v.getId()){
                case R.id.B3:
                    t1.setText("B333333");
                    break;
                case R.id.B4:
                    t1.setText("B444444");
                    break;
            }
        }
    }
}
