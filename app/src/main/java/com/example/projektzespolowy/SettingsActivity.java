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

public class SettingsActivity extends AppCompatActivity {
    static final int GET_FROM_GALLERY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Detects request codes
        if (requestCode == GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            ImageView iv_photo = (ImageView) findViewById(R.id.imageView3);
            Uri myUri = data.getData();
            try {
                iv_photo.setImageURI(myUri);
            } catch (NullPointerException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void toastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void ChangePassword(View view) {
        final String old_password = ((EditText) findViewById(R.id.old_password)).getText().toString();
        final String new_password = ((EditText) findViewById(R.id.new_password)).getText().toString();
        final String retype_new_password = ((EditText) findViewById(R.id.retype_new_password)).getText().toString();
//        Intent intent = new Intent(this, ProfileActivity.class);
//        startActivity(intent);
        toastMsg("Password changed");
    }

    public void ChangeDescription(View view) {
        final String description = ((EditText) findViewById(R.id.description)).getText().toString();
        toastMsg("Description changed");
    }

    public void AddImage(View view) {
        Intent uploadFromGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        try {
            startActivityForResult(uploadFromGallery, GET_FROM_GALLERY);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
        toastMsg("Image added");
    }

    public void ChangeImage(View view) {

        toastMsg("Image changed");
    }

    public void DeleteAccount(View view) {
//        Intent intent = new Intent(this, ProfileActivity.class);
//        startActivity(intent);
        toastMsg("Account deleted");
    }

    public void Menu(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}