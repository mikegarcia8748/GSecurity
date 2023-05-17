package org.rmj.guanzongroup.gsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class  Activity_Login extends AppCompatActivity {

    TextView createAnAccount;
    TextView forgotpassword;
    EditText inputEmail, inputPassword;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotpassword = findViewById(R.id.forgotpassword);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        login = findViewById(R.id.login1);
        createAnAccount = findViewById(R.id.createAnAccount);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this, Activity_ForgotPassword.class));
            }
        });

        createAnAccount = findViewById(R.id.createAnAccount);
        createAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this, Activity_CreateAccount.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = inputEmail.getText().toString();
                String name2 = inputPassword.getText().toString();

                validateinfo(name1, name2);
            }
        });

    }

    private boolean validateinfo(String name1, String name2) {

        if (name1.length() == 0) {
            inputEmail.requestFocus();
            inputEmail.setError("Field Cannot be empty");
            return false;
        }
        else if (!name1.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            inputEmail.requestFocus();
            inputEmail.setError("Enter Valid Email!");
            return false;
        }
        else if (name2.length() < 8 || name2.length() > 16) {
            inputPassword.requestFocus();
            inputPassword.setError("Password must be between 8-16 characters");
            return false;
        }
        return true;
    }
}
