package org.rmj.guanzongroup.gsecurity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.rmj.guanzongroup.gsecurity.Activities.MainActivity;

public class MainActivity_QRCODE extends AppCompatActivity {


    private Button btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_qrcode);


        btnScan = findViewById(R.id.btnScan);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                extracted1();
            }
        });

    }

    private void extracted1() {
        com.journeyapps.barcodescanner.ScanOptions options = new com.journeyapps.barcodescanner.ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(StartScan.class);
        launcher.launch(options);

    }

     ActivityResultLauncher<ScanOptions> launcher = registerForActivityResult(new ScanContract(), result ->{

        if (result.getContents()!= null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_QRCODE.this);
            builder.setTitle("QR-SCANNER RESULT");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            }).show();
        }

    });

}