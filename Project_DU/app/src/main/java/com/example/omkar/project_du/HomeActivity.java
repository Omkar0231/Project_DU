package com.example.omkar.project_du;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
// TRIAL ACTIVITY
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton readmoreHannsraj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        readmoreHannsraj = findViewById(R.id.readmoreH);
        readmoreHannsraj.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.readmoreH){
            Intent Hansraj=new Intent(HomeActivity.this,HansrajActivity.class);
            startActivity(Hansraj);
        }


    }
}
