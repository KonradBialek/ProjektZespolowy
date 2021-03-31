package com.example.projektzespolowy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PlantRecognitionActivity extends AppCompatActivity {
    // Uri of the selected image
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_recognition);
    }

    /**
     * Callback method responsible for establishing the connection using OkHttp
     */
    public void connectServer(View v){
        // Retrieving the IPv4 address entered by the user as a String variable
        EditText ipv4AddressView = findViewById(R.id.IPAddress);
        String ipv4Address = ipv4AddressView.getText().toString();
        // Retrieving the port number entered by the user as a String variable
        EditText portNumberView = findViewById(R.id.portNumber);
        String portNumber = portNumberView.getText().toString();
        // Building the URL to which the HTTP message will be delivered
        String postUrl= "http://"+ipv4Address+":"+portNumber+"/";

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            // Reading the selected image as a Bitmap
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        } catch (FileNotFoundException e) {
            Log.e("UploadPhoto", "FileNotFoundException");
        } catch (IOException e) {
            Log.e("UploadPhoto", "IOException");
        }

        // Converting the byte stream into a byte array to allow a Bitmap to be sent in the HTTP message
        byte[] byteArray = stream.toByteArray();

        // An instance of the RequestBody class represents the image to be sent
        RequestBody postBodyImage = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image", "androidFlask.jpg", RequestBody.create(MediaType.parse("image/*jpg"), byteArray))
                .build();

        TextView responseText = findViewById(R.id.responseText);
        responseText.setText("Please wait ...");
        // Sending the image to the server
        postRequest(postUrl, postBodyImage);
    }

    public void postRequest(String postUrl, RequestBody postBody) {
        /*
            Instance of the OkHttpClient class is the way to establish HTTP
            connections for sending requests and reading responses
         */
        OkHttpClient client = new OkHttpClient();

        // Creating the HTTP request by mapping the destination URL with the request body
        Request request = new Request.Builder()
                .url(postUrl)
                .post(postBody)
                .build();

         /*
             Sending the request via the instance of the OkHttpClient
             Scheduling the request to be sent in the future using the enqueue() method
          */
        client.newCall(request).enqueue(new Callback() {
            // Called when the request couldn’t be executed due to cancellation, a connectivity problem, or timeout
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                    // Cancel the post on failure
                    call.cancel();

                    // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            e.printStackTrace();
                            TextView responseText = findViewById(R.id.responseText);
                            responseText.setText("Failed to connect to server");
                        }
                    });
                }

            // Called when the HTTP response is successfully returned by the remote server
            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView responseText = findViewById(R.id.responseText);
                        try {
                            // Response from the server is returned using the body() method
                            responseText.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    /**
     * Starts an Intent to select a file, the File Explorer will be opened for selecting an image file
     */
    public void selectImage(View v) {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        // The intent makes a call to a callback method named onActivityResult()
        startActivityForResult(intent, 0);
    }

    /**
     * Retrieving the URI of the selected image
     */
    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (resCode == RESULT_OK && data != null) {
            uri = data.getData();
        }
    }
}