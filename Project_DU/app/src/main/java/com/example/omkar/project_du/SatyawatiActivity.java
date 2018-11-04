package com.example.omkar.project_du;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import static android.os.Build.VERSION_CODES.N;

// This is the Second Activity
public class SatyawatiActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Clicktxt,satyawatitxt,tv1;
    ImageButton satyawatilocation;
    ViewFlipper satyawati_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satyawati);
        tv1=findViewById(R.id.tv1);
        tv1.setText("Satyawati College is a university college in Delhi, India, affiliated to the University of Delhi. It offers both morning and evening classes to a student base of almost 2,000, with a permanent teaching staff of around 150.The college was established in 1972 by the Government of Delhi, while \"Evening college\" was established in 1973.[6] It is one of the constituent colleges of Delhi University that lies in North campus, in Phase-3, Ashok Vihar, Delhi.The College is named after Behen (Sister) Satyawati.The infrastructure of Satyawati is very good. It has the best auditorium of DU. Wi-Fi is available all over the college. It also has good computer labs, separate well-maintained library, gym, and a huge ground with all necessary sports accessories with basketball ground, cricket ground etc. The college also has a canteen with a variety of dishes and good seating arrangements. No hostel rooms are available, but rooms on rent or PGs are available nearby. The teachers are well qualified helpful and seem quite knowledgeable. They use good teaching methods. The student-faculty ratio is 20:1. I didn't get any industry exposure yet. The course curriculum seems useful. Every year, there are mainly three events organised, fresher, fest & farewell for each department separately. Fest is also organised at the college level once, per year. All the campus is connected with a strong network Wi-Fi. Every student gets Rs. 10,000 annual scholarship in the college. ECA is also available there like NCC, NSS, sports, etc.The placements in the college are quite good, approximately 15-20 companies visit the college every year. Unlike the north campus the college students getting high packages every year, one can expect a package of 4-5 LPA after completion of his or her graduation from the college. It offers degrees in Commerce, Economics, English, Hindi, History, Mathematics, Political Science, Sanskrit, and Urdu. Economics and Commerce are the two most popularly subscribed courses. Active participation in DUSU Elections is taken. Several Delhi University Presidents and eminent posts in Delhi University Students Union were from Satyawati College.");
        Clicktxt = findViewById(R.id.clicktext);
        satyawatitxt = findViewById(R.id.locatesatyawatitext);
        satyawatilocation = findViewById(R.id.satyawatilocation);
        satyawati_flipper = findViewById(R.id.satyawatislide);
        satyawatilocation.setOnClickListener(this);

        int image[] = {R.drawable.satyawati1, R.drawable.satyawati2,R.drawable.satyawati3,R.drawable.satyawati4};

        for(int imageloop: image){
            flipperImage(imageloop);
        }
    }

    public void flipperImage(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        satyawati_flipper.addView(imageView);
        satyawati_flipper.setFlipInterval(3000);
        satyawati_flipper.setAutoStart(true);

        satyawati_flipper.setInAnimation(this,android.R.anim.fade_in);
        satyawati_flipper.setOutAnimation(this, android.R.anim.fade_out);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.satyawatilocation){
            Uri uri=Uri.parse("https://goo.gl/maps/FMiosfChhd82");
            //uri=Uri.parse("google.navigation.q=28.6792°N, 77.2096°E");
            Intent viewhansrajloc = new Intent(Intent.ACTION_VIEW,uri);
            viewhansrajloc.setPackage("com.google.android.apps.maps");
            // if(viewhansrajloc.resolveActivity(getPackageManager())!=null)
            //{
            //   Intent intent=Intent.createChooser(viewhansrajloc,"Pleae select one...");

            startActivity(viewhansrajloc);

            //}/
        }
    }
}
