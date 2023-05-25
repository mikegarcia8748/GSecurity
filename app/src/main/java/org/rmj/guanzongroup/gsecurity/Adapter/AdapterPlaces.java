package org.rmj.guanzongroup.gsecurity.Adapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.gsecurity.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterPlaces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<String> DiffPlace = new ArrayList<>();
        DiffPlace.add("Navaluan Mangaldan Pangasinan");
        DiffPlace.add("Tapuac Dagupan City");
        DiffPlace.add("San Fabian bahay ni Aldrin");
        DiffPlace.add("Binmaley bahay ni Jordan");
        DiffPlace.add("Bantayan Mangaldan");
        DiffPlace.add("Baguio City");
        DiffPlace.add("Laguna");
        DiffPlace.add("Csi lucao square");
        DiffPlace.add("Csi lucao Circle");


        LinearLayoutManager loManager = new LinearLayoutManager(this);
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);
        recyclerView.setAdapter(new AdapterItinerary(DiffPlace));
    }
}
