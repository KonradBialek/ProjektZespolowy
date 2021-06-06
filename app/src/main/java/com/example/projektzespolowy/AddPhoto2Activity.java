package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddPhoto2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo2);
        ImageView imageView3=(ImageView)findViewById(R.id.imageView3);
        Bundle extras = getIntent().getExtras();
        Uri myUri = Uri.parse(extras.getString("imageUri"));
        imageView3.setImageURI(myUri);
    }
    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    public void anotherPicture(View view) {
        finish();
    }

    public void addPhoto(View view) {
        Storage.plant_species = ((EditText) findViewById(R.id.species)).getText().toString();
        Storage.plant_name = ((EditText) findViewById(R.id.plants_name)).getText().toString();
        Storage.plant_description = ((EditText) findViewById(R.id.description)).getText().toString();
        Bundle extras = getIntent().getExtras();
        Storage.plant_photo = Uri.parse(extras.getString("imageUri"));
        toastMsg("Photo added"); // todo addphoto

    }

    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}