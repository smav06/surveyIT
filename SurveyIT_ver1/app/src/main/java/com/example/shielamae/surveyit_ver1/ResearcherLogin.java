package com.example.shielamae.surveyit_ver1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResearcherLogin extends AppCompatActivity {

    TextView txtCreateAccount;
    TextView etusername,etpassword;
    Button btnLogin;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_researcher_login);

        txtCreateAccount =  findViewById(R.id.registerRL);

        etusername = findViewById(R.id.usernameRL);
        etpassword = findViewById(R.id.passwordRL);
        btnLogin = findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etusername.getText().toString().equals("")||etpassword.getText().toString().equals("")){
                    builder = new AlertDialog.Builder(ResearcherLogin.this);
                    builder.setTitle("Something went wrong...");
                    builder.setMessage("Please fill all the fields provided");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alertDialog =  builder.create();
                    alertDialog.show();
                }

                else {
                    startActivity(new Intent(ResearcherLogin.this,ResearcherUI.class));
                    //LoginRegisterTask backgroundTask = new LoginRegisterTask(ResearcherLogin.this);
                    //backgroundTask.execute("login",etusername.getText().toString(),etpassword.getText().toString());



                }

            }

        });

        //if create account
        txtCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResearcherLogin.this,ResearcherRegister.class));
            }

        });


    }
}
