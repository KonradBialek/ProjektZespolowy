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


    public void Menu(View view) {
        Intent menuIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(menuIntent);
    }

}