package com.example.bijen.banking;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Transition extends AppCompatActivity {

    Button button;
    EditText editText, editText1, editText2;
    String ui, ac, am;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        editText = (EditText) findViewById(R.id.edit18);
        editText1 = (EditText) findViewById(R.id.edit19);
        editText2 = (EditText) findViewById(R.id.edit20);
        button = (Button) findViewById(R.id.button5);
        database = new Database(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ui = editText.getText().toString();
                ac = editText1.getText().toString();
                am = editText2.getText().toString();

                Cursor cursor = database.getData(ui);
                while (cursor.moveToNext()) {
                    String amount = String.valueOf(cursor.getString(cursor.getColumnIndex("AMOUNT")));

                    int money = Integer.parseInt(amount);

                    if (money < Integer.parseInt(am)) {
                        Toast.makeText(getApplicationContext(), "Not enough money in Your Account", Toast.LENGTH_SHORT).show();
                    } else {
                        money -= Integer.parseInt(am);
                        database.update1(ui, money);
                        Toast.makeText(getApplicationContext(), "Money Transfered", Toast.LENGTH_SHORT).show();


                        Cursor cursor1 = database.getData1(ac);
                        while (cursor1.moveToNext()) {
                            String string = String.valueOf(cursor.getString(cursor.getColumnIndex("AMOUNT")));

                            int money1 = Integer.parseInt(string);
                            money1 += Integer.parseInt(am);
                            database.update2(ac, money1);
                            Toast.makeText(getApplicationContext(), "Money " + am + "added to your account", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}
