package com.agoraweb.agoraweb.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.agoraweb.agoraweb.R;

public class emailVerification extends AppCompatActivity {

    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginScreen = new Intent(emailVerification.this,com.agoraweb.agoraweb.activities.loginScreen.class);
                startActivity(loginScreen);
            }
        });
    }
}


