package com.example.shielamae.surveyit_ver1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResearcherUI extends AppCompatActivity {

    TextView welcomeResearcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_researcher_ui);


    }
    @Override
    public void onBackPressed() {
    }
}
