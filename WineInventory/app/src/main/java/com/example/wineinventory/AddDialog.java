package com.example.wineinventory;

import androidx.appcompat.app.AppCompatDialogFragment;

public class AddDialog extends AppCompatDialogFragment {
/*
    DatabaseHandler myDb;

    private EditText name;
    private EditText type;
    private EditText grape;
    private EditText location;
    private EditText quantity;
    private EditText price;
    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogfragment, null);

        builder.setView(view)
                .setTitle("Create New Data")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String newEntry = name.getText().toString();
                        if(name.length() != 0){
                            boolean insertData=myDb.insertData(newEntry);
                            name.setText("");
                        }else{
                            toastMessage("Enter something in text field");
                        }


                        String name1 = name.getText().toString();
                        String type1 = grape.getText().toString();
                        String grape1 = type.getText().toString();
                        String location1 = location.getText().toString();
                        String quantity1 = quantity.getText().toString();
                        String price1 = price.getText().toString();
                        listener.applyTexts(name1, type1, grape1, location1,quantity1, price1);

                    }
                });

        name = view.findViewById(R.id.etname);
        grape = view.findViewById(R.id.etgrape);
        type = view.findViewById(R.id.ettype);
        location = view.findViewById(R.id.etlocation);
        quantity = view.findViewById(R.id.etquantity);
        price = view.findViewById(R.id.etprice);


        return builder.create();
    }





    private void toastMessage(String message){
        Toast toast=Toast.makeText(getActivity(), message,Toast.LENGTH_SHORT);
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String name1, String type1, String grape1, String location1, String quantity1, String price1);
    }
    */
}