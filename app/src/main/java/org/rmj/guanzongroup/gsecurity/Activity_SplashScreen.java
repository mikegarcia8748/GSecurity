package org.rmj.guanzongroup.gsecurity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import org.rmj.guanzongroup.gsecurity.Authentication.Activity_Login;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMSplashScreen;

public class Activity_SplashScreen extends AppCompatActivity {
    private VMSplashScreen mViewModel;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Activity_SplashScreen.this, Activity_Login.class);
                startActivity(intent);
                finish();
            }
        },5000);

    }
}