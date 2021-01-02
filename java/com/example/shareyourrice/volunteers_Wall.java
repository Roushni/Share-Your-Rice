package com.example.shareyourrice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


public class volunteers_Wall extends AppCompatActivity {

    TextView name;
    TextView get_name;
    TextView work;
    TextView get_work;
    TextView email;
    TextView get_email;
    TextView mobile;
    TextView default_number;
    TextView get_mobile;
    TextView notifications;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteers__wall);

        name = (TextView) findViewById(R.id.textView2);
        get_name = (TextView) findViewById(R.id.textView1);
        work = (TextView) findViewById(R.id.textView3);
        get_work = (TextView) findViewById(R.id.textView4);
        email = (TextView) findViewById(R.id.textView5);
        get_email = (TextView)findViewById(R.id.textView6);
        mobile = (TextView) findViewById(R.id.textView7);
        default_number = (TextView) findViewById(R.id.textView8);
        get_mobile = (TextView) findViewById(R.id.textView9);
        notifications = (TextView) findViewById(R.id.textView10);
        logout = (TextView) findViewById(R.id.textView11);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout_page = new Intent(volunteers_Wall.this, MainActivity.class);
                startActivity(logout_page);
            }
        });
    }
}

