package com.example.wineinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private Button back;
    private Button search;

    private EditText editText; //user input

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //when back button is clicked, redirected to main menu actvity
        back = (Button) findViewById(R.id.backbtn);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SearchActivity.this, MainActivity.class));

            }
        });



        search = (Button) findViewById(R.id.searchbtn);
        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //if item exist in database then redirect activity to view activity.
                startActivity(new Intent(SearchActivity.this, ViewActivity.class));
                //else if display toast message
                //Toast.makeText(getApplicationContext(),"Invalid Item",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
