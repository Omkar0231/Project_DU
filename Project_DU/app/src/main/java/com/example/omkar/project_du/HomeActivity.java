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

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {

    //Instances
    ImageButton DucollegeIcon, DucollegeText, Cutoff;
    MediaPlayer AudioForBlind, SpeakAgain;   // Are you a blind person? & yes or no (audio)
    String Speechflag="";
    ViewFlipper viewFlipper;

    SpeechRecognizer mSpeechRecognizer;
    Intent mRecognizerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // checking the permissions for audio record
        checkPermission();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Initializing
        DucollegeIcon = findViewById(R.id.ducollegeicon);
        DucollegeText = findViewById(R.id.ducollegestext);
        Cutoff = findViewById(R.id.cutoff);
        viewFlipper = findViewById(R.id.viewflippperid);


        //Creating an array for sliding multiple images
        int SlidingImages[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8 };

        // Displaying the Sliding Images
        for(int image : SlidingImages){
            ImageSliding(image);
        }

        // Setting OnClickListener
        DucollegeIcon.setOnClickListener(this);
        DucollegeText.setOnClickListener(this);
        Cutoff.setOnClickListener(this);

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

        //Audio For Blind
        AudioForBlind = MediaPlayer.create(HomeActivity.this, R.raw.areyouablindperson);
        // If not responded correctly
        SpeakAgain = MediaPlayer.create(HomeActivity.this,R.raw.pleasespeakyesorno);

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

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                AudioForBlind.start();     // Play Audio

            }
        }, 1000);




           //Executing after 3 seconds
           final Handler handler1 = new Handler();
           handler1.postDelayed(new Runnable() {
               @Override
               public void run() {

                   mSpeechRecognizer.startListening(mRecognizerIntent);

               }
           }, 4000);



           //Executing after 7 seconds
           final Handler handler2 = new Handler();
           handler2.postDelayed(new Runnable() {
               @Override
               public void run() {

                   // If not Blind, the dialogBox closes
                   if (Speechflag.equals("no")) {
                       dialog.dismiss();
                   }

                   // If Blind, Another Activity Starts
                   else if (Speechflag.equals("yes")) {
                       dialog.dismiss();
                       Intent BlindHansrajPage = new Intent(HomeActivity.this, HansrajPageBlind.class);
                       startActivity(BlindHansrajPage);
                   } else {
                       SpeakAgain.start();
                       final Handler handler = new Handler();
                       handler.postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               mSpeechRecognizer.startListening(mRecognizerIntent);

                           }
                       }, 2000);
                   }


               }
           }, 8000);
       }






    // function for Permission Check for Record Audio
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


    // function for ViewFlipper
    public void ImageSliding(int image){
        ImageView imageView = new ImageButton(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.fade_in);
      //  viewFlipper.setOutAnimation(this, android.R.anim.fade_in);
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
        getMenuInflater().inflate(R.menu.home, menu);
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
            Intent DU_PRospectus = new Intent(HomeActivity.this, DU_Prospectus.class);
            startActivity(DU_PRospectus);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.ducollegestext||id==R.id.ducollegeicon){
            Intent DucollegesPage = new Intent(HomeActivity.this,HansrajActivity2.class);
            startActivity(DucollegesPage);
        }

        if(id==R.id.cutoff){
            Intent Cutoff_list = new Intent(HomeActivity.this,Cutoff_list.class);
            startActivity(Cutoff_list);
        }
    }
}
