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
      implements View.OnClickListener {

    ImageButton learnmoreHannsraj, learnmoreRamjas;
    ImageView du_colleges;
    MediaPlayer AudioForBlind;   // Are you a blind person? & yes or no (audio)
    String Speechflag = "";

    SpeechRecognizer mSpeechRecognizer;
    Intent mRecognizerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hansraj2);

    /*    checkPermission(); // for checking the permissions
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

*/
        //Dialogue Box
        //Assigning
        learnmoreHannsraj = findViewById(R.id.readmoreH);
        learnmoreRamjas = findViewById(R.id.readmoreRamj);
        du_colleges = findViewById(R.id.ducollegesid);

        //Audio For Blind
        AudioForBlind = MediaPlayer.create(HansrajActivity2.this, R.raw.areyouablindperson);

        learnmoreHannsraj.setOnClickListener(this);


      /*  final AlertDialog dialog;

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
                   Intent BlindHansrajPage = new Intent(HansrajActivity2.this,HansrajPageBlind.class);
                   startActivity(BlindHansrajPage);
                }


            }
        }, 7000);

*/

    }


    // Permission Check for Record Audio
       /* private void checkPermission() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.parse("package:" + getPackageName()));
                    startActivity(intent);
                    finish();
                }
            }
       */



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.readmoreH) {
            Intent Hansraj = new Intent(HansrajActivity2.this, HansrajActivity.class);
            startActivity(Hansraj);
        }
    }


    /*    @Override
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
        }*/
//}

}