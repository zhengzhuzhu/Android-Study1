package com.app.cxh.usesqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnCreate,btnInsert,btnDel,btnModify,btnQuery,btnClose;
    private TextView tvDisplay;
    private EditText etInputName;
    private MySqliteHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = (Button)findViewById(R.id.btnCreate);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnDel = (Button)findViewById(R.id.btnDel);
        btnModify = (Button)findViewById(R.id.btnModify);
        btnQuery = (Button)findViewById(R.id.btnQuery);
        btnClose = (Button)findViewById(R.id.btnClose);
        tvDisplay = (TextView)findViewById(R.id.tvDisplay);
        etInputName = (EditText)findViewById(R.id.etInputName);

        btnCreate.setOnClickListener(new View.OnClickListener() {  // 创建或打开数据库
            @Override
            public void onClick(View v) {
                // 完整情况下应添加SQLiteException异常捕获
                helper = new MySqliteHelper(MainActivity.this,"mySqlite.db",null,1);
                db = helper.getWritableDatabase();  // 获得SQLiteDatabase数据库对象
                tvDisplay.setText("数据库打开完毕");
            }
        });

        btnQuery.setOnClickListener(new View.OnClickListener() {  // 查询
            @Override
            public void onClick(View v) {
                // 方法一：基于SQL语句
                String strQurey = "%" + etInputName.getText().toString() + "%";  // 加入通配符，模糊查询
                Cursor cursor = db.rawQuery("select * from login where name like ?", new String[]{strQurey});
                //Cursor cursor = db.rawQuery("select * from login ",null);  // 全部查询

                // 方法二：封装方法
                // 不如不用

                String strInfo="";
                while (cursor.moveToNext()){
                    String strName = cursor.getString(cursor.getColumnIndex("name"));
                    String strPwd = cursor.getString(cursor.getColumnIndex("pwd"));
                    strInfo += strName + "\t";
                    strInfo += strPwd + "\n";
                }
                tvDisplay.setText(strInfo);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {  // 插入(新增)
            @Override
            public void onClick(View v) {
                String strName = etInputName.getText().toString();
                if (strName == null || strName.isEmpty()){  // 姓名不能为空
                    tvDisplay.setText("请先输入姓名");
                    return;
                }
                String strPwd = "123456";

                // 方法一：基于SQL语句
                db.execSQL("insert into login(name, pwd) values(?, ?)", new Object[]{strName, strPwd});
                // 方法二：封装方法
                //ContentValues values = new ContentValues();
                //values.put("name", strName);
                //values.put("pwd", strPwd);
                //long rowid = db.insert("login", null, values); //返回新添记录的行号

                etInputName.setText("");  // 清空
                tvDisplay.setText(strName+" 添加完成");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {  // 删除
            @Override
            public void onClick(View v) {
                String strName = etInputName.getText().toString();
                if (strName == null || strName.isEmpty()){  // 姓名不能为空
                    tvDisplay.setText("请先输入姓名");
                    return;
                }

                db.execSQL("delete from login where name = ?", new Object[]{strName});
                etInputName.setText("");
                tvDisplay.setText(strName+" 已删除");
            }
        });

        btnModify.setOnClickListener(new View.OnClickListener() {  // 修改
            @Override
            public void onClick(View v) {
                String strName = etInputName.getText().toString();
                if (strName == null || strName.isEmpty()){  // 姓名不能为空
                    tvDisplay.setText("请先输入姓名");
                    return;
                }
                String strPwd = "888888";

                db.execSQL("update login set pwd = ? where name = ?", new Object[]{strPwd, strName});
                etInputName.setText("");
                tvDisplay.setText(strName+" 的默认密码已经改为 "+strPwd);

            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {  // 关闭数据库
            @Override
            public void onClick(View v) {
                db.close();
                tvDisplay.setText("数据库已经关闭");
            }
        });
    }
}
