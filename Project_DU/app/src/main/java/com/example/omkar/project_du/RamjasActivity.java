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
public class RamjasActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Clicktxt,ramjastxt,tv1;
    ImageButton ramjaslocation;
    ViewFlipper ramjas_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramjas);
        tv1=findViewById(R.id.tv1);
        tv1.setText("Ramjas College is a college of the University of Delhi located in North Campus of the university in New Delhi, India. It is one of the first three colleges established under University of Delhi. Ramjas. The college admits both undergraduates and post-graduates, and awards degrees under the purview of the University of Delhi. Ramjas was celebrating its Centennial legacy from 2016 and completed its 100 years celebration in January 2017." +
                "It is one of the founding colleges of University of Delhi, along with Hindu College and St. Stephen's College. It is a co-educational college that admits students and select teachers from all communities irrespective of gender, caste, religion and physical challenges. The institution believes in holistic education that goes beyond achieving academic excellence, and vocational training." +
                "In January 2004, the College organised the first ever Conference of Graduate Students of Economics from the SAARC countries. Department of Mathematics of the College is believed to be the best Department of Mathematics in University of Delhi.The Department of Mathematics, Ramjas College organised a two-day International Conference on Mathematics & Applications (ICMA – 2017). The conference was held between April 26-28. It covered almost all the topics of Mathematics and its applications in different fields from History of Mathematics to Modern Mathematics. There were more than 200 participants from different destinations of India and abroad like from Italy, Serbia, Iran and more other nations. The conference had about 45 invited talks by eminent speakers of different branches of Mathematics from CMI, TIFR, IITs, IMSC and many Central/State Universities.The college's red coloured building is surrounded by trees and foliage which has earned it the title 'Rainforest'.A Seminar Room and a Conference Hall form the nucleus of all the academic conferences, events and proceedings of the college. It has volleyball, basketball, football and table tennis facilities. It also has its own shooting range and an archery range within the campus.It also has a gymnasium with modern equipment.The college also provides hostel facility with 80 seats for girls & 120 seats for boys.There are over 100,000 titles in the library, and are all bar-coded. Books are issued matching bar coded student ID Cards and titles of their choice. ");
        Clicktxt = findViewById(R.id.clicktext);
        ramjastxt = findViewById(R.id.locateRamjastext);
        ramjaslocation = findViewById(R.id.Ramjaslocation);
        ramjas_flipper = findViewById(R.id.ramjasslide);
        ramjaslocation.setOnClickListener(this);

        int image[] = {R.drawable.ramjas1, R.drawable.ramjas2,R.drawable.ramjas3,R.drawable.ramjas4};

        for(int imageloop: image){
            flipperImage(imageloop);
        }
    }

    public void flipperImage(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        ramjas_flipper.addView(imageView);
        ramjas_flipper.setFlipInterval(3000);
        ramjas_flipper.setAutoStart(true);

        ramjas_flipper.setInAnimation(this,android.R.anim.fade_in);
        ramjas_flipper.setOutAnimation(this, android.R.anim.fade_out);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Ramjaslocation){
            Uri uri=Uri.parse("https://goo.gl/maps/3ymYJu8ZH4k");
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
