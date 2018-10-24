package com.example.bijen.banking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteAccount extends AppCompatActivity {

    Button button;
    EditText editText;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        editText = (EditText) findViewById(R.id.edit17);
        button = (Button) findViewById(R.id.button4);
        database = new Database(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.deleteData(editText.getText().toString());
                Toast.makeText(getApplicationContext(), "Your Account is Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
