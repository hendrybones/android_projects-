package com.example.implicintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton=(Button)findViewById(R.id.button);



    }

    public void onClickOpenWebpageButton(View view){
        String urlAsString="http://www.udacity.com";
        openWebPage(urlAsString);
    }
    public void openWebPage(String url){
        Uri webPage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,webPage);
        if(intent.resolveActivity(getPackageManager()) !=null){
            startActivity(intent);
        }
    }
}
