package com.example.shareyourrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class request_processing_message extends AppCompatActivity {
    TextView thanks_text;
    TextView notification_text;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_processing_message);

        thanks_text = (TextView)findViewById(R.id.textView1);
        notification_text = (TextView)findViewById(R.id.textView2);
        logout = (TextView)findViewById(R.id.textView3);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent logout_page = new Intent(request_processing_message.this,MainActivity.class);
                startActivity(logout_page);
            }
        });
    }
}

