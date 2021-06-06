package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Register(View view) throws InvalidKeySpecException, NoSuchAlgorithmException {
        final String username = ((EditText) findViewById(R.id.username)).getText().toString();
        final String password = ((EditText) findViewById(R.id.password)).getText().toString();
        final String password2 = ((EditText) findViewById(R.id.password2)).getText().toString();
        byte[] hash = null;
        if(password.length()!=0 && username.length()!=0 && password.equals(password2)) {
            hash = Storage.Hash(password);
            Intent intent = new Intent(this, NavigationActivity.class);
            Storage.username = username;
            Storage.passwordhash = hash;
            startActivity(intent);
        }
    }

    public void openLogInActivity(View view) {
        finish();
    }
}