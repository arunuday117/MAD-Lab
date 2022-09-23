package com.example.co1p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {
    public static final String Default = "No values entered";
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }
    public void load(View view){
        SharedPreferences sp = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String user = sp.getString("name","Default");
        String pass = sp.getString("password","Default");
        if(user.equals(Default) || pass.equals(Default)){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
        else{
            username.setText(user);
            password.setText(pass);
            Toast.makeText(this, "Data Found", Toast.LENGTH_SHORT).show();
        }
    }
    public void prev(View view){
        Toast.makeText(this, "Previous", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(this,MainActivity.class);
        startActivity(in);
    }
}
