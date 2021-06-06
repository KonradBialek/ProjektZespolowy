package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlantBrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast toast = Toast.makeText(this, "Otwarto roślinę", Toast.LENGTH_LONG);
        toast.show();
        setContentView(R.layout.activity_plant_browser);
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        ConstraintLayout rl = (ConstraintLayout) findViewById(R.id.plantlayout1);
        View vi = View.inflate(this,R.layout.plantlayout, null);
        TextView tv = (TextView)vi.findViewById(R.id.species);
        TextView tv1 = (TextView)vi.findViewById(R.id.plantsName);
        tv.setText(name);
        tv1.setText(random());
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.plantlayout2);
        vi = View.inflate(this,R.layout.plantlayout, null);
        tv = (TextView)vi.findViewById(R.id.species);
        tv1 = (TextView)vi.findViewById(R.id.plantsName);
        tv.setText(name);
        tv1.setText(random());
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.plantlayout3);
        vi = View.inflate(this,R.layout.plantlayout, null);
        tv = (TextView)vi.findViewById(R.id.species);
        tv1 = (TextView)vi.findViewById(R.id.plantsName);
        tv.setText(name);
        tv1.setText(random());
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.plantlayout4);
        vi = View.inflate(this,R.layout.plantlayout, null);
        tv = (TextView)vi.findViewById(R.id.species);
        tv1 = (TextView)vi.findViewById(R.id.plantsName);
        tv.setText(name);
        tv1.setText(random());
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.plantlayout5);
        vi = View.inflate(this,R.layout.plantlayout, null);
        tv = (TextView)vi.findViewById(R.id.species);
        tv1 = (TextView)vi.findViewById(R.id.plantsName);
        tv.setText(name);
        tv1.setText(random());
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.plantlayout6);
        vi = View.inflate(this,R.layout.plantlayout, null);
        tv = (TextView)vi.findViewById(R.id.species);
        tv1 = (TextView)vi.findViewById(R.id.plantsName);
        tv.setText(name);
        tv1.setText(random());
        rl.addView(vi);
        findViewById(R.id.textView6).setVisibility(View.GONE);
    }

    public void goBackToSearch(View view) {
        finish();
    }

    public void openPlantActivity(View view) {
        Intent intent = new Intent(this, DisplayPictureActivity.class);
        intent.putExtra("name", getIntent().getExtras().getString("name"));
        startActivity(intent);
        Toast toast = Toast.makeText(this, "Otwarto roślinę", Toast.LENGTH_LONG);
        toast.show();
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(12);
        char tempChar;
        for (int i = 0; i < randomLength; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }
}