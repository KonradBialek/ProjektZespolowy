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

public class UsersProfileActivity extends AppCompatActivity {

    Button menu;
    TextView userName;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_profile);

        menu = (Button) findViewById(R.id.menu);
        userName = (TextView) findViewById(R.id.userName);
        gridView = (GridView) findViewById(R.id.gridView);


    }

}