package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PlantBrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_browser);
//        int isVisible = 0;
    }

    public void goBackToSearch(View view) {
        finish();
    }

    public void openPlantActivity(View view) {
        Toast toast = Toast.makeText(this, "Otwarto roślinę", Toast.LENGTH_LONG);
        toast.show();
    }
}