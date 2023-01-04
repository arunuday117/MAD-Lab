package com.example.co4pg1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class MainActivity extends AppCompatActivity {
    GridView gview;
    int logos[] = {R.drawable.a,R.drawable.b,R.drawable.c};
    String[] names
            ={"BMW","addidas","Be"};
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gview = findViewById(R.id.gview);
        GridView gv = (GridView) findViewById(R.id.gview);
        gv.setAdapter(new ImageAdapter(this));
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                builder.setMessage("Name : "+String.valueOf(names[i]))
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                            }
                        });

                AlertDialog alert = builder.create();

                alert.setTitle("Info Alert"); alert.show();
            }
        });

    }


}
