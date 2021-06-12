package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/**
 * Klasa obsługuje zmianę ustawień aplikacji.
 */
public class SettingsActivity extends AppCompatActivity {
//    static final int GET_FROM_GALLERY = 3;

    /**
     * Stworzenie widoku.
     * @param savedInstanceState Informacje do stworzenia widoku.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

//    /**
//     * Pobieranie zdjęcia z galerii.
//     * @param requestCode Kod żądania.
//     * @param resultCode Kod odpowiedzi.
//     * @param data Przesyłane dane.
//     */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        //Detects request codes
//        if (requestCode == GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
//            ImageView iv_photo = (ImageView) findViewById(R.id.imageView3);
//            Uri myUri = data.getData();
//            try {
//                iv_photo.setImageURI(myUri);
//            } catch (NullPointerException e) {
//                e.printStackTrace();
//                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
//            }
//        }
//    }

    /**
     * Wyświetlenie wiadomości.
     * @param msg Treść wiadomości do wyświetlenia.
     */
    public void toastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Obsługa zmiany hasła.
     * @param view Obsługiwany widok.
     * @throws InvalidKeySpecException Wyrzucany, gdy kod dostarczony lub wygenerowany do
     * szyfrowania hasła jest nieprawidłowy.
     * @throws NoSuchAlgorithmException Wyrzucany, gdy podano nieprawidłowy algorytm szyfrowania.
     */
    public void ChangePassword(View view) throws InvalidKeySpecException, NoSuchAlgorithmException {
        final String old_password = ((EditText) findViewById(R.id.old_password)).getText().toString();
        final String new_password = ((EditText) findViewById(R.id.new_password)).getText().toString();
        final String retype_new_password = ((EditText) findViewById(R.id.retype_new_password)).getText().toString();
        if(old_password.length()!=0 && new_password.length()!=0 && retype_new_password.length()!=0
                && new_password.equals(retype_new_password))
            if(Arrays.toString(Storage.Hash(old_password)).equals(Arrays.toString(Storage.passwordhash))
                && new_password.equals(retype_new_password)){
                Storage.passwordhash = Storage.Hash(old_password);
                toastMsg("Password changed");
            }
    }

//    /**
//     * Obsługa zmiany opisu użytkownika.
//     * @param view Obsługiwany widok.
//     */
//    public void ChangeDescription(View view) {
//        final String description = ((EditText) findViewById(R.id.description)).getText().toString();
//        toastMsg("Description changed");
//    }
//
//    /**
//     * Obsługa dodania zdjęcia.
//     * @param view Obsługiwany widok.
//     */
//    public void AddImage(View view) {
//        Intent uploadFromGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        try {
//            startActivityForResult(uploadFromGallery, GET_FROM_GALLERY);
//        } catch (ActivityNotFoundException e) {
//            // display error state to the user
//        }
//        toastMsg("Image added");
//    }
//
//    /**
//     * Obsługa zmiany zdjęcia.
//     * @param view Obsługiwany widok.
//     */
//    public void ChangeImage(View view) {
//
//        toastMsg("Image changed");
//    }

    /**
     * Obsługa usuwania hasła, gdy podano aktualne hasło.
     * @param view Obsługiwany widok.
     * @throws InvalidKeySpecException Wyrzucany, gdy kod dostarczony lub wygenerowany do
     * szyfrowania hasła jest nieprawidłowy.
     * @throws NoSuchAlgorithmException Wyrzucany, gdy podano nieprawidłowy algorytm szyfrowania.
     */
    public void DeleteAccount(View view) throws InvalidKeySpecException, NoSuchAlgorithmException {
        final String old_password = ((EditText) findViewById(R.id.old_password)).getText().toString();
        if(old_password.length()!=0)
            if(Arrays.toString(Storage.Hash(old_password)).equals(Arrays.toString(Storage.passwordhash)))
            {
                Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                toastMsg("Account deleted");
            }
    }

    /**
     * Wyświetlenie menu.
     * @param view Obsługiwany widok.
     */
    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}