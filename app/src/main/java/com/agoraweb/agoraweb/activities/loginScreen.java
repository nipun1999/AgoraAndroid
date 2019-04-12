package com.agoraweb.agoraweb.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.se.omapi.Session;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

import model.loginModel;
import retrofit.APIClient;
import retrofit2.Callback;
import retrofit2.Response;
import utils.sessionManager;

public class loginScreen extends AppCompatActivity {


    private TextView createAcc;
    private EditText userNameTxt,passwordTxt;
    private Button goBtn;
    private FirebaseAuth auth;
    private ProgressDialog progressBar;
    private sessionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        //initialising all my objects
        manager = new sessionManager(this);

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
                Intent registerActivity = new Intent(loginScreen.this, com.agoraweb.agoraweb.activities.registerActivity.class);
                startActivity(registerActivity);
            }
        });
    }

    private void loginUser() {
        String email = userNameTxt.getText().toString();
        final String password = passwordTxt.getText().toString();
        //checking if email or password is entered.
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Enter your email", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please Enter your password", Toast.LENGTH_SHORT).show();
        }else{
            progressBar.show();
            //authorising user, calling retrofit API

            //putting json parameters for body
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("identifier",email);
                jsonObject.put("password",password);
                Log.e("response",jsonObject.toString()); //repsonse Logs
            } catch (JSONException e) {
                e.printStackTrace();
            }


           //calling api

            retrofit2.Call<loginModel> call2 = APIClient.getClient().userLogin(jsonObject.toString());
            call2.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(retrofit2.Call<loginModel> call, Response<loginModel> response) {
                progressBar.dismiss();
                //succcessful response
                if(response.code()==200){
                    Toast.makeText(loginScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    manager.setLoginSatus(true);
                    Intent dashboard = new Intent(loginScreen.this,Dashboard.class);
                    startActivity(dashboard);
                }else if(response.code()==403){
                    manager.setLoginSatus(false);//wrong credentials case
                    Toast.makeText(loginScreen.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }else if(response.code()==400){
                    manager.setLoginSatus(false);//email not verified case
                    try {
                        Log.e("loginError",response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent emailVerification = new Intent(loginScreen.this,com.agoraweb.agoraweb.activities.emailVerification.class);
                    startActivity(emailVerification);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<loginModel> call, Throwable t) {
                progressBar.dismiss();
                Toast.makeText(loginScreen.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                Log.e("failure",t.getMessage().toString());
            }
        });

        }

    }
}
