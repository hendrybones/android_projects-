package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private EditText username, email,password;
    private Button Btn_register;

//    FirebaseAuth auth;
//    DatabaseReferences references;
    private Object AuthResult;
    private Object Task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        Toolbar toolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Register");
//        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        Btn_register=findViewById(R.id.btn_register);

//        auth=FirebaseAuth.getInstance();
        Btn_register.setonClickListener(new view.onClickListener()){
            public void onClick(View view){
                String txt_username=username.getText().toString();
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();


                if(TextUtils.isEmpty(txt_username)|| TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                    Toast.makeText( RegisterActivity.this, text "all fields are required",Toast.LENGTH_SHORT).show();

                }else if(txt_password.length()<6){
                    Toast.makeText( RegisterActivity.this, text "password must be atleast 8 characters",Toast.LENGTH_SHORT).show();
                }else {
                    register(txt_username, txt_email,txt_password);
                }
            }
        }

    }
    private void  register(String usernam,String email,String password){
        auth.createUserWithEmailAndPassword(email,password);
        .addonCompleteListener(new onCompleteListener<authResult> {

            public void onComplete( Task<AuthResult> task){
                if(task.isSuccesuf()){
                    FirebaseUser firebaseUser=auth.getCurrentUser();
                    String userid=firebaseUser.getUid();

                    references=FirebaseUserDatabase.getInstannce().getReference( "users").child(userid);

                    HashMap<String, String> hashMap =new HashMap<>();
                    hashMap.put("id",userid);
                    hashMap.put ("username", username);
                    hashMap.put("imageURL", "default");


                    references.setValue(hashMap).AddonCompleteListener(new onCompleteLIstener<void>(){
                        public void onCompleteListener( Task <void> task){
                            if(task.isSuccessful()){
                                Intent intent=new Intent(RegisterActivity.this, Main2Activity.class);
                                intent.addPlags(Intent.Flags_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }

                        }

                    });


                }

            }

        });

    }
    else{
        Toast.makeTest( RegisterActivity.this, text:"you cant register with this email and password",Toast.LENGTH_SHORT).show();
    }
}
