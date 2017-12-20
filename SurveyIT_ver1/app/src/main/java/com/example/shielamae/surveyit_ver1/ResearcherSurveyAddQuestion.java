package com.example.shielamae.surveyit_ver1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Shiela Mae on 20/12/2017.
 */

public abstract class ResearcherSurveyAddQuestion extends AppCompatActivity{

    EditText questionTitleEdittxt,startValueNameEdittxt,maxValueNameEdittxt;
    TextView currentStartValtxt,currentMaxValuetxt;
    Spinner startValueSpinner,maxValueSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_researcher_surveycreatequestion);
        questionTitleEdittxt = findViewById(R.id.questiontitleedittxt);
        startValueNameEdittxt = findViewById(R.id.startvaluename);
        maxValueNameEdittxt = findViewById(R.id.maxvaluename);
        currentStartValtxt = findViewById(R.id.currentstartvaltxt);
        currentMaxValuetxt = findViewById(R.id.currentmaxvaltxt);

    }
}
