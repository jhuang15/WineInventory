package com.example.wineinventory;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    DatabaseHandler myDb;
    private Button search;
    private EditText et_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        myDb = new DatabaseHandler(this);

        getSupportActionBar().setTitle("Search Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        search = (Button) findViewById(R.id.searchbtn);
        et_search=(EditText) findViewById(R.id.et_search);
        //call search method
        search();
    }
    public void search(){
        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Cursor result = myDb.search(et_search.getText().toString());
                if (result.getCount() == 0) {
                    Toast toast = Toast.makeText(SearchActivity.this, "Data Not Found", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    if (result.moveToFirst()) {
                        String str=result.getString(result.getColumnIndex("content"));
                        Intent intent = new Intent(SearchActivity.this, ViewActivity.class);
                        intent.putExtra("name",str);
                        startActivity(intent);
                       // StringBuffer buffer = new StringBuffer();
                        //while (result.moveToNext()) {
                        //    buffer.append("wineId :" + result.getString(0) + "\n");
                        //    buffer.append("name :" + result.getString(1) + "\n");
                         //   buffer.append("type :" + result.getString(2) + "\n");
                         //   buffer.append("grape :" + result.getString(3) + "\n");
                         //   buffer.append("location :" + result.getString(4) + "\n");
                         //   buffer.append("quantity :" + result.getString(5) + "\n\n");
                       // }

                        //showMessage("Wine Details", buffer.toString());
                    }
                }
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

