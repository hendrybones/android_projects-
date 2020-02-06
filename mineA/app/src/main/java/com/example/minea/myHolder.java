package com.example.minea;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class myHolder extends RecyclerView.ViewHolder {

    static ImageView aimageView;
    static TextView aTitle;
    static TextView aDes;

public myHolder (View itemview){
    super(itemview);
    this.aimageView=itemview.findViewById(R.id.imagetv);
    this.aTitle=itemview.findViewById(R.id.titletv);
    this.aDes=itemview.findViewById(R.id.descriptiontv);

}
}
