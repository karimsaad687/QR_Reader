package com.qr_reader;

import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class activity_permissions extends AppCompatActivity {
    final int request = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int camera_permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        if (camera_permission == PackageManager.PERMISSION_GRANTED) {
            finish();
            startActivities(new Intent[]{new Intent(this,MainActivity.class)});
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},request);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == request) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                finish();
                startActivities(new Intent[]{new Intent(this,MainActivity.class)});
            } else {
                finish();
            }
        }
    }
}
