package com.example.bijen.banking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forget extends AppCompatActivity {

    EditText editText, editText1, editText2, editText3, editText4;
    Button button;
    Sqlhelper sqlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        editText = (EditText) findViewById(R.id.edit1);
        editText1 = (EditText) findViewById(R.id.edit2);
        editText2 = (EditText) findViewById(R.id.edit3);
        editText3 = (EditText) findViewById(R.id.edit4);
        editText4 = (EditText) findViewById(R.id.edit5);
        button = (Button) findViewById(R.id.button14);
        sqlhelper = new Sqlhelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText1.getText().toString().equals(editText2.getText().toString())) {
                    if (editText3.getText().toString().equals(editText4.getText().toString())) {
                        sqlhelper.updateData(editText.getText().toString(), editText3.getText().toString());
                        Toast.makeText(getApplicationContext(), "Password Changed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
