package org.rmj.guanzongroup.gsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.rmj.guanzongroup.gsecurity.Activities.MainActivity;

public class Activity_ForgotPassword extends AppCompatActivity {

    EditText minputEmail;
    Button mretrievepass;
    TextView mtextView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        minputEmail = findViewById(R.id.inputEmail);
        mretrievepass = findViewById(R.id.retrievepass);
        mtextView2 = findViewById(R.id.textView2);

        mretrievepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = minputEmail.getText().toString().trim();
                startActivity(new Intent(getApplicationContext(),Activity_ForgotPassword.class));



                if (TextUtils.isEmpty(email)) {
                    minputEmail.setError("Email is required");
                    return;
                }

            }
        });

    }
}