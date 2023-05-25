package org.rmj.guanzongroup.gsecurity.Authentication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.rmj.guanzongroup.gsecurity.Adapter.AdapterPersonnel;
import org.rmj.guanzongroup.gsecurity.Dialog.DialogLoad;
import org.rmj.guanzongroup.gsecurity.R;

public class Activity_Login extends AppCompatActivity {
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

        forgotmypassword=findViewById(R.id.forgot);
        forgotmypassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this, Activity_ForgotPassword.class));
            }
        });

        CreatNewAccount=findViewById(R.id.createAcc);
        CreatNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this, Activity_CreateAccount.class ));
            }
        });

    }
    private void setVariable () {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userEdt.getText().toString().isEmpty() && passEdt.getText().toString().isEmpty()) {
                    Toast.makeText(Activity_Login.this, "Could not find Email or Password", Toast.LENGTH_SHORT).show();
                }else if(userEdt.getText().toString().equals("admin") && passEdt.getText().toString().equals("admin")){
                    startActivity(new Intent(Activity_Login.this, AdapterPersonnel.class));
                }
            }
        });
    }
    private void initView() {
        userEdt = findViewById(R.id.inputEmail);
        passEdt = findViewById(R.id.inputPassword);
        loginBtn = findViewById (R.id.login);

    }
}

