package com.agoraweb.agoraweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class createElection4 extends AppCompatActivity {

    private Button create;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_election4);

        create = findViewById(R.id.createBtn);
        back = findViewById(R.id.backBtn);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(createElection4.this, "Eelction Created Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(createElection4.this,createdElections.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createElection4.this,createElection3.class));
            }
        });
    }
}
