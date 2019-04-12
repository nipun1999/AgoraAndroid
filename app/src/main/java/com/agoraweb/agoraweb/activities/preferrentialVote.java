package com.agoraweb.agoraweb.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.agoraweb.agoraweb.R;

public class preferrentialVote extends AppCompatActivity {

    private ImageView backBtn;
    private Button castVoteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferrential_vote);


        backBtn = findViewById(R.id.backBtn);
        castVoteBtn = findViewById(R.id.castVoteBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(preferrentialVote.this,EligibleElections.class));
            }
        });

        castVoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(preferrentialVote.this, "Vote Casted Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(preferrentialVote.this,Dashboard.class));
            }
        });


    }

}
