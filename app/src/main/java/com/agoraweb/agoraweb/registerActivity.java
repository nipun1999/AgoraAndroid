package com.agoraweb.agoraweb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity {

    private TextView loginBtn;
    private EditText firstName,lastName,email,password,confirmPassword;
    private Button signUp;
    private ProgressDialog progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginBtn = findViewById(R.id.loginBtn);
        firstName = findViewById(R.id.firstNameEdtTxt);
        lastName = findViewById(R.id.lastNameEdtTxt);
        email = findViewById(R.id.emailEdtTxt);
        confirmPassword = findViewById(R.id.confirmPasswordEdtTxt);
        password = findViewById(R.id.passwordEdtTxt);
        signUp = findViewById(R.id.signUpBtn);
        auth = FirebaseAuth.getInstance();

        progressBar = new ProgressDialog(this);
        progressBar.setMessage("Loading, Please Wait");
        progressBar.setCancelable(false);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(registerActivity.this,loginScreen.class);
                startActivity(login);
            }
        });
    }

    private void registerUser() {
        String first = firstName.getText().toString();
        String last = lastName.getText().toString();
        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();
        String confirmPasswordString = confirmPassword.getText().toString();

        if(first.isEmpty()){
            Toast.makeText(this, "Please Enter your Name ", Toast.LENGTH_SHORT).show();
        }else if(last.isEmpty()){
            Toast.makeText(this, "Please Enter your Last Name", Toast.LENGTH_SHORT).show();
        }else if(emailString.isEmpty()){
            Toast.makeText(this, "Please Enter your Email", Toast.LENGTH_SHORT).show();
        }else if(passwordString.isEmpty()){
            Toast.makeText(this, "Please Enter your Password", Toast.LENGTH_SHORT).show();
        }else if(confirmPasswordString.isEmpty()){
            Toast.makeText(this, "Please re-enter your password", Toast.LENGTH_SHORT).show();
        }else{
            if(!passwordString.equals(confirmPasswordString)){
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }else{
                if(passwordString.length()<6){
                    Toast.makeText(this, "Password length has to be min of 6 characters", Toast.LENGTH_SHORT).show();
                }else{
                    progressBar.show();
                    auth.createUserWithEmailAndPassword(emailString,passwordString).addOnCompleteListener(registerActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.dismiss();
                            if(!task.isSuccessful()){
                                Toast.makeText(registerActivity.this, "Email Id Already Exists", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(registerActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(registerActivity.this,Dashboard.class));
                                finish();
                            }
                        }
                    });
                }
            }
        }
    }
}
