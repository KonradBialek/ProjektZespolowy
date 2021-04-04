package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Recognition2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognition2);
        ImageView iv_photo=(ImageView)findViewById(R.id.imageView3);
        Bundle extras = getIntent().getExtras();
        Uri myUri = Uri.parse(extras.getString("imageUri"));
        iv_photo.setImageURI(myUri);
    }
    public void anotherPicture(View view) {
        finish();
    }

    public void Recognize(View view) {
        Intent intent = new Intent(this, Recognition3Activity.class);
        intent.putExtra("imageUri", getIntent().getExtras().getString("imageUri"));
        startActivity(intent);
    }
}