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

    EditText surveytitleEdittext;
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

        btnCreateQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ResearcherCreateSurvey.this);
                builder.setTitle("Add Question");

// Set up the input
                final EditText questionString = new EditText(ResearcherCreateSurvey.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                questionString.setHint("Question");
                questionString.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(questionString);

// Set up the buttons
                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = questionString.getText().toString();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

        btnSavesurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
