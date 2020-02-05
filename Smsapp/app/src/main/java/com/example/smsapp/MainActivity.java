package com.example.smsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText text_number,text_message;
    private String requestCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_message=(EditText)findViewById(R.id.text_message);
        text_number=(EditText)findViewById(R.id.text_number);
    }

    public void btn_send(View view) {
        int permissioncheck= ContextCompat.checkSelfPermission( this, Manifest.permission.SEND_SMS);
        if(permissioncheck == getPackageManager().PERMISSION_GRANTED){
            MyMessage();

        }
        else{
            ActivityCompat.requestPermissions( this, new String[]{Manifest.permission.SEND_SMS},requestCode 0);
            }

        }

}

    private void MyMessage() {
        String phoneNunber=text_number.getText().toString().trim();
        String message=text_message.getText().toString().trim();
        if(!text_number.getText().toString().equals("")||text_message.getText().toString().equals("")){
        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage((phoneNunber, null,message,null,null);
        Toast.makeText( this, text:"message sent",Toast.LENGTH_SHORT).show();


    }else {
            Toast.makeText(this,text:"please enter number or message",Toast.LENGTH_SHORT).show();
    }

}



}

