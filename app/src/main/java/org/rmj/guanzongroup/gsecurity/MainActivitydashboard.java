package org.rmj.guanzongroup.gsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivitydashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitydashboard);
        setTitle("date");

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(android.icu.text.DateFormat.FULL).format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(currentDate);
    }
}