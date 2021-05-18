package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class LogInActivity extends AppCompatActivity {
    private TextView textView;
    private static String ip = "192.168.1.101";
    private static String port = "1433";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "testDatabase";
    private static String username = "test";
    private static String password = "test";
    private static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;
    private Connection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        textView = findViewById(R.id.textView);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username,password);
            textView.setText("SUCCESS");
            Toast.makeText(this, "SUCCESS", Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            textView.setText("ERROR");
            Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            e.printStackTrace();
            textView.setText("FAILURE");
            Toast.makeText(this, "FAILURE", Toast.LENGTH_LONG).show();
        }
    }
    public void sqlButton(View view){
        if (connection!=null){
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from TEST_TABLE;");
                while (resultSet.next()){
                    textView.setText(resultSet.getString(1));
                }
                Toast.makeText(this, "działa", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            textView.setText("Connection is null");
            Toast.makeText(this, "Connection is null", Toast.LENGTH_LONG).show();
        }
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