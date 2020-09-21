package com.example.vmac.WatBot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    // these are the global variables
    Spinner classSpinner, divSpinner;
    // string variable to store selected values
    String selectedClass, selectedDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        classSpinner = (Spinner) findViewById(R.id.classSpinner);
        divSpinner = (Spinner) findViewById(R.id.divSpinner);

        // Class Spinner implementing onItemSelectedListener
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass)
                {
                    case "Class 1":
                        // assigning div item list defined in XML to the div Spinner
                        divSpinner.setAdapter(new ArrayAdapter<String>(Admin.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_1)));
                        break;

                    case "Class 2":
                        divSpinner.setAdapter(new ArrayAdapter<String>(Admin.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_2)));
                        break;

                    case "Class 3":
                        divSpinner.setAdapter(new ArrayAdapter<String>(Admin.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_3)));
                        break;

                    case "Class 4":
                        divSpinner.setAdapter(new ArrayAdapter<String>(Admin.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.items_div_class_4)));
                        break;
                }

                //set divSpinner Visibility to Visible
                divSpinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        // Div Spinner implementing onItemSelectedListener
        divSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedDiv = parent.getItemAtPosition(position).toString();
                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                Toast.makeText(Admin.this, "\n Class: \t " + selectedClass +
                        "\n Div: \t" + selectedDiv, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }

        });

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                //finish();
            }
        });



    }
}
