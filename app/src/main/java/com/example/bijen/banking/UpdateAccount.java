package com.example.bijen.banking;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateAccount extends AppCompatActivity {

    Button button, button1;
    TextView textView, textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    EditText editText, editText1, editText2, editText3, editText5, editText6, editText7, editText12;
    LinearLayout linearLayout, linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7;
    String un, fn, ph, ei, fa, s, ui;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);

        editText = (EditText) findViewById(R.id.edit5);
        editText1 = (EditText) findViewById(R.id.edit6);
        editText2 = (EditText) findViewById(R.id.edit7);
        editText3 = (EditText) findViewById(R.id.edit8);
        editText5 = (EditText) findViewById(R.id.edit10);
        editText6 = (EditText) findViewById(R.id.edit11);
        editText7 = (EditText) findViewById(R.id.edit13);
        editText12 = (EditText) findViewById(R.id.edit17);
        textView = (TextView) findViewById(R.id.text);
        textView1 = (TextView) findViewById(R.id.text8);
        textView2 = (TextView) findViewById(R.id.text9);
        textView3 = (TextView) findViewById(R.id.text12);
        textView4 = (TextView) findViewById(R.id.text13);
        textView5 = (TextView) findViewById(R.id.text15);
        textView6 = (TextView) findViewById(R.id.text16);
        textView7 = (TextView) findViewById(R.id.text18);
        linearLayout = (LinearLayout) findViewById(R.id.layout);
        linearLayout1 = (LinearLayout) findViewById(R.id.layout1);
        linearLayout2 = (LinearLayout) findViewById(R.id.layout2);
        linearLayout3 = (LinearLayout) findViewById(R.id.layout3);
        linearLayout4 = (LinearLayout) findViewById(R.id.layout4);
        linearLayout5 = (LinearLayout) findViewById(R.id.layout5);
        linearLayout6 = (LinearLayout) findViewById(R.id.layout6);
        linearLayout7 = (LinearLayout) findViewById(R.id.layout7);
        button = (Button) findViewById(R.id.button3);
        button1 = (Button) findViewById(R.id.button4);
        database = new Database(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText12.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                button1.setVisibility(View.GONE);
                linearLayout.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                editText1.setVisibility(View.VISIBLE);
                editText2.setVisibility(View.VISIBLE);
                editText3.setVisibility(View.VISIBLE);
                editText5.setVisibility(View.VISIBLE);
                editText6.setVisibility(View.VISIBLE);
                editText7.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.VISIBLE);
                linearLayout3.setVisibility(View.VISIBLE);
                linearLayout4.setVisibility(View.VISIBLE);
                linearLayout5.setVisibility(View.VISIBLE);
                linearLayout6.setVisibility(View.VISIBLE);
                linearLayout7.setVisibility(View.VISIBLE);
                Cursor cursor = database.getData(editText12.getText().toString());
                while (cursor.moveToNext()) {
                    String uid = String.valueOf(cursor.getString(cursor.getColumnIndex("U_ID")));
                    String uname = String.valueOf(cursor.getString(cursor.getColumnIndex("USER_NAME")));
                    String fname = String.valueOf(cursor.getString(cursor.getColumnIndex("FATHER_NAME")));
                    String phone = String.valueOf(cursor.getString(cursor.getColumnIndex("PHONE_NO")));
                    String email = String.valueOf(cursor.getString(cursor.getColumnIndex("EMAIL_ID")));
                    String address = String.valueOf(cursor.getString(cursor.getColumnIndex("ADDRESS")));
                    String state = String.valueOf(cursor.getString(cursor.getColumnIndex("STATE")));
                    editText7.setText(uid);
                    editText.setText(uname);
                    editText1.setText(fname);
                    editText2.setText(phone);
                    editText3.setText(email);
                    editText5.setText(address);
                    editText6.setText(state);

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                un = editText.getText().toString();
                fn = editText1.getText().toString();
                ph = editText2.getText().toString();
                ei = editText3.getText().toString();
                fa = editText5.getText().toString();
                s = editText6.getText().toString();
                ui = editText7.getText().toString();

                if (un.length() == 0 || fn.length() == 0 || ph.length() == 0 || ei.length() == 0 || fa.length() == 0 || s.length() == 0 || ui.length() == 0) {
                    Toast.makeText(getApplicationContext(), " you  must not fill all the fields,  please check again!", Toast.LENGTH_SHORT).show();
                } else if (ph.length() != 10) {
                    Toast.makeText(getApplicationContext(), "Phone number is wrong", Toast.LENGTH_SHORT).show();
                } else if (!ei.contains("@gmail.com")) {
                    Toast.makeText(getApplicationContext(), "Your Email id is wrong", Toast.LENGTH_SHORT).show();
                } else {
                    database.updateData(ui, un, fn, ph, ei, fa, s);

                    Toast.makeText(getApplicationContext(), "Account updated successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}