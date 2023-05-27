package org.rmj.guanzongroup.gsecurity.Dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.rmj.guanzongroup.gsecurity.R;

public class DialogMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogmessage_qrcodescanner);

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setPrompt("Scan a QR Code");
        integrator.setOrientationLocked(false);
        integrator.setBeepEnabled(true);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String qrCodeData = result.getContents();
                showDialog(qrCodeData);
            }
        }
    }

    private void showDialog(String qrCodeData) {
        View dialogView = LayoutInflater.from(this).inflate(R.layout.scanned, null);



        TextView titleTextView = dialogView.findViewById(R.id.title);
        TextView messageTextView = dialogView.findViewById(R.id.message);

        titleTextView.setText("SCANNED");
        messageTextView.setText(qrCodeData);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
