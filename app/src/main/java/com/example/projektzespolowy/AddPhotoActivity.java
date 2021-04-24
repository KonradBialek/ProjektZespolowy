package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class AddPhotoActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int GET_FROM_GALLERY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Detects request codes
        if (requestCode == GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            try {
                Intent intent = new Intent(this, AddPhoto2Activity.class);
                Uri uri = data.getData();
                intent.putExtra("imageUri", uri.toString());
                startActivity(intent);
            } catch (NullPointerException e) {
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_LONG).show();
            }
        }
//        else if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
//            try {
//                Intent intent = new Intent(this, AddPhoto2Activity.class);
//                Uri uri = null;
//                File file = null;
//                if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M){
//                    uri = intent.getData();
//                    file = new File(uri.getPath());
//                    // now you can upload your image file
//                }else{
//                    // in android version lower than M your method must work
//                }
//                assert file != null;
//                intent.putExtra("imageUri", file.toString());
//                startActivity(intent);
//            } catch (NullPointerException e) {
//                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_LONG).show();
//            }
//        }
    }

    public void UploadFromGallery(View view) {
        Intent uploadFromGallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        try {
            startActivityForResult(uploadFromGallery, GET_FROM_GALLERY);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    public void TakeAPicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}