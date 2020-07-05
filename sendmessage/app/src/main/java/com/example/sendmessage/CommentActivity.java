package com.example.sendmessage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class CommentActivity extends AppCompatActivity {

    EditText add_comment;
    ImageView image_profile;
    TextView post;


    String postId;
    String publisherId;

    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("comments");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getImage();

        add_comment=findViewById(R.id.image_profile);
        post=findViewById(R.id.post);

        Intent intent=getIntent();
        postId=intent.getStringExtra("postId");
        publisherId=intent.getStringExtra("publisherId");

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(add_comment.getText().toString().equals("")){
                    Toast.makeText(CommentActivity.this,"you cant make empty comment",Toast.LENGTH_SHORT).show();
                }else{
                    add_comment();
                }
            }
        });}

    private void setSupportActionBar(Toolbar toolbar) {

    }

    private void add_comment(){
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference( "comments").child(postId);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("comment",add_comment.getText().toString());
        hashMap.put("publisher",firebaseUser.getUid());

        reference.push().setValue(hashMap);
        add_comment.setText("");
    }
    private void getImage(){
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Users users=dataSnapshot.getValue(Users.class);
                olide.with(getApplicationContext()).load(users.getImageurl()).into(image_profile);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
