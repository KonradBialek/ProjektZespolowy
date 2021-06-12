package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Klasa obsługuje wyszukanie użytkownika lub rośliny na podstawie podanej nazwy lub gatunku.
 */
public class BrowserActivity extends AppCompatActivity {

    /**
     * Stworzenie widoku.
     * @param savedInstanceState Informacje do stworzenia widoku.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
    }

    /**
     * Wyszukiwanie użytkownika na podstawie otrzymanej nazwy.
     * @param view Obsługiwany widok.
     */
    public void SearchUser(View view) {
        final String name = ((EditText) findViewById(R.id.name)).getText().toString();
        Intent intent = new Intent(this, UserBrowserActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    /**
     * Wyszukiwanie rośliny w danym gatunku na podstawie otrzymanej nazwy gatunku.
     * @param view Obsługiwany widok.
     */
    public void SearchPlant(View view) {
        final String name = ((EditText) findViewById(R.id.name)).getText().toString();
        Intent intent = new Intent(this, PlantBrowserActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
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