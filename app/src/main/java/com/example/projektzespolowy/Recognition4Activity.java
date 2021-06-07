package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recognition4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognition4);
        ImageView iv_photo = (ImageView) findViewById(R.id.imageView3);
        Bundle extras = getIntent().getExtras();
        Uri myUri = Uri.parse(extras.getString("imageUri"));
        iv_photo.setImageURI(myUri);
    }

    public void Confirm(View view) throws ParseException {
        final String plants_name = ((EditText) findViewById(R.id.plants_name)).getText().toString();
        final Date watering_date = (new SimpleDateFormat("dd-MM-YYYY")).parse(((EditText) findViewById(R.id.watering_date)).getText().toString());
        final int water_freq = Integer.parseInt(((EditText) findViewById(R.id.water_freq)).getText().toString());
        final Date fertilizing_date = (new SimpleDateFormat("dd-MM-YYYY")).parse(((EditText) findViewById(R.id.fertilizing_date)).getText().toString());
        final int fertilizing_freq = Integer.parseInt(((EditText) findViewById(R.id.fertilizing_freq)).getText().toString());

        Storage.plants_name = plants_name;
        Storage.watering_date = watering_date;
        Storage.water_freq = water_freq;
        Storage.fertilizing_date = fertilizing_date;
        Storage.fertilizing_freq = fertilizing_freq;

        // TODO tworzenie profilu rośliny
        finish();
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}