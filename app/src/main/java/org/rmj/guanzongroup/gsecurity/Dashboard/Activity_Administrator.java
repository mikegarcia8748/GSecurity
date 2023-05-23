package org.rmj.guanzongroup.gsecurity.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import org.rmj.guanzongroup.gsecurity.R;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMAdministrator;

public class Activity_Administrator extends AppCompatActivity {

    private VMAdministrator mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMAdministrator.class);
        setContentView(R.layout.activity_administrator);
    }
}