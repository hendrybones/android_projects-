package com.example.henapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private static final int Number_List_Items=100;
   private int mNumberItems;
    private GreenAdapter mAdapter;
    private RecyclerView mNumberList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumberList=(RecyclerView) findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        mNumberList.setLayoutManager(layoutManager);
        mNumberList.setHasFixedSize(true);
       mAdapter=new GreenAdapter(Number_List_Items);

        mNumberList.setAdapter(mAdapter);
    }



}
