package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText username,email,password;
    Button btn_register;
    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);

        btn_register.setOnClickListener(new  view.onClickListener()){
            public void onClick(View view){
                String txt_username=username.getText().toString();
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();

                if(TextUtils.isEmpty(txt_username)||TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                    Toast.makeText(RegisterActivity.this, text:"all fields are required",Toast.LENGTH_SHORT);
                }

            }
        }


    }
}
