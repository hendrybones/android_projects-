package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Context;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mbloglist;
    private DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdatabase = FirebaseDatabase.getIntance().getReference().child("users");
        mdatabase.keepSynced(true);

        mbloglist = (RecyclerView) findViewById(R.id.view);
        mbloglist.setHasFixedSize(true);
        mbloglist.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseReclerAdapter<Blog, BlogViewholder> firebaseReclerAdapter = new FirebaseRecylerAdpter<Blog, BlogViewHolder>
                (Blog.class, R.layout.blog_row, BlogViewHolder.class, mdatabase){
            protected void  populateViewHolder(BlogViewHolder viewHolder,blog model, int position){
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(),model.getImage());

            }
        };
        mbloglist.setAdapter(firebaseReclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder{
        View mView;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;
        }

        public void setTitle(String title) {
            TextView post_title=(TextView)mView.findViewById(R.id.post_title);
            post_title.setText(title);
        }
        public void setDesc(String desc){
            TextView post_desc=(TextView)mView.findViewById(R.id.post_desc);
            post_desc.setText(desc);
        }
        public void setImage(Context context, String image){
            ImageView post_image=(ImageView)mView.findViewById(R.id.post_image);
            Picasso.with(context).load(image).into(post_image);

        }


    }


    private class BlogViewholder {
    }
}
