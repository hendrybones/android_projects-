package com.example.comment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    EditText addcomment;
    ImageView image_profile;
    TextView post;

    String postid;
    String publisheid;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("comment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new  view.onClickListener(){
            public void  onClick(View view){
                finish();

            }
        });
        addcomment=findViewById(R.id.add_comment);
        image_profile=findViewById(R.id.image_profile);
        post=findViewById(R.id.post);

        Intent intent=getIntent();
        postid=intent.getStringExtra( "postid");
        publisheid=intent.getStringExtra("publisheid");

        post.setOnClickListener(new view.onClickListener(){
            public void  onClick(View view){
                if(addcomment.getText().toString().equals("")){
                    Toast.makeText(this,"you can send empty comment",Toast.LENGTH_SHORT).show();
                }else {
                    addcomment();
                }

            }

        });

    }
    public void addcomment(){
        DatabaseReference reference=FirebaseDatbase.getReferences("comment").child(postid);

        hashMap<String, Object> hashmap=new hashMap<>();
        hashmap.put("comment",addcomment.getText().toString());
        hashmap.put("publisher",firebaseUser.getUid());

        reference.push().setValue(hashmap);
        addcomment.setText("");



    }
    private void getImags(){
        DatabaseReference reference=FirebaseDatabase.getReference("users").child(firebaseuser.getUid());
        reference.addValueEventListener(new valueEventListener(){
            public void  onDataChange(DataSnagshot dataSnagshot){
                User user= dataSnagshot.getValue(User.class);
                olide.with(getApplicationContext()).getImage().into(image_profile);

            }
            public void onCancelled(DatabaseError databaseError){

            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


}
