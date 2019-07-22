package com.example.wineinventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity  {
   // implements AddDialog.ExampleDialogListener

    DatabaseHandler  myDb;

     EditText name,type,grape,location,quantity,price;
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);



        name = (EditText) findViewById(R.id.etname);
        type = (EditText) findViewById(R.id.ettype);
        grape = (EditText) findViewById(R.id.etgrape);
        location = (EditText) findViewById(R.id.etlocation);
        quantity = (EditText) findViewById(R.id.etquantity);
        price = (EditText) findViewById(R.id.etprice);
        button = (Button) findViewById(R.id.button);

        AddData();

    }

    public void AddData() {
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myDb = new DatabaseHandler(AddActivity.this);
                  myDb.insertData(name.getText().toString(),
                        type.getText().toString(),
                        grape.getText().toString(),
                        location.getText().toString(),
                        quantity.getText().toString(),
                        price.getText().toString());

                Intent intent=new Intent(AddActivity.this,ViewActivity.class);
                startActivity(intent);


            }
        });
    }

/*
                    boolean insertData=myDb.insertData(name.toString());

                    Bundle bundle = new Bundle();
                    bundle.putString("name",name.getText().toString());
                    bundle.putString("type",type.getText().toString());
                    bundle.putString("grape",grape.getText().toString());
                    bundle.putString("location",location.getText().toString());
                    bundle.putString("quantity",quantity.getText().toString());
                    bundle.putString("price",price.getText().toString());


                    if(insertData == true){
                        Toast.makeText(AddActivity.this,"Data Successfully Inserted", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(AddActivity.this,ViewActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }else{
                        Toast.makeText(AddActivity.this,"Error", Toast.LENGTH_SHORT).show();
                    }

                }
        });

    }


    public void openDialog() {
        AddDialog exampleDialog = new AddDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String name1, String type1, String grape1, String location1, String quantity1, String price1) {
        name.setText("Name: "+name1);
        type.setText("Type: "+type1);
        grape.setText("Grape: "+grape1);
        location.setText("Location: "+location1);
        quantity.setText("Quantity: "+quantity1);
        price.setText("Price: "+price1);
    }
*/

}