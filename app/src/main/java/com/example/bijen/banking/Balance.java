package com.example.bijen.banking;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Balance extends AppCompatActivity {

    EditText editText;
    Button button;
    LinearLayout linearLayout, linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    TextView textView, textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        button = (Button) findViewById(R.id.button7);
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
        linearLayout = (LinearLayout) findViewById(R.id.layout);
        linearLayout1 = (LinearLayout) findViewById(R.id.layout1);
        linearLayout2 = (LinearLayout) findViewById(R.id.layout2);
        linearLayout3 = (LinearLayout) findViewById(R.id.layout3);
        linearLayout4 = (LinearLayout) findViewById(R.id.layout4);
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
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                textView8.setVisibility(View.VISIBLE);

                Cursor cursor = database.getData(editText.getText().toString());
                while (cursor.moveToNext()) {
                    String uname = String.valueOf(cursor.getString(cursor.getColumnIndex("USER_NAME")));
                    String account = String.valueOf(cursor.getString(cursor.getColumnIndex("ACCOUNT_NO")));
                    String amount = String.valueOf(cursor.getString(cursor.getColumnIndex("AMOUNT")));
                    String branch = String.valueOf(cursor.getString(cursor.getColumnIndex("USER_NAME")));
                    textView2.setText(uname);
                    textView4.setText(account);
                    textView6.setText(branch);
                    textView8.setText(amount);

                }
            }
        });
    }
}
