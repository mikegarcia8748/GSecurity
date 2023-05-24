package org.rmj.guanzongroup.gsecurity.Adapter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.gsecurity.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class AdapterPersonnel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView date = findViewById(R.id.currentdate);
        date.setText(currentDate);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<String> loNames = new ArrayList<>();
        loNames.add("Raymundo, Jordan");
        loNames.add("Tamonte, Aldrin");
        loNames.add("Aquino, Marc Adrian");
        loNames.add("Raymundo, Kelly");
        loNames.add("Carilla, Jerome");
        loNames.add("Romero, Marc");
        loNames.add("Abalos, Aldrin");
        loNames.add("Kevin, Austria");

        LinearLayoutManager loManager = new LinearLayoutManager(this);
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);
        recyclerView.setAdapter(new AdapterItinerary(loNames));
      }
    }
