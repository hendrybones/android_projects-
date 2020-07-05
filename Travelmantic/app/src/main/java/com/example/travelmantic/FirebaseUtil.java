package com.example.travelmantic;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirebaseUtil {
    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabaseReference;
    public static FirebaseUtil firebaseUtil;
    public static FirebaseAuth mFirebaseAuth;
    public static FirebaseAuth.AuthStateListener mAuthListener;
    public static ArrayList<TravelDeal>mDeals;
    private static Activity caller;


    // this will prevent it from being instantiated from outside
    private FirebaseUtil(){};
    public static  void openReference(String ref, final Activity callerActivity){
        if(firebaseUtil==null){
            firebaseUtil=new FirebaseUtil();
            mFirebaseDatabase=FirebaseDatabase.getInstance();
            mFirebaseAuth=FirebaseAuth.getInstance();
            mAuthListener=new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {


                }
            };


        }
        mDeals=new ArrayList<TravelDeal>();
        mDatabaseReference=mFirebaseDatabase.getReference().child(ref);
    }
    private static void signIn(){
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),

                caller=callerActivity,


// Create and launch sign-in intent
                caller.startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(providers)
                                .build(),
                        RC_SIGN_IN);

    }
    public static void attachListener(){
        mFirebaseAuth.addAuthStateListener(mAuthListener);
    }
    public static void detachListener(){
        mFirebaseAuth.removeAuthStateListener(mAuthListener);
    }
}
