package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Klasa obsługuje wprowadzanie danych o roślinie na zdjęciu.
 */
public class AddPhoto2Activity extends AppCompatActivity {

    /**
     * Stworzenie widoku, obsługa zdjęcia.
     * @param savedInstanceState Informacje do stworzenia widoku.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo2);
        // obsługa zdjęcia do wyświetlenia
        ImageView imageView3=(ImageView)findViewById(R.id.imageView3);
        Bundle extras = getIntent().getExtras();
        Uri myUri = Uri.parse(extras.getString("imageUri"));
        imageView3.setImageURI(myUri);
    }

    /**
     * Wyświetlenie wiadomości.
     * @param msg Treść wiadomości do wyświetlenia.
     */
    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * Powrót do wyboru zdjęcia.
     * @param view Obsługiwany widok.
     */
    public void anotherPicture(View view) {
        finish();
    }

    /**
     * Przetwarzanie wprowadzonych danych.
     * @param view Obsługiwany widok.
     */
    public void addPhoto(View view) {
        Storage.plant_species = ((EditText) findViewById(R.id.species)).getText().toString();
        Storage.plant_name = ((EditText) findViewById(R.id.plants_name)).getText().toString();
        Storage.plant_description = ((EditText) findViewById(R.id.description)).getText().toString();
        Bundle extras = getIntent().getExtras();
        Storage.plant_photo = Uri.parse(extras.getString("imageUri"));
        toastMsg("Photo added");

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