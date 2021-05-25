package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PlantSettingsActivity extends AppCompatActivity {

    Button menu;
    TextView plantsName;
    ImageView plantsAvatar;
    EditText lastWateringDate;
    EditText lastFertilisingDate;
    EditText fertilisingFrequency;
    EditText wateringFrequency;
    Button confirmPlantSettingsBtn;
    Button deletePlantBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_settings);

        menu = (Button) findViewById(R.id.menu);
        plantsName = (TextView) findViewById(R.id.plantsName);
        plantsAvatar = (ImageView) findViewById(R.id.plantsAvatar);
        lastWateringDate = (EditText) findViewById(R.id.lastWateringDate);
        lastFertilisingDate = (EditText) findViewById(R.id.lastFertilisingDate);
        fertilisingFrequency = (EditText) findViewById(R.id.fertilisingFrequency);
        wateringFrequency = (EditText) findViewById(R.id.wateringFrequency);
        confirmPlantSettingsBtn = (Button) findViewById(R.id.confirmPlantSettingsBtn);
        deletePlantBtn = (Button) findViewById(R.id.deletePlantBtn);

    }
}