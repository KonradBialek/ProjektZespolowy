package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.net.ssl.HttpsURLConnection;

public class LogInActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

    }

    public void LogIn (View view) throws InvalidKeySpecException, NoSuchAlgorithmException {
        final String username = ((EditText) findViewById(R.id.username)).getText().toString();
        final String password = ((EditText) findViewById(R.id.password)).getText().toString();
        byte[] hash = null;
        if(password.length()!=0 && username.length()!=0) {
            hash = Storage.Hash(password);
            if(username.equals("python") && Arrays.toString(hash).equals(Arrays.toString(Storage.Hash("python123")))) {
                Intent intent = new Intent(this, NavigationActivity.class);
                startActivity(intent);
            }
        }

//// Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="https://192.168.1.12:5000/fertilizing_dates?user_ID=1";
//
//// Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(LogInActivity.this, response.toString(),Toast.LENGTH_LONG).show();
//                        Toast.makeText(LogInActivity.this, "OK",Toast.LENGTH_LONG).show();
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(LogInActivity.this, error.getMessage(),Toast.LENGTH_LONG).show();
//                Toast.makeText(LogInActivity.this, "blad",Toast.LENGTH_LONG).show();
//            }
//        });
//
//// Add the request to the RequestQueue.
//        queue.add(stringRequest);

    }
    public void openRegisterActivity(View view){
        // zmienić RegisterActivity na SettingsActivity, BrowserActivity, AddPhotoActivity, RecognitionActivity
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void openPlantRecognitionActivity(View view){
        Intent intent = new Intent(this, PlantRecognitionActivity.class);
        startActivity(intent);
    }
}