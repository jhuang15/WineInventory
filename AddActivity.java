package com.example.wineinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private Button back;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        back = (Button) findViewById(R.id.backbtn);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AddActivity.this, MainActivity.class));

            }
        });


    }
}
