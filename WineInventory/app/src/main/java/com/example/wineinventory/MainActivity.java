package com.example.wineinventory;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler myDb;

    private Button viewAll;
    private Button search;
    private Button edit;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb= new DatabaseHandler(this);


        viewAll = (Button) findViewById(R.id.viewAllbtn);
        ViewAll();


        search = (Button) findViewById(R.id.searchbtn);
        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
               // startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

        edit = (Button) findViewById(R.id.editdelbtn);
        edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditActivity.class));

            }
        });

        add = (Button) findViewById(R.id.addbtn);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));

            }
        });
    }

    public void ViewAll(){
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = myDb.getAllData();
                if (result.getCount() == 0) {
                    //message
                    showMessage("Error","no data");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()){
                    buffer.append("WineId :"+ result.getString(0)+"\n");
                    buffer.append("Name :"+ result.getString(1)+"\n");
                    buffer.append("Type :"+ result.getString(2)+"\n");
                    buffer.append("Grape :"+ result.getString(3)+"\n");
                    buffer.append("Quantity :"+ result.getString(4)+"\n");
                    buffer.append("Price :"+ result.getString(5)+"\n\n");
                }
                showMessage("Entire Wine List",buffer.toString());
            }
        });
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

