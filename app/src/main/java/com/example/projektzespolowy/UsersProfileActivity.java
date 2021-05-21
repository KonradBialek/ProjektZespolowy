package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class UsersProfileActivity extends AppCompatActivity {

    GridView gridView;
    //tutaj tworzę nazwy i zdjęcia roślin z ręki, ale domyślnie w ich miejsce przyjda nam z bazy danych
    String[] names = {"image1", "image2", "image3", "image4", "image5", "image6", "image7", "image8", "image9", "image10", "image11","image12","image13","image14","image15","image16" };
    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_profile);
        gridView = findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter(names, images, getApplicationContext());
        gridView.setAdapter(customAdapter);

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