package com.example.shareyourrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class notifications extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        text = (TextView) findViewById (R.id.tv1);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent donors_information_page = new Intent(notifications.this, get_info.class);
                    startActivity(donors_information_page);
                }
        });

    }
}
