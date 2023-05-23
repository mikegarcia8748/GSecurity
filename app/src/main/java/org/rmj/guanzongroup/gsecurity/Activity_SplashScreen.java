package org.rmj.guanzongroup.gsecurity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import org.rmj.guanzongroup.gsecurity.R;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMSplashScreen;

public class Activity_SplashScreen extends AppCompatActivity {

    private VMSplashScreen mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMSplashScreen.class);
        setContentView(R.layout.activity_splash_screen);
    }
}