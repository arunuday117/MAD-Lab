package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements MainActivity2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return true;
    }

    public boolean onOptionItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if(id == R.id.home){
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.contacts){
            Toast.makeText(this, "contacts", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.about){
            Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.settings){
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.share){
            Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);


    }
}
