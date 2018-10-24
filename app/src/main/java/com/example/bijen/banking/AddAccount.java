package com.example.bijen.banking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddAccount extends AppCompatActivity {

    Button button;
    EditText editText, editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Spinner spinner, spinner1, spinner2;
    String un, fn, ph, ei, an, fa, s, c, ui, ac, uf, bn, rb;
    StringBuilder stringBuilder = new StringBuilder();
    Database database;

    String date[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19",
            "20", "21", "22", "23", "24", "25", "26", "27", "28",
            "29", "30"};

    String month[] = {"January", "Feburary", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December"};

    String year[] = {"1990", "1991", "1992", "1993", "1994", "1995", "1996",
            "1997", "1998", "1999", "2000", "2001", "2002", "2003",
            "2004", "2005", "2006", "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014", "2015", "2016", "2017"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        editText = (EditText) findViewById(R.id.edit5);
        editText1 = (EditText) findViewById(R.id.edit6);
        editText2 = (EditText) findViewById(R.id.edit7);
        editText3 = (EditText) findViewById(R.id.edit8);
        editText4 = (EditText) findViewById(R.id.edit9);
        editText5 = (EditText) findViewById(R.id.edit10);
        editText6 = (EditText) findViewById(R.id.edit11);
        editText7 = (EditText) findViewById(R.id.edit12);
        editText8 = (EditText) findViewById(R.id.edit13);
        editText9 = (EditText) findViewById(R.id.edit14);
        editText10 = (EditText) findViewById(R.id.edit15);
        editText11 = (EditText) findViewById(R.id.edit16);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        spinner = (Spinner) findViewById(R.id.spiner);
        spinner1 = (Spinner) findViewById(R.id.spiner1);
        spinner2 = (Spinner) findViewById(R.id.spiner2);
        button = (Button) findViewById(R.id.button3);
        database = new Database(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(AddAccount.this, android.R.layout.simple_spinner_item, date);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(AddAccount.this, android.R.layout.simple_spinner_item, month);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(AddAccount.this, android.R.layout.simple_spinner_item, year);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                stringBuilder.append(date[i]).append(" ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                stringBuilder.append(month[i]).append(" ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                stringBuilder.append(year[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                un = editText.getText().toString();
                fn = editText1.getText().toString();
                ph = editText2.getText().toString();
                ei = editText3.getText().toString();
                an = editText4.getText().toString();
                fa = editText5.getText().toString();
                s = editText6.getText().toString();
                c = editText7.getText().toString();
                ui = editText8.getText().toString();
                ac = editText9.getText().toString();
                uf = editText10.getText().toString();
                bn = editText11.getText().toString();

                int m = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(m);

                if (m == -1) {
                    Toast.makeText(getApplicationContext(), "Gender not Selected", Toast.LENGTH_SHORT).show();
                } else {
                    rb = radioButton.getText().toString();
                }
                if (un.length() == 0 || fn.length() == 0 || stringBuilder.toString().length() == 0 || rb.length() == 0 || ph.length() == 0 || ei.length() == 0 || an.length() == 0 || fa.length() == 0 || s.length() == 0 || c.length() == 0 || ui.length() == 0 || ac.length() == 0 || uf.length() == 0 || bn.length() == 0) {
                    Toast.makeText(getApplicationContext(), " you  must not fill all the fields,  please check again!", Toast.LENGTH_SHORT).show();
                } else if (ph.length() != 10) {
                    Toast.makeText(getApplicationContext(), "Phone number is wrong", Toast.LENGTH_SHORT).show();
                } else if (!ei.contains("@gmail.com")) {
                    Toast.makeText(getApplicationContext(), "Your Email id is wrong", Toast.LENGTH_SHORT).show();
                } else if (an.length() != 12) {
                    Toast.makeText(getApplicationContext(), "Your Aadar card number is wrong", Toast.LENGTH_SHORT).show();
                } else if (ui.length() < 6) {
                    Toast.makeText(getApplicationContext(), "User id so small", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = database.saveData(ui, un, fn, stringBuilder.toString(), rb, ph, ei, an, fa, s, c, ac, uf, bn, 1000);

                    if (result) {
                        Toast.makeText(getApplicationContext(), "You Successfully Add Account", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Not Add Account", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
