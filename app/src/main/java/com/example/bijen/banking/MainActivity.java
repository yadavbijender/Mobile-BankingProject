package com.example.bijen.banking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1, bt2;
    EditText et1, et2, et3;
    String e, u, p;
    Sqlhelper sqlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button1);
        et1 = (EditText) findViewById(R.id.edit);
        et2 = (EditText) findViewById(R.id.edit1);
        et3 = (EditText) findViewById(R.id.edit2);
        sqlhelper = new Sqlhelper(this);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                e = et1.getText().toString();
                u = et2.getText().toString();
                p = et3.getText().toString();

                if (e.length() == 0 || u.length() == 0 || p.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Your email, user name or passwarod are invalid", Toast.LENGTH_SHORT).show();
                } else if (!e.contains("@gmail.com")) {
                    Toast.makeText(getApplicationContext(), "Your email id is wrong", Toast.LENGTH_SHORT).show();
                } else if (p.length() < 6) {
                    Toast.makeText(getApplicationContext(), "password too small", Toast.LENGTH_SHORT).show();
                } else {

                    boolean result = sqlhelper.SaveData(e, u, p);

                    if (result) {
                        Intent intent = new Intent(MainActivity.this, BankingSystem.class);
                        Toast.makeText(getApplicationContext(), "You successfully create your account", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Your account not created", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Login.class);
                startActivity(intent1);
            }
        });
    }
}
