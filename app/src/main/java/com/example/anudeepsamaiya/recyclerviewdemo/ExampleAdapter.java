package com.example.anudeepsamaiya.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by AnudeepSamaiya on 18-10-2015.
 */
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ItemViewHolder> {
    Context context;
    List<String> dataset;

    public ExampleAdapter(Context context, List<String> dataset){
        this.context = context;
        this.dataset = dataset;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
