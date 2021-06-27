package com.app.cxh.lifecycle;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("LifeCycle:","----onCreate----");
        btnSt=(Button)findViewById(R.id.btnSt);
        btnSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"Show Toast!",Toast.LENGTH_LONG).show();
                AlertDialog.Builder msgBox=new AlertDialog.Builder(MainActivity.this);
                msgBox.setMessage("Hello");
                msgBox.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                msgBox.create().show();
            }
        });
    }
    protected void ab(){

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle:","----onStart----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle:","----onResume----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle:","----onPause----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle:","----onStop----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle:","----onRestart----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle:","----onDestroy----");
    }

}
