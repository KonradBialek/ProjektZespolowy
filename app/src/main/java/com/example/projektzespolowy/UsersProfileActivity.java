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

public class UsersProfileActivity extends AppCompatActivity {

    Button menu;
    TextView userName;
    GridView gridView;

    //tutaj tworzę nazwy i zdjęcia z ręki, ale domyślnie w ich miejsce przyjda nam z bazy danych                                    5
    String[] plantsNames = {};
    int[] plantsAvatars = {};

    public static final int PLANTS_PROFILE_ACTIVITY_CODE = 111; //to jest ten kod zwracany przez startowaną aktywność w funkcji wyświetlającej profil rośliny


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_profile);

        menu = (Button) findViewById(R.id.menu);
        userName = (TextView) findViewById(R.id.userName);
        gridView = (GridView) findViewById(R.id.gridView);

        CustomAdapterUsersProfile customAdapterUsersProfile = new CustomAdapterUsersProfile(plantsNames, plantsAvatars, getApplicationContext());
        //tworzymy customowy adapter, stworzony na podstawie tablicy naszych nazw zdjęć oraz na podstawie tablicy zdjęć i kontekstu
        gridView.setAdapter(customAdapterUsersProfile); //ustawienie customowego adaptera na GridView

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){// listener który uruchamia się jak kliknę na któreś zdjęcie
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedName = plantsNames[i];//wybieramy z naszej tablicy nazw i-ty element (i-ta nazwa jest przypisana do i-tego zdjęcia, wdzięki czemu klikając na i-ty element nie musimy
                // pobierać jego nazwy, bo nazwę pobierzemy sobie z tablicy nazw jako i-tą)
                int selectedAvatar = plantsAvatars[i];
                Intent detailsImageIntent = new Intent(getApplicationContext(), PlantsProfileActivity.class);//tworzymy nową intencję
                detailsImageIntent.putExtra("name",selectedName);
                detailsImageIntent.putExtra("avatar",selectedAvatar);
                startActivity(detailsImageIntent);//startujemy naszą aktywność
            }
        });
    }

    public void displayPlantsProfile(View view){



    }







    public void Menu(View view) {
        Intent menuIntent = new Intent(getApplicationContext(), NavigationActivity.class);
        startActivity(menuIntent);
    }

}