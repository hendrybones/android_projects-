 package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

 public class InsertActivity extends AppCompatActivity {
     private FirebaseDatabase mFirebaseDatabbase;
     private DatabaseReference mDatabaseReference;
     EditText text_title;
     EditText text_price;
     EditText text_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        mFirebaseDatabbase=FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabbase.getReference();
        text_title=(EditText)findViewById(R.id.text_title);
        text_price=(EditText)findViewById(R.id.text_price) ;
        text_description=(EditText)findViewById(R.id.text_description);

    }

     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_menu:
                saveDeal();
                Toast.makeText(this,"deal saved",Toast.LENGTH_LONG).show();
                clean();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

     }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         MenuInflater inflater=getMenuInflater();
         inflater.inflate(R.menu.save_menu,menu);
         return true;
     }
     private void saveDeal(){
        String title=text_title.getText().toString();
        String description=text_description.getText().toString();
        String price=text_price.getText().toString();
        TravelDeal deal=new TravelDeal(title,description,price,"");
        mDatabaseReference.push().setValue(deal);
     }
     private void clean(){
        text_title.setText("");
        text_price.setText("");
        text_description.setText("");
        text_title.requestFocus();
     }
 }
