package com.example.shielamae.surveyit_ver1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Shiela Mae on 13/12/2017.
 */

public class LoginRegisterTask extends AsyncTask<String, Void, String> {

    String urlRegister = "http://192.168.1.8:1234/surveyIT_Files/configs/register.php";
    String urlLogin = "http://192.168.1.8:1234/surveyIT_Files/configs/login.php";
    Context ctx;
    Activity activity;
    AlertDialog.Builder builder;
    ProgressDialog progressDialog;
    String method;
    // String uemail;


    public LoginRegisterTask(Context ctx) {
        this.ctx = ctx;
        activity = (Activity) ctx;
    }


    @Override
    protected void onPreExecute() {
        //super.onPreExecute();
        builder = new AlertDialog.Builder(activity);
        progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("Please Wait..");
        progressDialog.setMessage("Connecting to Server..");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        method = params[0];

        if (method.equals("register")) {
            try {
                URL url = new URL(urlRegister);
                //establish httpURL connection ---- parameters
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String name = params[1];
                String username = params[2];
                String password = params[3];
                // uemail = username;
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                //write information
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");


                }
                httpURLConnection.disconnect();
                Thread.sleep(5000);
                return stringBuilder.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (method.equals("login")) {
            try {
                URL url = new URL(urlLogin);
                //establish httpURL connection ---- parameters
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String username, password;
                username = params[1];
                password = params[2];
                // uemail = username;

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                //write information
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                httpURLConnection.disconnect();
                Thread.sleep(5000);
                //Log.d("Test", "Test 3 pass");
                return stringBuilder.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String json) {
        // super.onPostExecute(aVoid);
        progressDialog.dismiss();

        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
            JSONObject JO = jsonArray.getJSONObject(0);
            String code = JO.getString("code");
            String message = JO.getString("message");

            if (code.equals("reg_true")) {
                Toast.makeText(ctx, message, Toast.LENGTH_LONG).show();
               /* showDialog("Registration Success", message, code);*/
            } else if (code.equals("reg_false")) {
                Toast.makeText(ctx, message, Toast.LENGTH_LONG).show();
               /* showDialog("Registration Failed", message, code);*/
            }
            if (code.equals("login_true")) {
                Toast.makeText(ctx, message, Toast.LENGTH_LONG).show();
               /* showDialog("Login Success", message, code);*/
            } else if (code.equals("login_false")) {
                Toast.makeText(ctx, message, Toast.LENGTH_LONG).show();
                /*showDialog("Login Error", message, code);*/
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

   /* public void showDialog(String title, String message, String code) {
        builder.setTitle(title);
        if (code.equals("reg_true") || code.equals("reg_false")) {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    activity.finish();
                }
            });


        } else if (code.equals("login_false")) {

            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EditText email, password;
                    email = (EditText) activity.findViewById(R.id.usernameRL);
                    password = (EditText) activity.findViewById(R.id.passwordRL);
                    email.setText("");
                    password.setText("");
                    dialog.dismiss();
                }
            });

        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
*/
}
