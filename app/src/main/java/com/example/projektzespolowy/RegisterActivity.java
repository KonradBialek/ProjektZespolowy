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

/**
 * Klasa obsługuje rejestrację do aplikacji.
 */
public class RegisterActivity extends AppCompatActivity {

    /**
     * Stworzenie widoku.
     * @param savedInstanceState Informacje do stworzenia widoku.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    /**
     * Rejestracja do aplikacji.
     * @param view Obsługiwany widok.
     * @throws InvalidKeySpecException Wyrzucany, gdy kod dostarczony lub wygenerowany do
     * szyfrowania hasła jest nieprawidłowy.
     * @throws NoSuchAlgorithmException Wyrzucany, gdy podano nieprawidłowy algorytm szyfrowania.
     */
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
    /**
     * Powrót do widoku logowania.
     * @param view Obsługiwany widok.
     */
    public void openLogInActivity(View view) {
        finish();
    }
}