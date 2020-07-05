package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mtext_Entry;
    Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtext_Entry=(EditText) findViewById(R.id.text_entry);
        mbutton = (Button) findViewById(R.id.btn);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textEntered=mtext_Entry.getText().toString();
                Context context=MainActivity.this;
                Class destinationActivity=ChildActivity.class;
                Intent startchildActivityIntent=new Intent(context, destinationActivity);
                startchildActivityIntent.putExtra(Intent.EXTRA_INTENT,textEntered);
                startActivity(startchildActivityIntent);
            }
        });

    }
}
