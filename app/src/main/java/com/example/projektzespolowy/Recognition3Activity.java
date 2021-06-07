package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Recognition3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognition3);
        ImageView iv_photo=(ImageView)findViewById(R.id.imageView3);
        Bundle extras = getIntent().getExtras();
        Uri myUri = Uri.parse(extras.getString("imageUri"));
        iv_photo.setImageURI(myUri);
        TextView tv = (TextView)findViewById(R.id.species);
        tv.setText(Storage.plant_species);
    }

    public void anotherPicture(View view) {
        finish();
    }

    public void Confirm(View view) {
        Intent intent = new Intent(this, Recognition4Activity.class);
        intent.putExtra("imageUri", getIntent().getExtras().getString("imageUri"));
        startActivity(intent);
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}