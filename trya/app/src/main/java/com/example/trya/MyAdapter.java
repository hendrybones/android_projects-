package com.example.trya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<model> models;


    public MyAdapter(Context c, ArrayList<model> models) {
        this.c = c;
        this.models = models;
    }

    public MyAdapter(MainActivity mainActivity, ArrayList<model> list) {

    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i) {
        MyHolder.aTitle.setText(models.get(i).getTitle());
        MyHolder.aDes.setText(models.get(i).getDescription());
        MyHolder.imageView.setImageResource(models.get(i).getImg());

    }


    @Override
    public int getItemCount() {

        return models.size();
    }
}

}
