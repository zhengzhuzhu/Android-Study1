package com.ble.cxh.myapplication;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView)findViewById(R.id.T1);
        i1=(ImageView)findViewById(R.id.I1);
    }

    public void myB1Click(View v){
        String aStr;
        aStr = t1.getText().toString();
        //t1.setText(aStr+"abc");

        Resources res=getResources();
        String[] myClassName =res.getStringArray(R.array.class_name);
        t1.setText(myClassName[1]);

        Log.e("Error","abc");

        Toast.makeText(this,"It is OK!", Toast.LENGTH_LONG).show();

        i1.setImageResource(R.drawable.abc);
    }
}
