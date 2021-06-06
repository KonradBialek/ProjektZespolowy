package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UsersProfileActivity extends AppCompatActivity {

    Button menu;
    TextView userName;
    GridView gridView;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_profile);
        try {
            Bundle extras = getIntent().getExtras();
             name = extras.getString("name");
        } catch (Exception e) {
            name = "username";
        }
        userName = (TextView) findViewById(R.id.userName);
        userName.setText(name);

    }

    public void Menu(View view) {
        Intent menuIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(menuIntent);
    }

    public void openProfileActivity(View view) {
        // ignoruj
    }
}