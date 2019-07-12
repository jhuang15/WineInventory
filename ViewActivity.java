package com.example.wineinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

    private Button back;
    private Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //when back button is clicked, redirected to main menu actvity
        back = (Button) findViewById(R.id.backbtn);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ViewActivity.this, MainActivity.class));

            }
        });

        //when edit button is clicked, redirected to editactvity
        edit = (Button) findViewById(R.id.editbtn);
        edit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ViewActivity.this, EditActivity.class));

            }
        });

    }
}
