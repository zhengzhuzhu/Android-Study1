package com.app.cxh.usewidget_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter_pro extends RecyclerView.Adapter<MyAdapter_pro.MyHolder> {
    @NonNull
    private Context context;

    public MyAdapter_pro(Context context){
        this.context = context;
    }

    public MyAdapter_pro.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyAdapter_pro.MyHolder(LayoutInflater.from(context).inflate(R.layout.my_item_pro,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter_pro.MyHolder holder, final int position) {
        if (position%2 != 0) {
            holder.ivGdou.setImageResource(R.drawable.gdou1_s);
        }else{
            holder.ivGdou.setImageResource(R.drawable.gdou2_s);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {  // 点击事件
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"You clicked item "+(position+1),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 18;  // 暂时写固定
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView ivGdou;
        public MyHolder(View itemView) {
            super(itemView);
            ivGdou = (ImageView)itemView.findViewById(R.id.ivGdou);
        }
    }
}
