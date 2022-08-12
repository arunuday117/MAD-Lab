package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText num1,num2;
    private Button sum;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1= (EditText) findViewById(R.id.firstnum);
        num2= (EditText) findViewById(R.id.secondnum);
        sum= (Button) findViewById(R.id.add);
        result= (TextView) findViewById(R.id.result);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1,n2,res;
                n1= Integer.parseInt(num1.getText().toString());
                n2= Integer.parseInt(num2.getText().toString());
                res=n1+n2;
                result.setText(String.valueOf(res));
            }
        });
    }
}