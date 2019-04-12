package com.agoraweb.agoraweb.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.agoraweb.agoraweb.R;
import com.google.firebase.auth.FirebaseAuth;

import utils.sessionManager;

public class SplashActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    private sessionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int secondsDelayed = 1;
        auth = FirebaseAuth.getInstance();
        manager = new sessionManager(this);
        //checking if the user is logged in or not

        if(!manager.getLoginStatus()){
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    //directing to login screen
                    startActivity(new Intent(SplashActivity.this, loginScreen.class));
                    finish();
                }
            }, secondsDelayed * 1000);
        }else{
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    //directing to dashboard screen
                    startActivity(new Intent(SplashActivity.this, Dashboard.class));
                    finish();
                }
            }, secondsDelayed * 1000);
        }

    }

}
