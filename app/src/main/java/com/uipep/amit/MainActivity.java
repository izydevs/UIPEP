package com.uipep.amit;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemViewModel viewModel;
    private ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBindViews();
        initViewModel();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initBindViews() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void initViewModel(){
        viewModel = ViewModelProviders.of(MainActivity.this).get(ItemViewModel.class);
        viewModel.getAllItems().observe(MainActivity.this, new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                updateUI(items);
            }
        });
    }

    private void updateUI(List<Item> items) {
        adapter = new ItemAdapter(this,items);
        recyclerView.setAdapter(adapter);
    }
}
