package com.example.omkar.project_du;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.karan.churi.PermissionManager.PermissionManager;

public class MainActivity extends AppCompatActivity  {

    Animation fromtop,frombottom;
    ImageView logo;
    private static int Splash_Time=2000;
    private static final int MY_PERMISSIONS_REQUEST_RECORD_AUDIO =0;
    PermissionManager permissionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // checking the permissions for audio record


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                permissionManager = new PermissionManager() {};
                permissionManager.checkAndRequestPermissions(MainActivity.this);
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO)
                        == PackageManager.PERMISSION_GRANTED) {
                    // Permission is not granted
                    Intent homeintent = new Intent(MainActivity.this,HomeActivityMain.class);
                    startActivity(homeintent);
                    finish();
                }
            }
        },Splash_Time);

        logo = findViewById(R.id.logo);
        frombottom=AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromtop=AnimationUtils.loadAnimation(this,R.anim.fromtop);
        logo.setAnimation(fromtop);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        Intent homeintent = new Intent(MainActivity.this,HomeActivityMain.class);
        startActivity(homeintent);
        finish();
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_RECORD_AUDIO: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }


    }


}

