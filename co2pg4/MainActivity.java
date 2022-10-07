package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);
        img1.setOnClickListener(this::OnClick);
        img2.setOnClickListener(this::OnClick);
    }

    private void OnClick(View view) {
        if(view.getId()==R.id.imageView){
            img1.setVisibility(view.GONE);
            img2.setVisibility(view.VISIBLE);
        }
        else{
            img1.setVisibility(view.VISIBLE);
            img2.setVisibility(view.GONE);
        }
    }
}
