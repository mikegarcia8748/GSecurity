package org.rmj.guanzongroup.gsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class  Activity_Login extends AppCompatActivity {

    TextView CreatNewAccount;
    TextView forgotmypassword;
    EditText inputEmail, inputPassword;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        login = findViewById(R.id.login);


        forgotmypassword=findViewById(R.id.forgotpassword);
        forgotmypassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this,Activity_ForgotPassword.class));
            }
        });

        CreatNewAccount=findViewById(R.id.createAnAccount);
        CreatNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(Activity_Login.this,Activity_CreateAccount.class ));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmailAddress(inputEmail);

            }
        });

    }
    private boolean validateEmailAddress(EditText email){
        String emailInput = this.inputEmail.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Toast.makeText(this, "Valid Email Successfully", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}
