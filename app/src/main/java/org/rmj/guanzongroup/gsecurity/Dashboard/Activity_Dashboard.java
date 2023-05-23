package org.rmj.guanzongroup.gsecurity.Dashboard;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import org.rmj.guanzongroup.gsecurity.R;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMDashboard;

public class Activity_Dashboard extends AppCompatActivity {


    private VMDashboard mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMDashboard.class);
        setContentView(R.layout.activity_dashboard);
    }
}