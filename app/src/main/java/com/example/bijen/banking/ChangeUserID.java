package com.example.bijen.banking;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeUserID extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4;
    Button button;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_user_id);
        editText1 = (EditText) findViewById(R.id.edit2);
        editText2 = (EditText) findViewById(R.id.edit3);
        editText3 = (EditText) findViewById(R.id.edit4);
        editText4 = (EditText) findViewById(R.id.edit5);
        button = (Button) findViewById(R.id.button13);
        database = new Database(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText1.getText().toString().equals(editText2.getText().toString())) {
                    Cursor cursor = database.getData(editText1.getText().toString());
                    while (cursor.moveToNext()) {
                        String ac = String.valueOf(cursor.getString(cursor.getColumnIndex("ACCOUNT_NO")));
                        if (!editText3.getText().toString().equals(editText4.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "New password is not matched", Toast.LENGTH_SHORT).show();
                        } else if (editText4.length() < 6) {
                            Toast.makeText(getApplicationContext(), "New password is too small", Toast.LENGTH_SHORT).show();
                        } else {
                            database.update3(ac, editText3.getText().toString());
                            Toast.makeText(getApplicationContext(), "Changed UID", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Old Passwrod is not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
