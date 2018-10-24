package com.example.bijen.banking;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    TextView textView, textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    Database1 database1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textView = (TextView) findViewById(R.id.text1);
        textView1 = (TextView) findViewById(R.id.text2);
        textView2 = (TextView) findViewById(R.id.text3);
        textView3 = (TextView) findViewById(R.id.text4);
        textView4 = (TextView) findViewById(R.id.text5);
        textView5 = (TextView) findViewById(R.id.text6);
        textView6 = (TextView) findViewById(R.id.text7);
        textView7 = (TextView) findViewById(R.id.text8);
        database1 = new Database1(this);
        final StringBuilder stringBuilder = new StringBuilder();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Setting.this, UserAccount.class);
                startActivity(intent1);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Setting.this, UserAccount.class);
                startActivity(intent2);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, Balance.class);
                startActivity(intent);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, Balance.class);
                startActivity(intent);
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, ChangeUserID.class);
                startActivity(intent);
            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, ChangeUserID.class);
                startActivity(intent);
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = database1.getData();
                while (cursor.moveToNext()) {
                    stringBuilder.append(String.valueOf(cursor.getString(cursor.getColumnIndex("COLUMN")))).append("   ");
                    stringBuilder.append(String.valueOf(cursor.getString(cursor.getColumnIndex("NAME")))).append("  ");
                    stringBuilder.append(String.valueOf(cursor.getString(cursor.getColumnIndex("FEEDBACK")))).append("   ");
                    Toast.makeText(getApplicationContext(), stringBuilder, Toast.LENGTH_SHORT).show();
                }
            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = database1.getData();
                while (cursor.moveToNext()) {
                    stringBuilder.append(String.valueOf(cursor.getString(cursor.getColumnIndex("COLUMN")))).append("   ");
                    stringBuilder.append(String.valueOf(cursor.getString(cursor.getColumnIndex("NAME")))).append("  ");
                    stringBuilder.append(String.valueOf(cursor.getString(cursor.getColumnIndex("FEEDBACK")))).append("   ");
                    Toast.makeText(getApplicationContext(), stringBuilder, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
