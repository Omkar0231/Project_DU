package com.example.omkar.project_du;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;


// This is the first activity
public class HansrajActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {

    ImageButton Hansraj, Ramjas, DaulatRam, Hindu, KiroriMal, Miranda, Srcc, Satyawati ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hansraj2);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Dialogue Box
        //Assigning
        Hansraj = findViewById(R.id.hansraj);
        Hindu = findViewById(R.id.hindu);
        Ramjas = findViewById(R.id.ramjas);
        KiroriMal= findViewById(R.id.kmc);
        Miranda = findViewById(R.id.miranda);
        Srcc = findViewById(R.id.srcc);
        Satyawati = findViewById(R.id.satywaati);
        DaulatRam=findViewById(R.id.drc);

        Hansraj.setOnClickListener(this);
        Hindu.setOnClickListener(this);
        Ramjas.setOnClickListener(this);
        Miranda.setOnClickListener(this);
        Srcc.setOnClickListener(this);
        Satyawati.setOnClickListener(this);
        DaulatRam.setOnClickListener(this);
        KiroriMal.setOnClickListener(this);



    }


            @Override
        public void onClick (View v){
            switch(v.getId()) {

                case R.id.hansraj:
                Intent i1 = new Intent(HansrajActivity2.this, HansrajActivity.class);
                startActivity(i1);
                break;

                case R.id.hindu:
                    Intent i2 = new Intent(HansrajActivity2.this, HinduActivity.class);
                    startActivity(i2);
                    break;

                case R.id.ramjas:
                    Intent i3 = new Intent(HansrajActivity2.this, RamjasActivity.class);
                    startActivity(i3);
                    break;

                case R.id.kmc:
                    Intent i4 = new Intent(HansrajActivity2.this, KMC_Activity.class);
                    startActivity(i4);
                    break;

                case R.id.miranda:
                    Intent i5 = new Intent(HansrajActivity2.this, MirandaActivity.class);
                    startActivity(i5);
                    break;

                case R.id.drc:
                    Intent i6 = new Intent(HansrajActivity2.this, DRC_Activity.class);
                    startActivity(i6);
                    break;

                case R.id.srcc:
                    Intent i7 = new Intent(HansrajActivity2.this, SRCCActivity.class);
                    startActivity(i7);
                    break;

                case R.id.satywaati:
                    Intent i8 = new Intent(HansrajActivity2.this, SatyawatiActivity.class);
                    startActivity(i8);
                    break;

            }
        }


        @Override
        public void onBackPressed () {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.hansraj_activity2, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected (MenuItem item){
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.searchwmarks) {
                // Handle the camera action
            } else if (id == R.id.course) {

            } else if (id == R.id.marks) {

            } else if (id == R.id.documents) {

            } else if (id == R.id.dupros) {

            } else if (id == R.id.nav_send) {

            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }

