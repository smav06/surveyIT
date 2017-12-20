package com.example.shielamae.surveyit_ver1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserChoices extends AppCompatActivity {

    Button btnResearcher, btnRespondent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choices);

        btnResearcher = findViewById(R.id.researcher);
        btnRespondent = findViewById(R.id.respondent);

        btnResearcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserChoices.this,ResearcherLogin.class));
            }
        });

        btnRespondent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserChoices.this,RespondentUI.class));
            }
        });
    }
}
