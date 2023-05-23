package org.rmj.guanzongroup.gsecurity.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import org.rmj.guanzongroup.gsecurity.R;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMLogin;

public class Activity_Login extends AppCompatActivity {

    private VMLogin mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMLogin.class);
        setContentView(R.layout.activity_login);
    }
}