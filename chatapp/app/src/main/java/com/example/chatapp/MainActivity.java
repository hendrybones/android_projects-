package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button login,Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        Register=findViewById(R.id.Register);

        login.setOnClickListener(new view.onClickLIstener()){
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,loginActivity.class));

            }


        }
        Register.setOnClickListener(new view.onClickLIstener(){
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });

    }
}
