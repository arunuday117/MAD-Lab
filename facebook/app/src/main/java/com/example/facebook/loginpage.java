package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
    }
    public void nextPage(View view){
        if(view.getId()==R.id.button){
            Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(loginpage.this,profile.class));
        }
        else{
            startActivity(new Intent(loginpage.this,reg.class));
        }
    }
}