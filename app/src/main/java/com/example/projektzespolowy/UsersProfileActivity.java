package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UsersProfileActivity extends AppCompatActivity {

    Button menu;
    TextView userName;
    GridView gridView;

    String[] names = {};
    int[] images = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_profile);

        gridView = findViewById(R.id.gridView);
        userName = findViewById(R.id.userName);

        CustomAdapterUsersProfile customAdapterUsersProfile = new CustomAdapterUsersProfile(names, images, getApplicationContext());
        gridView.setAdapter(customAdapterUsersProfile);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedName = names[i];
                int selectedImage = images[i];
                Intent detailsImageIntent = new Intent(getApplicationContext(), PlantsProfileActivity.class);
                detailsImageIntent.putExtra("name",selectedName);
                detailsImageIntent.putExtra("image",selectedImage);
                startActivity(detailsImageIntent);
            }
        });

    }

    public void Menu(View view) {
        Intent menuIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(menuIntent);
    }

    public void openProfileActivity(View view) {
        // ignoruj
    }
}