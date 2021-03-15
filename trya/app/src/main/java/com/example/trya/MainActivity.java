package com.example.trya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView aRecylerView;
    MyAdapter amyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aRecylerView=findViewById(R.id.recylerviewtv);
        aRecylerView.setLayoutManager(new LinearLayoutManager(this));
        amyAdapter=new MyAdapter(this, getList());
        aRecylerView.setAdapter(amyAdapter);
    }
    private ArrayList<model> getList() {
        ArrayList<model> models=new ArrayList<>();
        model a=new model();
        a.setTitle("business");
        a.setDescription("this is business description");
        a.getImg(R.drawable.he);
        models.add(a);

        a.setTitle("people");
        a.setDescription("this is people description");
        a.getImg(R.drawable.food);
        models.add(a);



        return models;

    }
}
