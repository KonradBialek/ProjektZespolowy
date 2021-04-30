package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class LogInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void LogIn (View view) throws InvalidKeySpecException, NoSuchAlgorithmException {
        final String username = ((EditText) findViewById(R.id.username)).getText().toString();
        final String password = ((EditText) findViewById(R.id.password)).getText().toString();
        byte[] hash = null;
        if(password.length()!=0) {
            hash = Hash(password);
            Toast.makeText(this, new String(hash), Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(this, NavigationActivity.class); // tmp
        startActivity(intent);
    }
    public void openRegisterActivity(View view){
        // zmienić RegisterActivity na SettingsActivity, BrowserActivity, AddPhotoActivity, RecognitionActivity
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void openPlantRecognitionActivity(View view){
        Intent intent = new Intent(this, PlantRecognitionActivity.class);
        startActivity(intent);
    }

    public byte[] Hash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        return factory.generateSecret(spec).getEncoded();
    }
}