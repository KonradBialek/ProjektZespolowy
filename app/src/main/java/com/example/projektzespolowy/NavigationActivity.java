package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

    public void toastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    public void GoBack(View view) {
        finish();
    }


    public void MyProfile(View view) {
       Intent myProfileIntent = new Intent(this, UsersProfileActivity.class);
       //tu chyba trzeba będzie dodać jakieś pobieranie id użytkownika (w sensie mojego id)
        startActivity(myProfileIntent);
    }

    public void AddPhoto(View view) {
        Intent intent = new Intent(this, AddPhotoActivity.class); // tmp
        startActivity(intent);
    }

    public void Search(View view) {
        Intent intent = new Intent(this, BrowserActivity.class); // tmp
        startActivity(intent);
    }

    public void Recognize(View view) {
        Intent intent = new Intent(this, RecognitionActivity.class); // tmp
        startActivity(intent);
    }

    public void Calendar(View view) {
        Intent calendarIntent = new Intent(this, CalendarActivity.class);
        startActivity(calendarIntent);
    }

    public void Settings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class); // tmp
        startActivity(intent);
    }

    public void LogOut(View view) {
        Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void Exit(View view) {
        finishAffinity();
    }
}