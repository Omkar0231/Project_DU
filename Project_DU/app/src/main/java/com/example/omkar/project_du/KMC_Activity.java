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
public class KMC_Activity extends AppCompatActivity implements View.OnClickListener {

    TextView Clicktxt,kmctxt,tv1;
    ImageButton kmclocation;
    ViewFlipper kmc_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmc_);
        Clicktxt = findViewById(R.id.clicktext);
        tv1=findViewById(R.id.tv1);
        tv1.setText("Welcome to Kirori Mal College, an institution of academic excellence, established in 1954, that has always strived to, and successfully maintained its place as one of the finest within the University of Delhi. We at Kirori Mal believe in providing for our students an environment rich in knowledge and supportive of their extracurricular interests. \n" +
                "The college encourages a quest for knowledge that is rooted in an ethical understanding of the world that we inhabit and this enthusiasm for learning along with a desire to evolve into socially responsible beings is reflected not only in the academic atmosphere but also visible in the field of extra-curricular activity. Our tradition of excellence in theatre, art and music only adds to the richness of the academic fabric of the college. You will encounter the unique combination of social activism, creativity and learning in every discipline and every corner of this institution. Over the years, the college has built up an impressive array of academic facilities such as a fully computerized library, a state of the art computer center and an active placement cell. Our endeavor is to make individuals more mature, responsible and socially aware.The college provides facilities for hockey, cricket, football, badminton, table tennis, basketball, athletics, boxing and chess. Kirori Mal College has a spectacular history in sports. It holds the record for having won five first positions in a single year (including three major games) in Delhi University Inter-College tournaments, and of once having been awarded the coveted Vice-Chancellor’s Trophy for being the best All Round College. Year after year, we have provided outstanding players to Delhi University, Delhi State and the junior India teams in several games. The college provides facilities for Hockey, Cricket, Football, Badminton, Table Tennis, Basketball, Athletics, Boxing and Chess.Kirori Mal College has activities in drama, debate, music, fine arts, photography, dance and film. Notable among them is \"Players\", the college drama society. Its members receive training in theatre arts. It generally puts up four productions.The hostel is an integral part of the college family. Its 89 rooms house about I70 students both from India and abroad. It has an intercom facility. Hostel seats are allocated to various classes/courses, and admission is made on the basis of merit.");
        kmctxt = findViewById(R.id.locatekmctext);
        kmclocation = findViewById(R.id.kmclocation);
        kmc_flipper = findViewById(R.id.kmcslide);
        kmclocation.setOnClickListener(this);

        int image[] = {R.drawable.kmc1, R.drawable.kmc2,R.drawable.kmc3,R.drawable.kmc4};

        for(int imageloop: image){
            flipperImage(imageloop);
        }
    }

    public void flipperImage(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        kmc_flipper.addView(imageView);
        kmc_flipper.setFlipInterval(3000);
        kmc_flipper.setAutoStart(true);

        kmc_flipper.setInAnimation(this,android.R.anim.fade_in);
        kmc_flipper.setOutAnimation(this, android.R.anim.fade_out);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.kmclocation){
            Uri uri=Uri.parse("https://goo.gl/maps/Exp36fMDoMx");
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
