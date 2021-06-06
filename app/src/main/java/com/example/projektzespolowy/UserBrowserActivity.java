package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class UserBrowserActivity extends AppCompatActivity {
    Inflater inflater = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_browser);
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        ConstraintLayout rl = (ConstraintLayout) findViewById(R.id.userlayout1);
        View vi = View.inflate(this,R.layout.userlayout, null);
        TextView tv = (TextView)vi.findViewById(R.id.userName);
        tv.setText(name);
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.userlayout2);
        vi = View.inflate(this,R.layout.userlayout, null);
        tv = (TextView)vi.findViewById(R.id.userName);
        tv.setText(name);
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.userlayout3);
        vi = View.inflate(this,R.layout.userlayout, null);
        tv = (TextView)vi.findViewById(R.id.userName);
        tv.setText(name);
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.userlayout4);
        vi = View.inflate(this,R.layout.userlayout, null);
        tv = (TextView)vi.findViewById(R.id.userName);
        tv.setText(name);
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.userlayout5);
        vi = View.inflate(this,R.layout.userlayout, null);
        tv = (TextView)vi.findViewById(R.id.userName);
        tv.setText(name);
        rl.addView(vi);
        rl = (ConstraintLayout) findViewById(R.id.userlayout6);
        vi = View.inflate(this,R.layout.userlayout, null);
        tv = (TextView)vi.findViewById(R.id.userName);
        tv.setText(name);
        rl.addView(vi);
        findViewById(R.id.textView6).setVisibility(View.GONE);;
    }

    public void goBackToSearch(View view) {
        finish();
    }

    public void openProfileActivity(View view) {
        Intent intent = new Intent(this, UsersProfileActivity.class);
        intent.putExtra("name", getIntent().getExtras().getString("name"));
        startActivity(intent);
        Toast toast = Toast.makeText(this, "Otwarto profil", Toast.LENGTH_LONG);
        toast.show();
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}