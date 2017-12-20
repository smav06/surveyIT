package com.example.shielamae.surveyit_ver1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResearcherUI extends AppCompatActivity {

    Button createsurveyBtn;
    Button viewsurveyBtn;
    Button viewsurveystatsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_researcher_ui);
        createsurveyBtn = findViewById(R.id.btnCreateSurvey);
        viewsurveyBtn = findViewById(R.id.btnViewSurvey);
        viewsurveystatsBtn = findViewById(R.id.btnViewReport);

        createsurveyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResearcherUI.this,ResearcherCreateSurvey.class));
            }
        });

        viewsurveyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResearcherUI.this,ResearcherViewSurvey.class));
            }
        });

        viewsurveystatsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResearcherUI.this,ResearcherSurveyStats.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}
