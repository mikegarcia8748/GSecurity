package org.rmj.guanzongroup.gsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {
    private EditText userEdt,passEdt;
    private Button loginBtn;

    TextView CreatNewAccount;
    TextView forgotmypassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setVariable();

        forgotmypassword=findViewById(R.id.forgotpassword);
        forgotmypassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLogin.this,Activity_ForgotPassword.class));
            }
        });

        CreatNewAccount=findViewById(R.id.createAnAccount);
        CreatNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(ActivityLogin.this,registerActivity.class ));
            }
        });

    }
    private void setVariable () {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userEdt.getText().toString().isEmpty() && passEdt.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityLogin.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }else if(userEdt.getText().toString().equals("admin") && passEdt.getText().toString().equals("admin")){
                    startActivity(new Intent(ActivityLogin.this,successlogin.class));
                }
            }
        });
    }
    private void initView() {
        userEdt = findViewById(R.id.inputEmail);
        passEdt = findViewById(R.id.inputPassword);
        loginBtn = findViewById (R.id.login1);

    }
}


