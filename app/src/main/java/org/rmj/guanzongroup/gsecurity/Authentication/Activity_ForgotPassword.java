package org.rmj.guanzongroup.gsecurity.Authentication;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import org.rmj.guanzongroup.gsecurity.R;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMForgotPassword;

public class Activity_ForgotPassword extends AppCompatActivity {

    EditText email;
    Button login;

    private VMForgotPassword mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMForgotPassword.class);
        setContentView(R.layout.activity_forgot_password);
        email = findViewById(R.id.email2);
        login = findViewById(R.id.login2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmailAddress(email);
            }
        });
    }

    private boolean validateEmailAddress(EditText email){
        String emailInput = this.email.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Toast.makeText(this, "Password Retrieved", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}