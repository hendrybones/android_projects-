 package com.example.travelmantic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

 public class DealActivity extends AppCompatActivity {
     private FirebaseDatabase mFirebaseDatabase;
     private DatabaseReference mDatabaseReference;

     EditText txt_title;
     EditText txt_price;
     EditText txt_description;
     TravelDeal deal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);
        FirebaseUtil.openReference("TravelDeal");
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference =FirebaseUtil.mDatabaseReference;

        txt_title=(EditText)findViewById(R.id.txt_title);
         txt_price=(EditText)findViewById(R.id.txt_price);
        txt_description=(EditText)findViewById(R.id.txt_description);
        Intent intent=getIntent();
        TravelDeal deal=(TravelDeal)intent.getSerializableExtra("deal");
        if (deal==null){
            deal=new TravelDeal();

        }
        this.deal=deal;
        txt_title.setText(deal.getTitle());
        txt_price.setText(deal.getPrice());
        txt_description.setText(deal.getDescription());

    }

     @Override
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_menu:
                saveDeal();
                Toast.makeText(this,"Deal saved",Toast.LENGTH_LONG).show();
                clean();
                backToList();
                return true;
            case R.id.delete_menu:
                deleteDeal();
                Toast.makeText(this,"deal deleted",Toast.LENGTH_LONG).show();
                backToList();
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
     public void saveDeal(){
        deal.setTitle(txt_title.getText().toString());
        deal.setDescription(txt_description.getText().toString());
        deal.setPrice(txt_price.getText().toString());
        if (deal.getId()==null){
            mDatabaseReference.push().setValue(deal);
        } else{
            mDatabaseReference.child(deal.getId()).setValue(deal);
        }

//        TravelDeal deal=new TravelDeal(title,description,price,"");
        //setting data into the database
         mDatabaseReference.push().setValue(deal);


     }
     public void deleteDeal(){
        if (deal==null){
            Toast.makeText(this,"please save the deal",Toast.LENGTH_SHORT).show();
            return;
        }
        mDatabaseReference.child(deal.getId()).removeValue();

     }
     private void backToList(){
        Intent intent=new Intent(this,ListActivity.class);
        startActivity(intent);
     }
     public void clean(){
        txt_title.setText("");
        txt_description.setText("");
        txt_price.setText("");
        txt_title.requestFocus();
        
     }
 }
