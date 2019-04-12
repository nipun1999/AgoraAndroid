package com.agoraweb.agoraweb.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.agoraweb.agoraweb.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.loginModel;
import model.signUpModel;
import retrofit.APIClient;
import retrofit2.Callback;
import retrofit2.Response;
import utils.RequestCallBack;

public class profile extends AppCompatActivity {

    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profile.this,Dashboard.class));
            }
        });



//        retrofit2.Call<loginModel> call2 = APIClient.getClient().userLogin(jsonObject.toString());
//            call2.enqueue(new Callback<loginModel>() {
//            @Override
//            public void onResponse(retrofit2.Call<loginModel> call, Response<loginModel> response) {
//                Toast.makeText(profile.this, Integer.toString(response.code()), Toast.LENGTH_SHORT).show();
////                try {
////                    Log.e("success",response.errorBody().string());
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<loginModel> call, Throwable t) {
//                Toast.makeText(profile.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
//                Log.e("failure",t.getMessage().toString());
//            }
//        });



    }
}
