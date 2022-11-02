package com.example.arrayadap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listviews);

        String[] names = new String[]{"qweqwr","QWER","SDFSDFS","CVBCVB","ufkjndf","svojnldkfn",
                "sdgsdfgjdfg","xcbvcvbc","sdfsdfsdf","sdfsdfsdfsd","sdfsdf","zxxbdbdfb","xcvxbtefb","xcvxcvxcbxcb"
                ,"sdfsdfs","sdfsdfsdf","xcbcvbcvbcvbn"
        };

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                         @Override
                                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                              String value = listView.getAdapter().getItem(i).toString();
                                             Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                                             intent.putExtra("name",value);
                                             startActivity(intent);
                                         }
                                     }
        );





    }
}
