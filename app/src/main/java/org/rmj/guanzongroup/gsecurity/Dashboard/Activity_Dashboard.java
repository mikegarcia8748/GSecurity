package org.rmj.guanzongroup.gsecurity.Dashboard;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import org.rmj.guanzongroup.gsecurity.R;

import java.io.IOException;

public class Activity_Dashboard extends AppCompatActivity implements SurfaceHolder.Callback {

    private Camera mCamera;
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mSurfaceView = findViewById(R.id.recyclerview);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            startCamera();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // No need to implement anything here for this example.
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        releaseCamera();
    }

    private void startCamera() {
        try {
            mCamera = Camera.open();
            mCamera.setPreviewDisplay(mSurfaceHolder);
            mCamera.setDisplayOrientation(90);
            mCamera.startPreview();
        } catch (IOException e) {
            Toast.makeText(this, "Failed to start camera.", Toast.LENGTH_SHORT).show();
        }
    }

    private void releaseCamera() {
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    public void onScanButtonClick(View view) {
        if (mCamera != null) {
            mCamera.setOneShotPreviewCallback(new Camera.PreviewCallback() {
                @Override
                public void onPreviewFrame(byte[] data, Camera camera) {
                    Camera.Parameters parameters = camera.getParameters();
                    Camera.Size size = parameters.getPreviewSize();
                    int width = size.width;
                    int height = size.height;
                    Result result = null;
                    try {
                        PlanarYUVLuminanceSource source = new PlanarYUVLuminanceSource(data, width, height, 0, 0, width, height, false);
                        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                        QRCodeReader reader = new QRCodeReader();
                        result = reader.decode(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (result != null) {
                        String qrText = result.getText();
                        Toast.makeText(Activity_Dashboard.this, "QR Code: " + qrText, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Activity_Dashboard.this, "Failed to scan QR code.", Toast.LENGTH_SHORT).show();
                    }
                    camera.startPreview();
                }
            });
        }
    }
}