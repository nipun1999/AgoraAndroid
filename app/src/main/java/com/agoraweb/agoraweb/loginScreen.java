package com.agoraweb.agoraweb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginScreen extends AppCompatActivity {


    private TextView createAcc;
    private EditText userNameTxt,passwordTxt;
    private Button goBtn;
    private FirebaseAuth auth;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        createAcc = findViewById(R.id.createAccountBtn);
        userNameTxt = findViewById(R.id.usernameEdtTxt);
        passwordTxt = findViewById(R.id.passwordEdtTxt);

        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(false);
        progressBar.setMessage("Loading, Please wait");

        goBtn = findViewById(R.id.goBtn);

        auth = FirebaseAuth.getInstance();

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(loginScreen.this,com.agoraweb.agoraweb.registerActivity.class);
                startActivity(registerActivity);
            }
        });
    }

    private void loginUser() {
        String email = userNameTxt.getText().toString();
        final String password = passwordTxt.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Enter your email", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please Enter your password", Toast.LENGTH_SHORT).show();
        }else{
            progressBar.show();
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(loginScreen.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.dismiss();
                    if(!task.isSuccessful()){
                        if (password.length() < 6) {
                            passwordTxt.setError("Password should be of min 6 charachters");
                        } else {
                            Toast.makeText(loginScreen.this,"Authentication Failed", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(loginScreen.this, "Authentication Successful", Toast.LENGTH_SHORT).show();
                        Intent dashboard = new Intent(loginScreen.this,Dashboard.class);
                        startActivity(dashboard);
                    }
                }
            });
        }

    }
}
