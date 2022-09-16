package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText firstname,lastname;
    private RadioGroup radiogroup;
    private EditText dob,email,phone,country,zip,pass,cpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname=(EditText) findViewById(R.id.firstname);
        lastname=(EditText) findViewById(R.id.lastname);
        radiogroup=(RadioGroup) findViewById(R.id.radioGroup);
        dob=(EditText) findViewById(R.id.dob);
        email=(EditText) findViewById(R.id.email);
        phone=(EditText) findViewById(R.id.phone);
        country=(EditText) findViewById(R.id.country);
        zip=(EditText) findViewById(R.id.zipcode);
        pass=(EditText) findViewById(R.id.pass);
        cpass=(EditText) findViewById(R.id.cpass);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstname.getText().toString().isEmpty() || lastname.getText().toString().isEmpty() || dob.getText().toString().isEmpty()|| email.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || country.getText().toString().isEmpty()|| zip.getText().toString().isEmpty()|| pass.getText().toString().isEmpty() || cpass.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Fields Cannot be empty", Toast.LENGTH_SHORT).show();
                }
                int radioId = radiogroup.getCheckedRadioButtonId();
                if(radioId<1){
                    Toast.makeText(MainActivity.this,"Gender is required",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
