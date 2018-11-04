package com.example.omkar.project_du;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class HinduActivity extends AppCompatActivity implements View.OnClickListener {


    TextView Clicktxt,hindutxt,tv1;
    ImageButton hindulocation;
    ViewFlipper hindu_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindu);
        Clicktxt = findViewById(R.id.clicktext);
        hindu_flipper = findViewById(R.id.hinduslide);
        hindutxt = findViewById(R.id.locateHindutext);
        hindulocation = findViewById(R.id.hindulocation);
        tv1=findViewById(R.id.tv1);
        tv1.setText("Hindu College was founded in 1899 by Krishan Dassji Gurwale in the backdrop of the nationalist struggle against the British Raj. Some prominent citizens, including Gurwale Ji, decided to start a college that would provide nationalist education to the youth, while being non-elitist and non-sectarian. Originally, the college was housed in a humble building in Kinari Bazar, Chandni Chowk, and it was affiliated to Punjab University as there was no university in Delhi at that time. As the college grew, it faced a major crisis in 1902. The Punjab University warned the college that the university would disaffiliate the college if the college failed to get a proper building of its own. Rai Bahadur Lala Sultan Singh came to rescue the college from this crisis. He donated a part of his historic property, which originally belonged to Colonel James Skinner, at Kashmiri Gate, Delhi, to the college. The college functioned from there till 1953. When the University of Delhi took birth in 1922, Hindu College along with Ramjas College and St. Stephen's College were subsequently affiliated to the University of Delhi, making them the first three institutions to be affiliated with the university.The college has a 25-acre campus. It also has one auditorium and a seminar room.[9] The college maintains a playground and a sports complex. Basketball, cricket, and table tennis are organised under the supervision of the Director of Physical Education. The college has well equipped physics and chemistry laboratories, NCC and NSS rooms. A computer room, photocopier and stationery shop are also available. A Students' Centre offers the facility of a bank and a hygienic canteen.Hindu College's library is one of the oldest among the University of Delhi's college libraries. It came into existence along with the foundation of the college in 1899. The library is fully air conditioned and computerised. It is open to bona fide students of all the classes. All important textbooks are kept in the reserve section to enable the students to write their tutorials. It has more than one lakh books and 2000+ eJournals. There is a well equipped reading room, which subscribes to a large number of dailies, weeklies, periodicals and journals on a variety of subjects.Hindu College's boys hostel, with its architectural grandeur and aesthetics, has been an abode to many luminaries and is situated next to the sports complex of college. It is a spacious structure with 119 rooms enclosing four lawns with rose beds and hedges (charbagh style). The hostel provides residential facilities to about two hundred undergraduate and postgraduate male students. Only the highly meritorious among the college students get an admission to the hostel. ");
        hindulocation.setOnClickListener((View.OnClickListener) this);

        int image[] = {R.drawable.hindu1, R.drawable.hindu2,R.drawable.hindu3,R.drawable.hindu4};

        for(int imageloop: image){
            flipperImage(imageloop);
        }
    }

    public void flipperImage(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        hindu_flipper.addView(imageView);
        hindu_flipper.setFlipInterval(3000);
        hindu_flipper.setAutoStart(true);

        hindu_flipper.setInAnimation(this,android.R.anim.fade_in);
        hindu_flipper.setOutAnimation(this, android.R.anim.fade_out);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.hindulocation){
            Uri uri=Uri.parse("https://goo.gl/maps/sEq9UEUkJmJ2");
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
