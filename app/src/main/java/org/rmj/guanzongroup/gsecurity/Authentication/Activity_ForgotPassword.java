package org.rmj.guanzongroup.gsecurity.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import org.rmj.guanzongroup.gsecurity.R;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMForgotPassword;

public class Activity_ForgotPassword extends AppCompatActivity {

    private VMForgotPassword mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMForgotPassword.class);
        setContentView(R.layout.activity_forgot_password);
    }
}