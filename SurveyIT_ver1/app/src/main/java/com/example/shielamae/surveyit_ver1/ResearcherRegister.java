package com.example.shielamae.surveyit_ver1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class ResearcherRegister extends AppCompatActivity {

    EditText etName, etUsername, etPassword, etVPassword;
    Button btnRegister;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_researcher_register);

        etName = (EditText) findViewById(R.id.name);
        etUsername = (EditText) findViewById(R.id.usernameRR);
        etPassword = (EditText) findViewById(R.id.passwordRR);
        etVPassword = (EditText) findViewById(R.id.verifyPassword);
        btnRegister = (Button) findViewById(R.id.registerRR);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().equals("")||etUsername.getText().toString().equals("")||etPassword.getText().toString().equals("")||etVPassword.getText().toString().equals("")){
                    builder = new AlertDialog.Builder(ResearcherRegister.this);
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
                else if (!(etPassword.getText().toString().equals(etVPassword.getText().toString()))){
                    builder = new AlertDialog.Builder(ResearcherRegister.this);
                    builder.setTitle("Your password does not match");
                    builder.setMessage("Match your password");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            dialog.dismiss();
                            etPassword.setText("");
                            etVPassword.setText("");
                        }
                    });
                    AlertDialog alertDialog =  builder.create();
                    alertDialog.show();
                }
                else {
                   LoginRegisterTask lrTask = new LoginRegisterTask(ResearcherRegister.this);
                   lrTask.execute("register", etName.getText().toString(),etUsername.getText().toString(),etPassword.getText().toString());
                }
            }
        });
    }
}
