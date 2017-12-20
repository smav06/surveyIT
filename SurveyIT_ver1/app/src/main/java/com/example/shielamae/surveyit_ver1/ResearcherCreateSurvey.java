package com.example.shielamae.surveyit_ver1;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jcgut on 12/20/2017.
 */

public class ResearcherCreateSurvey extends AppCompatActivity {

    EditText surveytitleEdittext,surveydescriptionEdittext,marginoferrorsEdittext;
    FloatingActionButton btnCreateQuestion;
    FloatingActionButton btnSavesurvey;
    private String m_Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_researcher_createsurvey);
        surveytitleEdittext = findViewById(R.id.surveytitleedittext);
        btnCreateQuestion = findViewById(R.id.btnCreateQuestion);
        btnSavesurvey = findViewById(R.id.btnSaveSurvey);
        surveydescriptionEdittext = findViewById(R.id.surveydescedittxt);
        marginoferrorsEdittext = findViewById(R.id.MofEedittxt);

        btnCreateQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSavesurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
