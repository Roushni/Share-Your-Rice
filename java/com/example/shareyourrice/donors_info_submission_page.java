package com.example.shareyourrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class donors_info_submission_page extends AppCompatActivity {

    TextView location_text;
    EditText location;
    TextView area_text;
    EditText area;
    TextView type_food;
    EditText food_type_enter;
    TextView food_amount_text;
    EditText food_amount;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donors_info_submission_page);

        location_text = (TextView) findViewById(R.id.textView1);
        location = (EditText) findViewById(R.id.editText);
        food_amount_text = (TextView) findViewById(R.id.textView2);
        food_amount = (EditText) findViewById(R.id.editText2);
        area_text = (TextView) findViewById(R.id.textView3);
        area = (EditText) findViewById(R.id.editText3);
        type_food = (TextView) findViewById(R.id.textView4);
        food_type_enter = (EditText) findViewById(R.id.editText4);
        submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!location.getText().toString().isEmpty() && !food_amount.getText().toString().isEmpty() && !area.getText().toString().isEmpty() &&!food_type_enter.getText().toString().isEmpty()) {
                    Intent processing_page = new Intent(donors_info_submission_page.this,request_processing_message.class);
                    startActivity(processing_page);
                }
                else
                    Toast.makeText(getApplicationContext(), "Please fill up the box ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

