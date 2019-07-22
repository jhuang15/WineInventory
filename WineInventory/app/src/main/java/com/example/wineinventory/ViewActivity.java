package com.example.wineinventory;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {
    DatabaseHandler myDb;

    private Button edit;
    private TextView name1, type, grape, location, quantity, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        myDb = new DatabaseHandler(this);

        getSupportActionBar().setTitle("View Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name1 = (TextView) findViewById(R.id.tvname);
        type = (TextView) findViewById(R.id.tvtype);
        grape = (TextView) findViewById(R.id.tvgrape);
        location = (TextView) findViewById(R.id.tvlocation);
        quantity = (TextView) findViewById(R.id.tvquantity);
        price = (TextView) findViewById(R.id.tvprice);


        Cursor result = myDb.getAllData();
        if (result.getCount() == 0) {
            Toast toast = Toast.makeText(ViewActivity.this, "Error", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        String name = getIntent().getExtras().getString("name");
        StringBuffer buffer = new StringBuffer();

        while (result.moveToNext()) {
            name1.setText(buffer.append("name :" + result.getString(1)));
            type.setText(buffer.append("type :" + result.getString(2)));
            grape.setText(buffer.append("grape :" + result.getString(3)));
            location.setText(buffer.append("location :" + result.getString(4)));
            quantity.setText(buffer.append("quantity :" + result.getString(5)));
            price.setText(buffer.append("price :" + result.getString(6)));
            //buffer.append("wineId :" + result.getString(0) + "\n");
        }

        edit = (Button) findViewById(R.id.editbtn);
        edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ViewActivity.this, EditActivity.class));


            }
        });
    }
}
    // Cursor result = myDb.getAllData();
    //if (result.getCount() == 0) {
    //   showMessage("Error: no data found");
//
    //} else {
    //  while (result.moveToNext()) {
    //     name = (TextView) findViewById(R.id.tvname);
    //   name.setText(result.getString(1));






/*
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menubar, menu);
            return true;
        }

        public boolean onOptionItemsSelected (MenuItem item){
            int id = item.getItemId();

            switch (item.getItemId()) {
                case R.id.menu:
                    Intent menuintent = new Intent("android.intent.action.MAIN");
                    this.startActivity(menuintent);
                    break;
                case R.id.view:
                    Intent viewintent = new Intent("android.intent.action.MAIN");
                    this.startActivity(viewintent);
                    break;
                case R.id.edit:
                    Intent editintent = new Intent(this, EditActivity.class);
                    this.startActivity(editintent);
                    break;
                case R.id.search:
                    Intent searchintent = new Intent(this, SearchActivity.class);
                    this.startActivity(searchintent);
                    break;
                case R.id.add:
                    Intent addintent = new Intent(this, AddActivity.class);
                    this.startActivity(addintent);
                    break;
                default:
                    return super.onOptionsItemSelected(item);
            }
            return true;
        }
    }
    */


