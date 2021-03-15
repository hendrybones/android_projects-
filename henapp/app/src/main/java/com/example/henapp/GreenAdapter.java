package com.example.henapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public  class  GreenAdapter extends RecyclerView.Adapter {
    private int mNumberItems;
    private RecyclerView.ViewHolder ViewHolder;


    public  GreenAdapter(int numberOfItems) {
        mNumberItems=numberOfItems;

    }
    //@Override
   // public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup int ViewType) {
       // Context context=ViewGroup.getContext();
        //int layoutIdForListen=R.layout.number_list_item;
       // LayoutInflater inflater=layoutInlater.from(context);
        boolean shouldAttachToParentImmediatly=false;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // View view=inflater.inflate(layoutIdForListen, viewGroup,shouldAttachToParentImmediatly);
        //return ViewHolder;
    }
    //class NumberViewHolder extends RecyclerView.ViewHolder{
       // TextView listmNumberView;

        //public NumberViewHolder(view itemview){
         //   super(itemview);

          //  listmNumberView=(TextView) itemview.findViewById(R.id.tv_item_number);
       // }
        //void bind(int listIndex){listmNumberView.setText(String.valueOf(listIndex));

       // }
   // }

   // @Override
    //public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //holder.bind(position);

    //}

    //@Override
   // public int getItemCount() {
     //   return mNumberItems;
    //}
//}


//}