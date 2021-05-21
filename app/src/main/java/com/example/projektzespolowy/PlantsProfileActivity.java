package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlantsProfileActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    //odbieramy wysłaną (w UsersProfileActivity) aktywność

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants_profile);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.minPlantName);

        Intent intent = getIntent();//pobieramy intencję która nas uruchomiła do obiektu intent

        //teraz z tej intencji będziemy pobierać dane które dodatkowo przyszły
        String selectedName = intent.getStringExtra("name");//pobieram przysłany łańcuch o kluczu name i umieszczam go w selectedName
        int selectedImage = intent.getIntExtra("image", 0);//pobieram identyfikator zdjęcia o kluczu image w postaci int,
        // argument defaultValue o wartości 0, oznacza że jakbym nic nie znalazła o takim kluczu w mojej intencji to domyślnie zostanie mi
        //zwrócone 0

        textView.setText(selectedName); //ustawiam w textView to co przyszło
        imageView.setImageResource(selectedImage); //analogicznie

    }
}