package com.example.appviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

 public class CustomAdapter extends RecyclerView.Adapter {

     ArrayList personNames;
     ArrayList personImages;
     Context context;
    public CustomAdapter(Context context, ArrayList personNames, ArrayList personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inlate the item layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(personNames.get(position));
        holder.image.setImageResource(personImages.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View itemView) {
                // display a toast with person name on item click
                Toast.makeText(context, (Integer) personNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return personNames.size();

    }

     public class MyViewHolder extends RecyclerView.ViewHolder {
         // init the item view's
         TextView name;
         ImageView image;
         public MyViewHolder(View itemView) {
             super(itemView);
             // get the reference of item view's
             name = (TextView) itemView.findViewById(R.id.name);
             image = (ImageView) itemView.findViewById(R.id.image);
         }
     }


         }
     
 
