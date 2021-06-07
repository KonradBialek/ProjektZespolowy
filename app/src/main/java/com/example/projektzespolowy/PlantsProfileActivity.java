package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    int[] images = {};

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

        Intent intent = getIntent();
        String selectedName = intent.getStringExtra("name");
        int selectedImage = intent.getIntExtra("image", 0);

        //textView.setText(selectedName); //wywala błędy nwm czemu
        //imageView.setImageResource(selectedImage);

        CustomAdapterPlantsProfile customAdapterPlantsProfile = new CustomAdapterPlantsProfile(images, getApplicationContext());
        gridView.setAdapter(customAdapterPlantsProfile);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedImage = images[i];
                Intent detailsImageIntent = new Intent(getApplicationContext(), DisplayPictureActivity.class);

                detailsImageIntent.putExtra("image",selectedImage);
                startActivity(detailsImageIntent);
            }
        });

    }




    public void Menu(View view) {
        Intent menuIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(menuIntent);
    }
}