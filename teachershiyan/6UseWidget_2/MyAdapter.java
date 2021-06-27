package com.app.cxh.usewidget_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    @NonNull
    private Context context;
    private List<String> itemList;

    public MyAdapter(Context context, List<String> itemList){
        this.context = context;
        this.itemList =itemList;
    }

    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyAdapter.MyHolder(LayoutInflater.from(context).inflate(R.layout.my_item2, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, int position) {
        holder.tvItem.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList == null?0:itemList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        public MyHolder(View itemView) {
            super(itemView);
            tvItem = (TextView)itemView.findViewById(R.id.tvItem);
        }
    }
}
