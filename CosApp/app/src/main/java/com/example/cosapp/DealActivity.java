package com.example.cosapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class DealActivity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private static final int PICTURE_RESULT=42;
    EditText txt_title;
    EditText txt_price;
    EditText txt_description;
    TravelDeal deal;
    ImageView ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
//        FirebaseUtil.openFbReference("Travel Deal",this);

        mFirebaseDatabase=FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference=FirebaseUtil.mDatabaseReference;//a create a class tha contain id and other details
        txt_title=(EditText)findViewById(R.id.txt_title);
        txt_price=(EditText)findViewById(R.id.txt_price);
        txt_description=(EditText)findViewById(R.id.txt_description);
        ImageView =(ImageView)findViewById(R.id.image);
        Intent intent=getIntent();
        TravelDeal deal=(TravelDeal)intent.getSerializableExtra("Deal");
        if (deal==null){
            deal=new TravelDeal();
        }
        this.deal=deal;
        txt_title.setText(deal.getTitle());
        txt_price.setText(deal.getPrice());
        txt_description.setText(deal.getDescription());
        showImage(deal.getImageUrl()); 

        Button btnImage=findViewById(R.id.btnImage);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //this intent will enable the user to select the data and return it
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                startActivityForResult(intent.createChooser(intent,"Insert picture"),PICTURE_RESULT);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //we use switch to get item that was clicked
        switch (item.getItemId()){
            case R.id.save_menu:
                saveDeal();
                Toast.makeText(this,"comment saved",Toast.LENGTH_LONG).show();
                clean();
                backToList();
                return true;
            case R.id.delete_menu:
                deletedDeal();
                Toast.makeText(this,"deal deleted",Toast.LENGTH_LONG).show();
                //we call this method because we want to be back to the list after deleteing
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
        if (FirebaseUtil.isAdmin){
            menu.findItem(R.id.delete_menu).setVisible(true);
            menu.findItem(R.id.save_menu).setVisible(true);
           enableEditText(true);

        }else{
            menu.findItem(R.id.delete_menu).setVisible(false);
            menu.findItem(R.id.save_menu).setVisible(false);
            enableEditText(false);

        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICTURE_RESULT && resultCode == RESULT_OK) {

            Uri imageUri=data.getData();
            StorageReference ref=FirebaseUtil.mStorageRef.child(imageUri.getLastPathSegment());
            ref.putFile(imageUri).addOnSuccessListener(this,  new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    String url=taskSnapshot.getUploadSessionUri().toString();
                    deal.setImageUrl(url);
                    showImage(url);

                }
            });
        }
    }

    private void saveDeal(){
        deal.setTitle(txt_title.getText().toString());
        deal.setPrice(txt_price.getText().toString());
        deal.setDescription(txt_description.getText().toString());
        if (deal.getId()==null){
            mDatabaseReference.push().setValue(deal);

        }else {
            mDatabaseReference.child(deal.getId()).setValue(deal);
        }

//        TravelDeal deal=new TravelDeal(title,description,price ,"");
//        mDatabaseReference.push().setValue(deal);

    }
    private void deletedDeal(){
        if (deal==null){
            Toast.makeText(this,"please save the deal before deleting",Toast.LENGTH_LONG).show();
            return;
        }
        mDatabaseReference.child(deal.getId()).removeValue();
    }
    private void backToList(){
        Intent intent=new Intent(this,ListActivity.class);
        startActivity(intent);
    }
    private  void clean(){
        txt_title.setText("");
        txt_price.setText("");
        txt_description.setText("");
        txt_title.requestFocus();

    }
    private void enableEditText(boolean isEnabled){
        txt_title.setEnabled(isEnabled);
        txt_description.setEnabled(isEnabled);
        txt_price.setEnabled(isEnabled);
    }
    private void showImage(String url){
        if (url !=null && url.isEmpty()==false){
            int width= Resources.getSystem().getDisplayMetrics().widthPixels;
            Picasso.get()
                    .load(url)
                    .resize(width,2/3)
                    .centerCrop()
                    .into(ImageView);
        }
    }
}
