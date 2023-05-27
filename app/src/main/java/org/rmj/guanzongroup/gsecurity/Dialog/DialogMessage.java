package org.rmj.guanzongroup.gsecurity.Dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import org.rmj.guanzongroup.gsecurity.R;
import org.rmj.guanzongroup.gsecurity.ViewModel.VMItinerary;

public class DialogMessage extends AppCompatActivity {

    private VMItinerary mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMItinerary.class);
        setContentView(R.layout.messagedialog);
    }
}