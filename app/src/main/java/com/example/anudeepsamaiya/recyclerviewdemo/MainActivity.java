package com.example.anudeepsamaiya.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> exampleDataset;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager rvLayoutManager;
    RecyclerView.Adapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToDataset();

        setupRecyclerView();
    }

    private void addItemsToDataset() {
        String[] names = {"Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb",
                "Ice Cream Sandwich", "JellyBean", "KitKat", "Lollipop", "Marshmallow"};
        exampleDataset = new ArrayList<>(Arrays.asList(names));
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_example);
        rvLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvAdapter = new ExampleAdapter(this, exampleDataset);

        recyclerView.setLayoutManager(rvLayoutManager);
        recyclerView.setAdapter(rvAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
