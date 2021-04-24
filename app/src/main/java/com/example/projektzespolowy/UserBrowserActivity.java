package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UserBrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_browser);
//        int isVisible = 0;
    }

    public void goBackToSearch(View view) {
        finish();
    }

    public void openProfileActivity(View view) {
        Toast toast = Toast.makeText(this, "Otwarto profil", Toast.LENGTH_LONG);
        toast.show();
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}