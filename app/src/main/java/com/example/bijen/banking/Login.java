package com.example.bijen.banking;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button bt3;
    TextView textView;
    EditText et4, et5;
    String e, p, email, password;
    Sqlhelper sqlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt3 = (Button) findViewById(R.id.button2);
        et4 = (EditText) findViewById(R.id.edit3);
        et5 = (EditText) findViewById(R.id.edit4);
        textView = (TextView) findViewById(R.id.text2);
        sqlhelper = new Sqlhelper(this);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                e = et4.getText().toString();
                p = et5.getText().toString();

                Cursor cursor = sqlhelper.getData(e);

                while (cursor.moveToNext()) {
                    email = String.valueOf(cursor.getString(cursor.getColumnIndex("EMAIL_ID")));
                    password = String.valueOf(cursor.getString(cursor.getColumnIndex("PASSWORD")));
                }

                if (!e.equals(email)) {
                    Toast.makeText(getApplicationContext(), "Your email is wrong", Toast.LENGTH_SHORT).show();
                } else if (!p.equals(password)) {
                    Toast.makeText(getApplicationContext(), "Your password is wrong", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent2 = new Intent(Login.this, BankingSystem.class);
                    Toast.makeText(getApplicationContext(), "You are successfully Login", Toast.LENGTH_SHORT).show();
                    startActivity(intent2);
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Forget.class);
                startActivity(intent);
            }
        });
    }
}
