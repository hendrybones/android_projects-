package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    private TextView mDisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        mDisplayText=(TextView)findViewById(R.id.tv_display);
        Intent intentThatstartedThisActivity=getIntent();
        if(intentThatstartedThisActivity.hasExtra(Intent.EXTRA_TEXT)){
            String textentered=intentThatstartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
            mDisplayText.setText(textentered);

        }
    }
}
