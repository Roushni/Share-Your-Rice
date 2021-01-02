package com.example.shareyourrice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class volunteers_signup_page extends AppCompatActivity {
    private static final String TAG = "volunteers_signup_page";

    private TextView username;
    private EditText name;
    private TextView occupation;
    private EditText work;
    private TextView birth_Registration_No;
    private EditText birth_No;
    private TextView mobile_No;
    private TextView default_Number;
    private EditText number;
    private TextView email;
    private TextView password;
    private EditText inputEmail, inputPassword;


    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private Button signup;

    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteers_signup_page);

        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference("user");

        username = (TextView) findViewById (R.id.textView2);
        name = (EditText) findViewById (R.id.editText1);
        occupation = (TextView) findViewById (R.id.textView1);
        work = (EditText) findViewById (R.id.editText2);
        birth_Registration_No = (TextView) findViewById (R.id.textView3);
        birth_No = (EditText) findViewById (R.id.editText3);
        mobile_No = (TextView) findViewById (R.id.textView4);
        default_Number = (TextView) findViewById (R.id.textView5);
        number = (EditText) findViewById (R.id.editText4);
        email = (TextView) findViewById (R.id.textView6);
        inputEmail = (EditText) findViewById (R.id.editText5);
        password = (TextView) findViewById (R.id.textView7);
        inputPassword = (EditText) findViewById (R.id.editText6);
        signup = (Button) findViewById (R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        reference = FirebaseDatabase.getInstance().getReference("user");


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = name.getText().toString().trim();
                final String occupation = work.getText().toString().trim();
                String birth_Registration_No = birth_No.getText().toString().trim();
                final String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                final String mobile_number = mobile_No.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                final Task<AuthResult> authResultTask = auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(volunteers_signup_page.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {
                                    Toast.makeText(volunteers_signup_page.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    if (!name.getText().toString().isEmpty() && !work.getText().toString().isEmpty() && birth_No.length() == 17 && number.length() == 10) {
                                        com.google.firebase.auth.FirebaseUser user=auth.getCurrentUser();
                                        Log.d(TAG, "onComplete: "+user.getUid());
                                        String ID=user.getUid();
                                        reference.child(ID).child("name").setValue(username);
                                        reference.child(ID).child("occupation").setValue(occupation);
                                        reference.child(ID).child("e-mail").setValue(email);
                                        reference.child(ID).child("mobile no").setValue(mobile_number);


                                        Intent profile_page = new Intent(volunteers_signup_page.this, volunteers_Wall.class);
                                        startActivity(profile_page);
                                        finish();
                                    }
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}

