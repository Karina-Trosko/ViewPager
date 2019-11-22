package com.example.viewpager;


import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements CustomPagerAdapter.OnCustomAdapterListener {

    //  private CustomBroadcastReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this, this));
//        receiver = new CustomBroadcastReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("fon");
//        registerReceiver(receiver, intentFilter);

    }

    @Override
    public void onClick(ModelObject modelObject) {
        String permissionName = "";
        switch (modelObject.getTitleResId()) {
            case R.string.audio_p:
                permissionName = Manifest.permission.RECORD_AUDIO;
                break;
            case R.string.calendar_p:
                permissionName = Manifest.permission.READ_CALENDAR;
                break;
            case R.string.camera_p:
                permissionName = Manifest.permission.CAMERA;
                break;
            case R.string.contacts_p:
                permissionName = Manifest.permission.READ_CONTACTS;
                break;
            case R.string.location_p:
                permissionName = Manifest.permission.ACCESS_COARSE_LOCATION;
                break;
            case R.string.phone_p:
                permissionName = Manifest.permission.READ_PHONE_STATE;
                break;
            case R.string.sensors_p:
                permissionName = Manifest.permission.BODY_SENSORS;
                break;
            case R.string.sms_p:
                permissionName = Manifest.permission.SEND_SMS;
                break;
            case R.string.storage_p:
                permissionName = Manifest.permission.READ_EXTERNAL_STORAGE;
                break;
            //sendBroadcast(new Intent("fon"));
        }
        if (permissionName != "")
            checkPermission(permissionName);
    }

    private void checkPermission(String permissionName) {
        if (ContextCompat.checkSelfPermission(getBaseContext(),
                permissionName) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getBaseContext(), "accessed", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{permissionName}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getBaseContext(), "Permission received", Toast.LENGTH_LONG).show();

            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                    Toast.makeText(getBaseContext(), "Permission denied", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "you chose \"Don't ask again\", if you change your mind, please click the \"settings\" button and select the permissions", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    //    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(receiver);
//    }

}


