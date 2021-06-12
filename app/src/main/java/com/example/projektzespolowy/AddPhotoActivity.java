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

/**
 * Klasa obsługuje wybór sposobu wprowadzenia zdjęcia rośliny do aplikacji w celu przypisania go do
 * rośliny.
 */
public class AddPhotoActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int GET_FROM_GALLERY = 3;

    /**
     * Stworzenie widoku.
     * @param savedInstanceState Informacje do stworzenia widoku.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);
    }

    /**
     * Pobieranie zdjęcia z galerii.
     * @param requestCode Kod żądania.
     * @param resultCode Kod odpowiedzi.
     * @param data Przesyłane dane.
     */
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

    /**
     * Włączenie galerii.
     * @param view Obsługiwany widok.
     */
    public void UploadFromGallery(View view) {
        Intent uploadFromGallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        try {
            startActivityForResult(uploadFromGallery, GET_FROM_GALLERY);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    /**
     * Włączenie aparatu.
     * @param view Obsługiwany widok.
     */
    public void TakeAPicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    /**
     * Wyświetlenie menu.
     * @param view Obsługiwany widok.
     */
    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}