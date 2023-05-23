package org.rmj.guanzongroup.gsecurity.Itinerary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import org.rmj.guanzongroup.gsecurity.R;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMItinerary;

public class Activity_Itinerary extends AppCompatActivity {

    private VMItinerary mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMItinerary.class);
        setContentView(R.layout.activity_itinerary);
    }
}