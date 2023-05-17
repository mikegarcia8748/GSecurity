package org.rmj.guanzongroup.gsecurity.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import org.rmj.guanzongroup.gsecurity.Adapter.Adapter_PersonnelList;
import org.rmj.guanzongroup.gsecurity.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<String> loNames = new ArrayList<>();
        loNames.add("Dela Cruz, Melanie");
        loNames.add("Dela Cruz, Jayson");
        loNames.add("Dela Cruz, Marjori");

        LinearLayoutManager loManager = new LinearLayoutManager(MainActivity.this);
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);
        recyclerView.setAdapter(new Adapter_PersonnelList(loNames));
    }
}