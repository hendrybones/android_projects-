package com.example.dispapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GreeAdapter  extends RecyclerView.Adapter<GreeAdapter.NumberViewHolder> {

    final private  ListItemClickListener monClickListener;
    private int mNumberItems;
    private static int viewHolderCount;

    public interface  ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }


    public GreeAdapter(int numberOfitem, ListItemClickListener listener){
        mNumberItems=numberOfitem;
        monClickListener=listener;
        viewHolderCount=0;

    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context=viewGroup.getContext();
        int layoutIdForListen=R.layout.number_list_item;
        LayoutInflater inflater=LayoutInflater.from(context);
        boolean shouldAttachToparentImmediatly=false;


        View view=inflater.inflate(layoutIdForListen,viewGroup, shouldAttachToparentImmediatly);
        NumberViewHolder viewHolder=new NumberViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class NumberViewHolder extends  RecyclerView.ViewHolder {
        implements View.onClickListener{
            TextView listItemNumberView;

        }



        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemNumberView = (TextView) itemView.findViewById(R.id.tv_item_number);
            viewHolderIdex=(TextView) itemView.findViewById(R.id.my_recycler_view);
            itemView.setOnClickListener(this);
        }

        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }

        public void onClick(View view){
            int clickedPostion=getAdapterPosition();
            monClickListener.onListItemClick(clickedPostion);
        }
    }
}
