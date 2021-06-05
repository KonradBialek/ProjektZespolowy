package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditPictureActivity extends AppCompatActivity {

    Button menu;
    ImageView plantsPicture;
    TextView plantsName;
    TextView species;
    EditText editableDescription;
    Button confirmChangesBtn;
    Button deletePictureBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_picture);

        menu = (Button) findViewById(R.id.menu);
        plantsPicture = (ImageView) findViewById(R.id.plantsPicture);
        plantsName = (TextView) findViewById(R.id.plantsName);
        species = (TextView) findViewById(R.id.species);
        editableDescription = (EditText) findViewById(R.id.editableDescription);
        confirmChangesBtn = (Button) findViewById(R.id.confirmChangesBtn);
        deletePictureBtn = (Button) findViewById(R.id.deletePictureBtn);

    }



    public void Menu(View view) {
        Intent menuIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(menuIntent);
    }
}