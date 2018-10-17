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
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Locale;


public class ajayhomepage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewFlipper viewFlipper;
    ImageView imageView;

    MediaPlayer AudioForBlind;   // Are you a blind person? & yes or no (audio)
    String Speechflag="";
    SpeechRecognizer mSpeechRecognizer;
    Intent mRecognizerIntent;
    ImageButton learnmoreHannsraj, learnmoreRamjas;

    ImageButton imageButton;


    int images[]={R.drawable.hrc,R.drawable.hindu,R.drawable.gargi,R.drawable.miranda,R.drawable.daulat,R.drawable.lsr,R.drawable.ramjas,R.drawable.kmc,R.drawable.arts,R.drawable.stephens,R.drawable.ddu,R.drawable.cvs,R.drawable.desbhandu,R.drawable.andc,R.drawable.art,R.drawable.khalsa,R.drawable.mayeteri};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajayhomepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        checkPermission();

        viewFlipper =findViewById(R.id.viewflip);

        for(int image:images)
            flipping(image);



        /*AlertDialog.Builder builder=new AlertDialog.Builder(this);//prompt
        builder.setMessage("Are you a Blind Person ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();*/



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imageButton=findViewById(R.id.college);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttoCollege=new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intenttoCollege);
            }
        });


        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

        mRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {

                ArrayList<String> mSpeechToText = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if(mSpeechToText!=null){
                    if(mSpeechToText.get(0).equals("yes")){
                        Speechflag="yes";
                    }

                    else if(mSpeechToText.get(0).equals("no")){
                        Speechflag="no";
                    }

                }


            }
            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });

        AudioForBlind = MediaPlayer.create(getApplicationContext(), R.raw.areyouablindperson);



        final AlertDialog dialog;

        AlertDialog.Builder alert = new AlertDialog.Builder(this);


        alert.setMessage("Are you a Blind Person ?")
                .setCancelable(false)

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        dialog=alert.create();
        dialog.show();        // Show DialogueBox
        AudioForBlind.start();     // Play Audio

        //Executing after 3 seconds
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                mSpeechRecognizer.startListening(mRecognizerIntent);

            }
        }, 3000);


        //Executing after 7 seconds
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {

                // If not Blind, the dialogBox closes
                if(Speechflag.equals("no")){
                    dialog.cancel();
                }

                // If Blind, Another Activity Starts
                else if(Speechflag.equals("yes")){
                    Intent BlindHansrajPage = new Intent(getApplicationContext(),HansrajPageBlind.class);
                    startActivity(BlindHansrajPage);
                }


            }
        }, 7000);




    }

    // Permission Check for Record Audio
    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                finish();
            }
        }

    }

    public void flipping(int image)
    {
        imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

       // imageView.setScaleType(ImageView.ScaleType.MATRIX);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.fade_in);
        viewFlipper.setOutAnimation(this,android.R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ajayhomepage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
