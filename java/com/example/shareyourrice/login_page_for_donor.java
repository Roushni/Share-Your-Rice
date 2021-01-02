package com.example.shareyourrice;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import java.io.Serializable;

public class login_page_for_donor extends AppCompatActivity {

    TextView text;
    TextView default_Number;
    EditText number;
    Button login;
    Button volunteering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_for_donor);

        text = (TextView) findViewById (R.id.tv1);
        default_Number = (TextView) findViewById (R.id.tv2);
        number = (EditText) findViewById (R.id.editText);
        login = (Button) findViewById (R.id.btn);
        volunteering = (Button) findViewById(R.id.btn2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number.length() == 10) {
                    Intent info_page = new Intent(login_page_for_donor.this, donors_info_submission_page.class);
                    startActivity(info_page);
                }
                else if (number.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill up the box ", Toast.LENGTH_SHORT).show();
                }
                else if (number.length() != 10) {
                    Toast.makeText(getApplicationContext(), "Incorrect Number ", Toast.LENGTH_SHORT).show();
                }
            }

        });

        volunteering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIn_page = new Intent(login_page_for_donor.this, sign_in_page_volunteers.class);
                startActivity(signIn_page);
            }
        });
    }
}


