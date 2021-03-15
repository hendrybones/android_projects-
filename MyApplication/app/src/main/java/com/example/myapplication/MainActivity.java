package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = MainActivity.class.getSimpleName();
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if sms permission is enabled
        checkForSmsPermissions();
    }

    private void checkForSmsPermissions() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "PERMISSION NOT GRANTED");

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        }

        //If permission granted do...
        else {
            enableSmsButton();
        }
    }

    private void enableSmsButton() {
        ImageButton smsButton = (ImageButton) findViewById(R.id.message_icon);
        smsButton.setVisibility(View.VISIBLE);
    }

    public void smsSendMessage(View view) {
        Log.d(TAG, "PERMISSION GRANTED");
        EditText editText = (EditText) findViewById(R.id.editText_main);
        //Set destination
        String destinationAddress = editText.getText().toString();
        //Find sms EditView
        EditText smsEditText = (EditText) findViewById(R.id.sms_message);
        //
        String smsMessage = smsEditText.getText().toString();
        // set service sender address to null
        String scAddress = null;
        //set pending intents to broadcast when it's send and when delivered
        PendingIntent sentIntent = null, deliveryIntent =null;

        checkForSmsPermissions();

        SmsManager smsManager = SmsManager.getDefault();

        smsManager.sendTextMessage(destinationAddress, scAddress, smsMessage, sentIntent, deliveryIntent);
    }

    public void retryApp(View view) {
    }
}