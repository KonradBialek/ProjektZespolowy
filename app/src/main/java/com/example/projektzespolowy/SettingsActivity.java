package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
    public void ChangePassword (View view){
        final String old_password = ((EditText)findViewById(R.id.old_password)).getText().toString();
        final String new_password = ((EditText)findViewById(R.id.new_password)).getText().toString();
        final String retype_new_password = ((EditText)findViewById(R.id.retype_new_password)).getText().toString();
//        Intent intent = new Intent(this, ProfileActivity.class);
//        startActivity(intent);
        toastMsg("Password changed");
    }

    public void DeleteAccount(View view) {
//        Intent intent = new Intent(this, ProfileActivity.class);
//        startActivity(intent);
        toastMsg("Account deleted");
    }
}