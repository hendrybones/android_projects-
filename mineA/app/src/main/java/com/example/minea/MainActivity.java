 package com.example.minea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {


    RecyclerView aRecylerView;
    myAdapter amyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aRecylerView=findViewById(R.id.recyclerview);
        aRecylerView.setLayoutManager(new LinearLayoutManager(this));
        amyAdapter=new myAdapter(this, getList());
        aRecylerView.setAdapter(amyAdapter);
    }

    private ArrayList<model> getList() {
        ArrayList<model> models=new ArrayList<>();
        model a=new model();
        a.setTitle("business");
        a.setDescription("this is business description");
        a.getImgs(R.drawable.hen);
        models.add(a);

        a.setTitle("people");
        a.setDescription("this is people description");
        a.getImgs(R.drawable.newfood);
        models.add(a);

        a.setTitle("feedback");
        a.setDescription("this is feedback description");
        a.getImgs(R.drawable.newfeed);
        models.add(a);

        return models;

    }
}
