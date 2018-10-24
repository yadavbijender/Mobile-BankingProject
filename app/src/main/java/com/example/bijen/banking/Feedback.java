package com.example.bijen.banking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    EditText editText;
    RatingBar ratingBar;
    Button button;
    Database1 database1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editText = (EditText) findViewById(R.id.edit);
        ratingBar = (RatingBar) findViewById(R.id.rating);
        button = (Button) findViewById(R.id.button12);
        database1 = new Database1(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = database1.saveData(editText.getText().toString(), ratingBar.getRating());

                    if (result) {
                        Toast.makeText(getApplicationContext(), "Feedback Saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Feedback not Saved", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
