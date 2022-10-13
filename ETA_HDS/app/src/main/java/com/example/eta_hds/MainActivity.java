package com.example.eta_hds;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    private String currentPhotoPath;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_ETA_HDS);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageView);
        ActivityResultLauncher<String> gallery = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        img.setImageURI(result);
                    }
                });
        ActivityResultLauncher<String> storagePermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(),
                result -> {
                    if (result) {
                        gallery.launch("image/*");
                    } else {
                        Toast.makeText(MainActivity.this, "Storage Permission required", Toast.LENGTH_SHORT).show();
                    }
                });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storagePermission.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        });
        ActivityResultLauncher<Uri> photo = registerForActivityResult(new ActivityResultContracts.TakePicture(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if(result){
                    img.setImageURI(imageUri);
                }
            }
        });
        ActivityResultLauncher<String> cameraPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(),
                result -> {
                    if (result) {
                        String fileName = "img";
                        File storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                        try{
                            File imageFile = File.createTempFile(fileName,".jpg",storageDirectory);
                            currentPhotoPath = imageFile.getAbsolutePath();
                            imageUri = FileProvider.getUriForFile(MainActivity.this,"com.example.eta_hds.fileprovider",imageFile);
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                            photo.launch(imageUri);
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Camera Permission required", Toast.LENGTH_SHORT).show();
                    }
                });
        ActivityResultLauncher<String> npermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(),
                result -> {
                    if (result) {
                        Toast.makeText(MainActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity.this, "Permission required", Toast.LENGTH_SHORT).show();
                    }
                });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraPermission.launch(Manifest.permission.CAMERA);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                npermission.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
        });
    }
}