package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void Register (View view){
        final String username = ((EditText)findViewById(R.id.username)).getText().toString();
        final String password = ((EditText)findViewById(R.id.password)).getText().toString();
        final String password2 = ((EditText)findViewById(R.id.password2)).getText().toString();
        Intent intent = new Intent(this, BrowserActivity.class);
        startActivity(intent);
    }
    public void openLogInActivity(View view){
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
}