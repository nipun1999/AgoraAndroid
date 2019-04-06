package com.agoraweb.agoraweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class createdElections extends AppCompatActivity {

    private CardView electionCard;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_elections);

        electionCard = findViewById(R.id.electionCard);
        backBtn = findViewById(R.id.backBtn);

        electionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createdElections.this,editCreatedElection.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createdElections.this,Dashboard.class));
            }
        });


    }
}
