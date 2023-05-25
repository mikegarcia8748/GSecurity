package org.rmj.guanzongroup.gsecurity.Adapter;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.gsecurity.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AdapterPersonnel extends AppCompatActivity {
    private ImageView personnelBox;

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
        loNames.add("Dela Cruz, Melanie");
        loNames.add("Dela Cruz, Jayson");
        loNames.add("Dela Cruz, Marjori");
        loNames.add("Raymundo, Kelly");
        loNames.add("Carilla, Jerome");

        LinearLayoutManager loManager = new LinearLayoutManager(this);
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);
        recyclerView.setAdapter(new AdapterItinerary(loNames));
    }
}
