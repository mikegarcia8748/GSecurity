package org.rmj.guanzongroup.gsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import org.rmj.guanzongroup.gsecurity.Activities.MainActivity;

public class Activity_LoadScreen extends AppCompatActivity {
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Activity_LoadScreen.this, Activity_Login.class);
                startActivity(intent);
                finish();
            }
        },5000);

    }
}