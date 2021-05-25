package com.moneypati.moviewbuff.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moneypati.moviewbuff.R;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyItem> {

    List<String> strings;
    Context context;

    public HorizontalAdapter(List<String> strings, Context context) {
        this.strings = strings;
        this.context = context;
    }

    @NonNull
    @Override
    public MyItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hv_item, parent, false);

        return new MyItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItem holder, int position) {
        holder.text.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class MyItem extends RecyclerView.ViewHolder{

        TextView text;

        public MyItem(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}
