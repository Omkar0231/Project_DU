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
public class SRCCActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Clicktxt,srcctxt,tv1;
    ImageButton srcclocation;
    ViewFlipper srcc_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srcc);
        tv1=findViewById(R.id.tv1);
        tv1.setText("Shri Ram College of Commerce (SRCC) is one of the premier colleges affiliated to the University of Delhi granting undergraduate and postgraduate degrees. Founded in 1926 in New Delhi, it is one of the most prestigious and oldest institutes of higher learning in Commerce and Economics. The cutoffs required to gain admission in this premier institute are often much higher than other colleges affiliated with University of Delhi. As a result, SRCC enjoys an elite status as the most sought after commerce college in India and has established a reputation for attracting some of the brightest students in the country. In terms of infrastructure, SRCC is one of the best colleges in the country matching international standards. It is one of the few colleges in the University of Delhi which has upgraded its classrooms to facilitate teaching through modern tools and techniques. The College has centrally air conditioned classrooms with Wi-Fi enabled LCD projectors, tutorial rooms, library, a state-of-the-art seminar room and a fully equipped auditorium with seating capacity of over 750 persons. The College takes pride in being a differently-abled friendly campus with new ramps, lifts and special washrooms added to the building. Also, the College has various facilities to address the reading, hearing and understanding requirements of various students. The SRCC library is an empowering unit with a Resource Centre for Visually Challenged possessing an array of audio-visual aids to assist in the process of self actualization. The College is endowed with renovated hostels, medical support systems (along with physiotherapy centre), modern gymnasium, swimming pool, a huge parking facility (available to both students and faculty), air conditioned sports complex and playground of international standards. A complete smoke and vehicle free zone, the College provides an eco-friendly environment to its students with the latest initiatives of solar heating, rainwater harvesting, paper recycling and other green initiatives in the pipeline. The College has taken measures to address the need for vigilance and security. The campus is CCTV-enabled to cater to the safety requirements of a well endowed and equipped campus receiving a huge footfall.The College has a separate parking lot in the campus, near gate No. 4, for students and staff. For regulating entry, parking stickers are issued to the bona-fide users.");
        Clicktxt = findViewById(R.id.clicktext);
        srcctxt = findViewById(R.id.locatesrcctext);
        srcclocation = findViewById(R.id.srcclocation);
        srcc_flipper = findViewById(R.id.srccslide);
        srcclocation.setOnClickListener(this);

        int image[] = {R.drawable.srcc1, R.drawable.srcc2,R.drawable.srcc3,R.drawable.srcc4};

        for(int imageloop: image){
            flipperImage(imageloop);
        }
    }

    public void flipperImage(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        srcc_flipper.addView(imageView);
        srcc_flipper.setFlipInterval(3000);
        srcc_flipper.setAutoStart(true);

        srcc_flipper.setInAnimation(this,android.R.anim.fade_in);
        srcc_flipper.setOutAnimation(this, android.R.anim.fade_out);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.srcclocation){
            Uri uri=Uri.parse("https://goo.gl/maps/mAVCXdTQr9B2");
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
