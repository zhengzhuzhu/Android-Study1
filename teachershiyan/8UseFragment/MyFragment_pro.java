package com.app.cxh.usefragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyFragment_pro extends Fragment {

    // 传参
    public static MyFragment_pro newInstance(String strTextPar) {
        MyFragment_pro myFragment_pro = new MyFragment_pro();
        Bundle bundle = new Bundle();
        bundle.putString("strText",strTextPar);
        myFragment_pro.setArguments(bundle);
        return myFragment_pro;
    }
    // 放在上面
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment_pro,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 取参
        String strGetText="";
        if(getArguments() != null){
            strGetText  = getArguments().getString("strText");
        }
        // 在控件中显示
        TextView tvText = (TextView)view.findViewById(R.id.tvText);
        tvText.setText(strGetText);

        // 获得Fragment布局中的控件
        Button btnSend;
        btnSend = (Button)view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获得主调界面 上 的控件，直接修改（但不用此法）
                //TextView tvMain = ((MainActivity)getActivity()).findViewById(R.id.tvMain);
                //tvMain.setText("我是来自Fragment的数据");

                // 调用主程序的方法来回传数据
                ((MainActivity)getActivity()).getFromFragment("我是来自Fragment的数据");

            }
        });
    }
}
