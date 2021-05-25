package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class PlantsProfileActivity extends AppCompatActivity {

    Button menu;
    TextView plantsName;
    ImageView plantsAvatar;
    TextView species;
    TextView nextWateringDate;
    TextView wateringFrequency;
    TextView nextFertilisingDate;
    TextView fertilisingFrequency;
    Button addPictureBtn;
    Button editPlantBtn;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants_profile);

        menu = (Button) findViewById(R.id.menu);
        plantsName = (TextView) findViewById(R.id.plantsName);
        plantsAvatar = (ImageView) findViewById(R.id.plantsAvatar);
        species = (TextView) findViewById(R.id.species);
        nextWateringDate = (TextView) findViewById(R.id.nextWateringDate);
        nextFertilisingDate = (TextView) findViewById(R.id.nextFertilisingDate);
        fertilisingFrequency = (TextView) findViewById(R.id.fertilisingFrequency);
        wateringFrequency = (TextView) findViewById(R.id.wateringFrequency);
        addPictureBtn = (Button) findViewById(R.id.addPictureBtn);
        editPlantBtn = (Button) findViewById(R.id.editPlantBtn);
        gridView = (GridView) findViewById(R.id.gridView);

    }
}