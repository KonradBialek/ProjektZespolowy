package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
    }

    public void SearchUser(View view) {
        final String name = ((EditText) findViewById(R.id.name)).getText().toString();
        Intent intent = new Intent(this, UserBrowserActivity.class);
        startActivity(intent);
    }

    public void SearchPlant(View view) {
        final String name = ((EditText) findViewById(R.id.name)).getText().toString();
        Intent intent = new Intent(this, PlantBrowserActivity.class);
        startActivity(intent);
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}