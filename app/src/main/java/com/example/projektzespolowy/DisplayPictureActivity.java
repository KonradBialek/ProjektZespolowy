package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayPictureActivity extends AppCompatActivity {

    Button menu;
    ImageView plantsPicture;
    TextView plantsName;
    TextView species;
    TextView description;
    Button editPictureBtn;
    Button likeBtn;
    TextView numberOfLikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_picture);

        menu = (Button) findViewById(R.id.menu);
        plantsPicture = (ImageView) findViewById(R.id.plantsPicture);
        plantsName = (TextView) findViewById(R.id.plantsName);
        species = (TextView) findViewById(R.id.species);
        description = (TextView) findViewById(R.id.description);
        editPictureBtn = (Button) findViewById(R.id.editPictureBtn);
        likeBtn = (Button) findViewById(R.id.likeBtn);
        numberOfLikes = (TextView) findViewById(R.id.numberOfLikes);
    }


    public void Menu(View view) {
        Intent menuIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(menuIntent);
    }

    public void openPlantActivity(View view) {
        // ignoruj
    }
}