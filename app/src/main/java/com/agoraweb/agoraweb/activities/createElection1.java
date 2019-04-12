package com.agoraweb.agoraweb.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.agoraweb.agoraweb.R;

public class createElection1 extends AppCompatActivity {

    private Button nextBtn;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_election1);

        nextBtn = findViewById(R.id.nextBtn);
        backBtn = findViewById(R.id.backBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createElection1.this,createElection2.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createElection1.this,Dashboard.class));
            }
        });
    }


}
