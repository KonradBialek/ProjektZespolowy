package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Klasa obsługuje wybór funkcjonalności aplikacji.
 */
public class NavigationActivity extends AppCompatActivity {

    /**
     * Stworzenie widoku.
     * @param savedInstanceState Informacje do stworzenia widoku.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

    /**
     * Powrót do poprzedniej aktywnosci.
     * @param view Obsługiwany widok.
     */
    public void GoBack(View view) {
        finish();
    }

    /**
     * Wyświetlenie widoku własnego progilu użytkownika.
     * @param view Obsługiwany widok.
     */
    public void MyProfile(View view) {
       Intent myProfileIntent = new Intent(this, UsersProfileActivity.class);
       //tu chyba trzeba będzie dodać jakieś pobieranie id użytkownika (w sensie mojego id)
        startActivity(myProfileIntent);
    }

    /**
     * Wyświetlenie widoku dodawania zdjęcia.
     * @param view Obsługiwany widok.
     */
    public void AddPhoto(View view) {
        Intent intent = new Intent(this, AddPhotoActivity.class);
        startActivity(intent);
    }

    /**
     * Wyświetlenie widoku wyszukiwarki użytkowników i roślin.
     * @param view Obsługiwany widok.
     */
    public void Search(View view) {
        Intent intent = new Intent(this, BrowserActivity.class);
        startActivity(intent);
    }

    /**
     * Wyświetlenie widoku rozpoznawania rośliny.
     * @param view Obsługiwany widok.
     */
    public void Recognize(View view) {
        Intent intent = new Intent(this, RecognitionActivity.class);
        startActivity(intent);
    }

    /**
     * Wyświetlenie widoku kalendarza.
     * @param view Obsługiwany widok.
     */
    public void Calendar(View view) {
        Intent calendarIntent = new Intent(this, CalendarActivity.class);
        startActivity(calendarIntent);
    }

    /**
     * Wyświetlenie widoku ustawień.
     * @param view Obsługiwany widok.
     */
    public void Settings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class); // tmp
        startActivity(intent);
    }

    /**
     * Wylogowanie użytkownika i powrót do ekranu logowania.
     * @param view Obsługiwany widok.
     */
    public void LogOut(View view) {
        Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /**
     * Wyłączenie aplikacji.
     * @param view Obsługiwany widok.
     */
    public void Exit(View view) {
        finishAffinity();
    }
}