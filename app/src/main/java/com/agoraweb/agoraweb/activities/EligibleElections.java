package com.agoraweb.agoraweb.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.agoraweb.agoraweb.R;

public class EligibleElections extends AppCompatActivity {

    private ImageView backBtn;
    private CardView voteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligible_elections);

        backBtn = findViewById(R.id.backBtn);
        voteBtn = findViewById(R.id.voteBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EligibleElections.this,Dashboard.class));
            }
        });

        voteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EligibleElections.this,preferrentialVote.class));
            }
        });

    }
}
