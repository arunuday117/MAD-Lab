package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class reg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
    }
    public void back(View view){
        if(view.getId()==R.id.button5){
            Toast.makeText(this, "Pleas sign in", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(reg.this,loginpage.class));
        }
        else{
            startActivity(new Intent(reg.this,loginpage.class));
        }

    }
}