package org.rmj.guanzongroup.gsecurity.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import org.rmj.guanzongroup.gsecurity.R;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMCreateAccount;

public class Activity_CreateAccount extends AppCompatActivity {

    private VMCreateAccount mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMCreateAccount.class);
        setContentView(R.layout.activity_create_account);
    }
}