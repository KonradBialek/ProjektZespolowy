package com.example.projektzespolowy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projektzespolowy.ui.addPhoto.AddPhotoFragment;
import com.example.projektzespolowy.ui.addPhoto2.AddPhoto2Fragment;
import com.example.projektzespolowy.ui.browser.BrowserFragment;
import com.example.projektzespolowy.ui.home.HomeFragment;
import com.example.projektzespolowy.ui.plantBrowser.PlantBrowserFragment;
import com.example.projektzespolowy.ui.userBrowser.UserBrowserFragment;
import com.example.projektzespolowy.ui.recognition.RecognitionFragment;
import com.example.projektzespolowy.ui.recognition2.Recognition2Fragment;
import com.example.projektzespolowy.ui.recognition3.Recognition3Fragment;
import com.example.projektzespolowy.ui.recognition4.Recognition4Fragment;
import com.example.projektzespolowy.ui.settings.SettingsFragment;
import com.example.projektzespolowy.ui.slideshow.SlideshowFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_browser, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    // do zmiany fragmentów
    public void replaceFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.nav_host_fragment, fragment);
        ft.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    // Obsługa przechodzenia między nawigacjami
    public void onNavigationItemSelected(MenuItem item) {
        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (item.getItemId()) {
            case R.id.nav_browser:
                fragment = new BrowserFragment();
                break;
            case R.id.nav_recognize:
                fragment = new RecognitionFragment();
                break;
            case R.id.nav_add:
                fragment = new AddPhotoFragment();
                break;
            case R.id.nav_settings:
                fragment = new SettingsFragment();
                break;
            case R.id.nav_slideshow:
                fragment = new SlideshowFragment();
                break;
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
//            default:
//                fragment = new SlideshowFragment();
//                break;
        }

        //replacing the fragment
        if (fragment != null) {
            replaceFragment(fragment);
            Toast toast = Toast.makeText(this, "Otwarto profil", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    // Część wyszukiwiarki
    public void SearchUser(View view) {
        final String name = ((EditText)findViewById(R.id.name)).getText().toString();
        Fragment fragment = new UserBrowserFragment();
        replaceFragment(fragment);
    }
    public void SearchPlant(View view) {
        final String name = ((EditText)findViewById(R.id.name)).getText().toString();
        Fragment fragment = new PlantBrowserFragment();
        replaceFragment(fragment);
    }
    public void goBackToSearch(View view) {
        Fragment fragment = new BrowserFragment();
        replaceFragment(fragment);
    }
    public void openProfileActivity(View view) {
        Toast toast = Toast.makeText(this, "Otwarto profil", Toast.LENGTH_LONG);
        toast.show();
    }


    // Część rozpoznawania
    static final int REQUEST_IMAGE_CAPTURE_RECOGNITION = 1;
    static final int GET_FROM_GALLERY_RECOGNITION = 2;
    static final int REQUEST_IMAGE_CAPTURE_ADD = 3;
    static final int GET_FROM_GALLERY_ADD = 4;
    static final int GET_FROM_GALLERY_PROFILE = 5;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Detects request codes
        if(resultCode == Activity.RESULT_OK) {
            Fragment fragment = null;
            ImageView iv_photo = (ImageView) findViewById(R.id.imageView3);
            Uri myUri = data.getData();
            String string = myUri.toString();
            Uri uri = Uri.parse(string);
//            Toast.makeText(this, string, Toast.LENGTH_LONG).show();
            try {
                iv_photo.setImageURI(uri);
            } catch (NullPointerException e)
            {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
            if(requestCode==GET_FROM_GALLERY_RECOGNITION || requestCode==REQUEST_IMAGE_CAPTURE_RECOGNITION)
                fragment = new Recognition2Fragment();
            else if(requestCode==GET_FROM_GALLERY_ADD || requestCode==REQUEST_IMAGE_CAPTURE_ADD)
                fragment = new AddPhoto2Fragment();
            else if(requestCode==GET_FROM_GALLERY_PROFILE);
            if(fragment != null) {
                replaceFragment(fragment);
            }
        }
    }

    public void UploadFromGallery(View view) {
        Intent uploadFromGallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        try {
            startActivityForResult(uploadFromGallery, GET_FROM_GALLERY_RECOGNITION);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    public void TakeAPicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_RECOGNITION);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }
    public void UploadFromGallery_add(View view) {
        Intent uploadFromGallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        try {
            startActivityForResult(uploadFromGallery, GET_FROM_GALLERY_ADD);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    public void TakeAPicture_add(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE_ADD);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }
    // 2
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recognition2);
//        ImageView iv_photo=(ImageView)findViewById(R.id.imageView3);
//        Bundle extras = getIntent().getExtras();
//        Uri myUri = Uri.parse(extras.getString("imageUri"));
//        iv_photo.setImageURI(myUri);
//    }
    public void anotherPicture(View view) {
        finish();
    }

    public void Recognize(View view) {
        Fragment fragment = new Recognition3Fragment();
        replaceFragment(fragment);
//        Intent intent = new Intent(this, Recognition3Activity.class);
//        intent.putExtra("imageUri", getIntent().getExtras().getString("imageUri"));
//        startActivity(intent);
    }

    // 3
    public void Confirm(View view) {
        Fragment fragment = new Recognition4Fragment();
        replaceFragment(fragment);
    }

    // 4
    public void Confirm2(View view) {
        Fragment fragment = new RecognitionFragment();
        replaceFragment(fragment);
    }

    // Część dodania zdjęć
    public void toastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void addPhoto(View view) {
        toastMsg("Photo added");
    }

    // Część ustawień
    public void ChangePassword (View view){
        final String old_password = ((EditText)findViewById(R.id.old_password)).getText().toString();
        final String new_password = ((EditText)findViewById(R.id.new_password)).getText().toString();
        final String retype_new_password = ((EditText)findViewById(R.id.retype_new_password)).getText().toString();
        toastMsg("Password changed");
    }
    public void ChangeDescription (View view){
        final String description = ((EditText)findViewById(R.id.description)).getText().toString();
        toastMsg("Description changed");
    }
    public void AddImage (View view){
        Intent uploadFromGallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        try {
            startActivityForResult(uploadFromGallery, GET_FROM_GALLERY_PROFILE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
        toastMsg("Image added");
    }

    public void ChangeImage (View view){

        toastMsg("Image changed");
    }
    public void DeleteAccount(View view) {
        toastMsg("Account deleted");
    }
}