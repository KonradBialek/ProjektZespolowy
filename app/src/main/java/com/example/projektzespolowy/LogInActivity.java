package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void LogIn (View view){
        final String username = ((EditText) findViewById(R.id.username)).getText().toString();
        final String password = ((EditText) findViewById(R.id.password)).getText().toString();
        Intent intent = new Intent(this, NavigationActivity.class); // tmp
        startActivity(intent);
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