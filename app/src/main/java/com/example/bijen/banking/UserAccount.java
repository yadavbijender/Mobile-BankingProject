package com.example.bijen.banking;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserAccount extends AppCompatActivity {

    EditText editText;
    Button button;
    LinearLayout linearLayout, linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9;
    TextView textView, textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18;
    Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        button = (Button) findViewById(R.id.button6);
        editText = (EditText) findViewById(R.id.edit5);
        textView = (TextView) findViewById(R.id.text);
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);
        textView4 = (TextView) findViewById(R.id.text4);
        textView5 = (TextView) findViewById(R.id.text5);
        textView6 = (TextView) findViewById(R.id.text6);
        textView7 = (TextView) findViewById(R.id.text7);
        textView8 = (TextView) findViewById(R.id.text8);
        textView9 = (TextView) findViewById(R.id.text9);
        textView10 = (TextView) findViewById(R.id.text10);
        textView11 = (TextView) findViewById(R.id.text11);
        textView12 = (TextView) findViewById(R.id.text12);
        textView13 = (TextView) findViewById(R.id.text13);
        textView14 = (TextView) findViewById(R.id.text14);
        textView15 = (TextView) findViewById(R.id.text15);
        textView16 = (TextView) findViewById(R.id.text16);
        textView17 = (TextView) findViewById(R.id.text17);
        textView18 = (TextView) findViewById(R.id.text18);
        linearLayout = (LinearLayout) findViewById(R.id.layout);
        linearLayout1 = (LinearLayout) findViewById(R.id.layout1);
        linearLayout2 = (LinearLayout) findViewById(R.id.layout2);
        linearLayout3 = (LinearLayout) findViewById(R.id.layout3);
        linearLayout4 = (LinearLayout) findViewById(R.id.layout4);
        linearLayout5 = (LinearLayout) findViewById(R.id.layout5);
        linearLayout6 = (LinearLayout) findViewById(R.id.layout6);
        linearLayout7 = (LinearLayout) findViewById(R.id.layout7);
        linearLayout8 = (LinearLayout) findViewById(R.id.layout8);
        linearLayout9 = (LinearLayout) findViewById(R.id.layout9);
        database = new Database(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                linearLayout.setVisibility(View.GONE);
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.VISIBLE);
                linearLayout3.setVisibility(View.VISIBLE);
                linearLayout4.setVisibility(View.VISIBLE);
                linearLayout5.setVisibility(View.VISIBLE);
                linearLayout6.setVisibility(View.VISIBLE);
                linearLayout7.setVisibility(View.VISIBLE);
                linearLayout8.setVisibility(View.VISIBLE);
                linearLayout9.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                textView8.setVisibility(View.VISIBLE);
                textView9.setVisibility(View.VISIBLE);
                textView10.setVisibility(View.VISIBLE);
                textView11.setVisibility(View.VISIBLE);
                textView12.setVisibility(View.VISIBLE);
                textView13.setVisibility(View.VISIBLE);
                textView14.setVisibility(View.VISIBLE);
                textView15.setVisibility(View.VISIBLE);
                textView16.setVisibility(View.VISIBLE);
                textView17.setVisibility(View.VISIBLE);
                textView18.setVisibility(View.VISIBLE);
                Cursor cursor = database.getData(editText.getText().toString());
                while (cursor.moveToNext()) {
                    String uname = String.valueOf(cursor.getString(cursor.getColumnIndex("USER_NAME")));
                    String fname = String.valueOf(cursor.getString(cursor.getColumnIndex("FATHER_NAME")));
                    String dateOfBirth = String.valueOf(cursor.getString(cursor.getColumnIndex("DATE_OF_BIRTH")));
                    String gender = String.valueOf(cursor.getString(cursor.getColumnIndex("GENDER")));
                    String phone = String.valueOf(cursor.getString(cursor.getColumnIndex("PHONE_NO")));
                    String email = String.valueOf(cursor.getString(cursor.getColumnIndex("EMAIL_ID")));
                    String aadar = String.valueOf(cursor.getString(cursor.getColumnIndex("AADAR_CARD_NO")));
                    String account = String.valueOf(cursor.getString(cursor.getColumnIndex("ACCOUNT_NO")));
                    String branch = String.valueOf(cursor.getString(cursor.getColumnIndex("BRANCH_NAME")));
                    textView2.setText(uname);
                    textView4.setText(fname);
                    textView6.setText(dateOfBirth);
                    textView8.setText(gender);
                    textView10.setText(phone);
                    textView12.setText(email);
                    textView14.setText(aadar);
                    textView16.setText(account);
                    textView18.setText(branch);
                }
            }
        });
    }
}
