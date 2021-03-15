package com.example.textapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText text_message, text_pNumber;
    private int requestCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_pNumber=(EditText)findViewById(R.id.txt_phone_number);
        text_message=(EditText)findViewById(R.id.txt_message);

    }

    public void btn_send(View view) {
        int permissioncheck= ContextCompat.checkSelfPermission( this, Manifest.permission.SEND_SMS);
        if(permissioncheck == getPackageManager().PERMISSION_GRANTED){
            MyMessage();

        }
        else{
            ActivityCompat.requestPermissions( this,new String[] {Manifest.permission.SEND_SMS},requestCode;
        }

    }



    private void MyMessage() {
        String phoneNumber=text_pNumber.getText().toString().trim();
        String message=text_message.getText().toString().trim();
        if(!text_pNumber.getText().toString().equals("")||text_message.getText().toString().equals("")){
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage((phoneNumber),null,message,null,null);
            
           
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        
    }
}
