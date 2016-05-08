package com.example.anudeepsamaiya.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ButterKnightFragment extends Fragment {

    @BindView(R.id.rvExampleFragment)
    RecyclerView recyclerView;
    private ArrayList<String> exampleDataset;

    public ButterKnightFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_butter_knight, container, false);
        ButterKnife.bind(this, view);
        addItemsToDataset();

        setupRecyclerView();

        return view;
    }

    private void addItemsToDataset() {
        String[] names = {"Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb",
                "Ice Cream Sandwich", "JellyBean", "KitKat", "Lollipop", "Marshmallow"};
        exampleDataset = new ArrayList<>(Arrays.asList(names));
    }

    private void setupRecyclerView() {
        //recyclerView = (RecyclerView) findViewById(R.id.rv_example);
        LinearLayoutManager rvLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        ExampleAdapter rvAdapter = new ExampleAdapter(getActivity(), exampleDataset);

        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.setAdapter(rvAdapter);
    }

    /**
     * Created by AnudeepSamaiya on 18-10-2015.
     */
    public static class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ItemViewHolder> {
        Context context;
        List<String> dataset;

        public ExampleAdapter(Context context, List<String> dataset) {
            this.context = context;
            this.dataset = dataset;
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            holder.tvTitle.setText(dataset.get(position));
        }

        @Override
        public int getItemCount() {
            return dataset.size();
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_title)
            TextView tvTitle;

            public ItemViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                //tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            }
        }
    }
}

