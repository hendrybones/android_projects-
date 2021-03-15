package com.example.dispapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

private static final int NUM_LIST_ITEMS=100;
private  GreeAdapter mAdapter;
private RecyclerView mNumbersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumbersList=(RecyclerView) findViewById(R.id.my_recycler_view);


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mAdapter=new GreeAdapter(NUM_LIST_ITEMS);
        mNumbersList.setAdapter(mAdapter);
    }
}
