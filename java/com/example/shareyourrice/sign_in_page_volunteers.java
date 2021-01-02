package com.example.shareyourrice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


public class sign_in_page_volunteers extends AppCompatActivity {

    TextView text1; //email
    TextView text2; //password
    TextView text3; 
    TextView text4; //registration_link
    EditText email;
    EditText password;
    Button sign_in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page_volunteers);

        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        email = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
        sign_in = (Button) findViewById(R.id.button);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent profile_page = new Intent(sign_in_page_volunteers.this, volunteers_Wall.class);
        startActivity(profile_page);
        finish();
            }
        });

        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp_page = new Intent(sign_in_page_volunteers.this, volunteers_signup_page.class);
                startActivity(signUp_page);
            }
        });
    }
}