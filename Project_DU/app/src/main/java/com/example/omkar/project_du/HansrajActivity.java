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
public class HansrajActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Clicktxt,hansrajtxt,tv1;
    ImageButton hansrajlocation;
    ViewFlipper hansraj_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hansraj);
        Clicktxt = findViewById(R.id.clicktext);
        hansraj_flipper = findViewById(R.id.hansajslide);
        hansrajtxt = findViewById(R.id.locateHansrajtext);
        tv1=findViewById(R.id.tv1);
        tv1.setText("Welcome to Hansraj-one of the largest constituent Colleges of the University of Delhi - a premier institution, with highly qualified academicians imparting education in different fields, the College today enjoys a reputation for outstanding performance in academics, sports and extra-curricular activities. Rated among top ten Colleges of the country in Science, Commerce & Arts. The College ensures complete development of the body, mind and the soul while enshrining traditional Indian values in each of its students. The College was founded by the D.A.V. College Managing Committee on July 26, 1948 in the sacred memory of Mahatma Hansraj, a pioneer in the field of education. It is today one of the leading lights in the D.A.V. family of over 700 institutions and one of the largest constituent Colleges of Delhi University. More than 5000 students on its rolls interact here with a galaxy of scholars on its faculty. The College has completed 67 years in the realm of imparting higher education. It has made significant and unparalleled contribution to Society in terms of producing numerous dignitaries scholars, intellectuals and sports persons who served different domains not only in our own country but even at international levels. Over the years, the College has built up an impressive infrastructure. It includes a well-stocked Central Library, Department libraries for Science subjects and a Book Bank for needy students. The College has six Computer Labs. and 18 Science laboratories. Its sports facilities include vast play ground, an Indoor Sports Complex, Playrooms,amphetheatre,lift facility and the only Electronic Shooting Range in the University. The College has an Ultra modern air-conditioned Auditorium fitted with latest sound and light systems with a seating capacity of 500 persons and an imposing stage. Another attraction is an air-conditioned Seminar Room with a seating capacity of 120 fitted with state of the art sound and projection systems. The College has a hostel accommodating about 200 undergraduate boys and is fitted with solar geysers and 24hrs. power back up. As you enter the portals of this institution, the calm, serene atmosphere of a beautiful campus surrounded by lush green lawns and a magnificent heritage building touch your soul. For the benefit of meritorious and needy students, the College provides a number of Scholarships and Freeships. It also provided on its premises ATM and Banking facilities through a branch of Canara Bank. The College also has a Placement Cell for providing employment opportunities to graduating students through campus recruitments in the best of national and international organizations. As the stream of talents flows from this College to the world, join us to create and discover a new world.");
        hansrajlocation = findViewById(R.id.Hansrajlocation);

        hansrajlocation.setOnClickListener(this);

        int image[] = {R.drawable.path, R.drawable.hansrajslide2,R.drawable.hansrajslide3,R.drawable.hansrajslide4};

        for(int imageloop: image){
            flipperImage(imageloop);
        }
    }

    public void flipperImage(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        hansraj_flipper.addView(imageView);
        hansraj_flipper.setFlipInterval(3000);
        hansraj_flipper.setAutoStart(true);

        hansraj_flipper.setInAnimation(this,android.R.anim.fade_in);
        hansraj_flipper.setOutAnimation(this, android.R.anim.fade_out);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Hansrajlocation){
            Uri uri=Uri.parse("geo:0,0?q=28.6792,77.2096(Hansraj+College)");
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
