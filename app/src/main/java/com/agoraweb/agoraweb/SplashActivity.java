package com.agoraweb.agoraweb;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {


    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int secondsDelayed = 1;
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()==null){
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(SplashActivity.this, loginScreen.class));
                    finish();
                }
            }, secondsDelayed * 1000);
        }else{
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(SplashActivity.this, Dashboard.class));
                    finish();
                }
            }, secondsDelayed * 1000);
        }

    }

}
