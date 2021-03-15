package com.example.trya;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class MyHolder  extends ViewHolder {
    static ImageView imageView;
     static TextView aTitle;
     static TextView aDes;
    public MyHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView=itemView.findViewById(R.id.imagetv);
        this.aTitle=itemView.findViewById(R.id.titletv);
        this.aDes=itemView.findViewById(R.id.descriptiontv);
    }
}
