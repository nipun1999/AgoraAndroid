package com.agoraweb.agoraweb.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.agoraweb.agoraweb.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import model.signUpModel;
import retrofit.APIClient;
import retrofit2.Callback;
import retrofit2.Response;

public class registerActivity extends AppCompatActivity {

    private TextView loginBtn;
    private EditText firstName,lastName,email,password,userName;
    private Button signUp;
    private ProgressDialog progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //initialising all my objects
        loginBtn = findViewById(R.id.loginBtn);
        firstName = findViewById(R.id.firstNameEdtTxt);
        lastName = findViewById(R.id.lastNameEdtTxt);
        email = findViewById(R.id.emailEdtTxt);
        password = findViewById(R.id.passwordEdtTxt);
        signUp = findViewById(R.id.signUpBtn);
        userName = findViewById(R.id.usernameEdtTxt);
        auth = FirebaseAuth.getInstance();
        //initialising progress bar
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
        String usernameString = userName.getText().toString();
        //checking for all the cases whether correct data is entered or not.
        if(first.isEmpty()){
            Toast.makeText(this, "Please Enter your Name ", Toast.LENGTH_SHORT).show();
        }else if(last.isEmpty()){
            Toast.makeText(this, "Please Enter your Last Name", Toast.LENGTH_SHORT).show();
        }else if(emailString.isEmpty()){
            Toast.makeText(this, "Please Enter your Email", Toast.LENGTH_SHORT).show();
        }else if(passwordString.isEmpty()){
            Toast.makeText(this, "Please Enter your Password", Toast.LENGTH_SHORT).show();
        }else if(usernameString.isEmpty()){
            Toast.makeText(this, "Please Enter your Username Correctly", Toast.LENGTH_SHORT).show();
        }else{
                if(passwordString.length()<6){
                    Toast.makeText(this, "Password length has to be min of 6 characters", Toast.LENGTH_SHORT).show();
                }else{
                    progressBar.show();

                    //body for the api call
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("identifier",usernameString);
                        jsonObject.put("password",passwordString);
                        jsonObject.put("email",emailString);
                        jsonObject.put("firstName",first);
                        jsonObject.put("lastName",last);
                        Log.e("response",jsonObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    //retrofit api call

                    retrofit2.Call<signUpModel> call = APIClient.getClient().userSignUp(jsonObject.toString());
                    call.enqueue(new Callback<signUpModel>() {
                        @Override
                        public void onResponse(retrofit2.Call<signUpModel> call, Response<signUpModel> response) {
                            progressBar.dismiss();
                            //successful case
                            if(response.code()==200){
                                Toast.makeText(registerActivity.this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                                Intent emailVerification = new Intent(registerActivity.this,com.agoraweb.agoraweb.activities.emailVerification.class);
                                startActivity(emailVerification);
                            }else if(response.code()==409){ //username already exists case
                                Toast.makeText(registerActivity.this, "Username Already Exists", Toast.LENGTH_SHORT).show();
                                Log.e("signUpError",response.errorBody().toString());
                            }else{
                                //network issue case
                                Toast.makeText(registerActivity.this, "Some error occured", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(retrofit2.Call<signUpModel> call, Throwable t) {
                            progressBar.dismiss();
                            Toast.makeText(registerActivity.this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                            Intent emailVerification = new Intent(registerActivity.this,com.agoraweb.agoraweb.activities.emailVerification.class);
                            startActivity(emailVerification);
                        }
                    });

                }
            }
        }
    }
