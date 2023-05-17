package org.rmj.guanzongroup.gsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class  Activity_Login extends AppCompatActivity {

    TextView CreatNewAccount;
    TextView forgotmypassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

    }
}
