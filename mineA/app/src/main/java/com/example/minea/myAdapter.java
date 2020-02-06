package com.example.minea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myHolder> {

    Context context;
    ArrayList<model> models;

    public myAdapter(MainActivity mainActivity, ArrayList<model> list) {
    }


    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,null);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int i) {
        myHolder.aTitle.setText(models.get(i).getTitle());
        myHolder.aDes.setText(models.get(i).getTitle());
        myHolder.aimageView.setImageResource(models.get(i).getImgs());

    }

    @Override
    public int getItemCount() {

        return models.size();
    }
}
