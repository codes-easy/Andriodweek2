package com.example.andriodweek2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent>cameraActivityLauncher;
    static int My_Camera_Request_code = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ImageView photo = findViewById(R.id.photo);
        cameraActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                // functionality of image
                if(result.getResultCode()== RESULT_OK){
                Bitmap image = result.getData().getParcelableExtra("data");
                photo.setImageBitmap(image);
                }}
        });

        Button cameraButton = findViewById(R.id.camera);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // checking for permssion for opening camera app
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraActivityLauncher.launch(intent);

//                    if (intent.resolveActivity(getPackageManager()) != null)
//                        cameraActivityLauncher.launch((intent));

                }else {

                    requestPermissions(new String[]{Manifest.permission.CAMERA}, My_Camera_Request_code);
                }
            }
        });

    }
}