package com.example.co1p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void save(View view) {
        SharedPreferences sp = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("name",username.getText().toString());
        ed.putString("password",password.getText().toString());
        ed.commit();
        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }
    public void next(View view){
        Toast.makeText(this, "Next page", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(this,ActivityB.class);
        startActivity(in);
    }
}
