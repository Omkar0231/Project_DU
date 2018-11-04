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
public class DRC_Activity extends AppCompatActivity implements View.OnClickListener {

    TextView Clicktxt,drctxt,tv1;
    ImageButton drclocation;
    ViewFlipper drc_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drc_);
        tv1=findViewById(R.id.tv1);
        tv1.setText("Daulat Ram College (DRC) is a women's college under University of Delhi that was founded in 1960. Originally called Pramila College, it was named Daulat Ram College after educationist Daulat Ram Gupta. In 1964 it was shifted to Patel Marg among other college campuses in North Campus. It is one of the best colleges of University of Delhi situated in North Campus. Its hostel is the best in Delhi University also it has its own kitchen garden. Daulat Ram College is awarded 'A' grade in the first cycle grading by the NAAC. Daulat Ram College has facilty of library, labrotory, computer lab, seminar hall, amphitheatre( rangshala ), college auditorium (Sadbhavna Bhawan) and medical aid room. \n" +
                "The college has 19 departments which offer undergraduate courses in Arts, Science and Commerce. Of the 19 departments 7 admit students for Master's level tutorial classes which supplements M.A. lecture classes held at the main arts faculty. The College has active and vibrant societies for cultural activities in drama, debate, fine arts, music and environment related activities. The placements are good. To guide students, regular training sessions are also held by the experts. The students have the potential and capabilities to perform their best as they are very much talented. The companies which visit the campus recognise the students' talent. \n" +
                 "The classrooms are fully air-conditioned and are spacious. Faculty and teachers are very nice. They are very helpful and cooperate with the students. The infrastructure of the college is the best. Wi-Fi facility is also available in the college. Books are available in the library. Sports and games facilities are also available in the college. Partial or full fee concession may be granted to economically weak students.Fee concession granted is subject to good conduct, regular attendance and satisfactory progress in\n" +
                "studies and may be withdrawn any time if a student is found neglecting any of these.Students belonging to Scheduled Castes/ Scheduled Tribes are awarded Post- Matric Scholarships by the Directorate of Education, Delhi Administration.");
        Clicktxt = findViewById(R.id.clicktext);
        drctxt = findViewById(R.id.locatedrctext);
        drclocation = findViewById(R.id.drclocation);
        drc_flipper = findViewById(R.id.drcslide);
        drclocation.setOnClickListener(this);

        int image[] = {R.drawable.drc1, R.drawable.drc2,R.drawable.drc3,R.drawable.drc4};

        for(int imageloop: image){
            flipperImage(imageloop);
        }
    }

    public void flipperImage(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        drc_flipper.addView(imageView);
        drc_flipper.setFlipInterval(3000);
        drc_flipper.setAutoStart(true);

        drc_flipper.setInAnimation(this,android.R.anim.fade_in);
        drc_flipper.setOutAnimation(this, android.R.anim.fade_out);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.drclocation){
            Uri uri=Uri.parse("https://goo.gl/maps/PuTjMya8mc82");
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
