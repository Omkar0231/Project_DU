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
public class MirandaActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Clicktxt,mirandatxt,tv1;
    ImageButton mirandalocation;
    ViewFlipper miranda_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miranda);
        tv1=findViewById(R.id.tv1);
        tv1.setText("Miranda House (MH) is constituent college for women at the University of Delhi in India. Established in 1948. Miranda House offers degrees in the sciences and liberal arts. In 2017, the College was rated as the best college in India by the National Institutional Ranking Framework. Miranda House was founded in 1948 by the university vice-chancellor, Sir Maurice Gwyer. Its foundation stone was laid by Lady Edwina Mountbatten on 7 March in the same year. Miranda House is built of red bricks on the university campus. Its original design was planned by the architect Walter Sykes George and is architecturally similar to other educational institutions in India founded in the colonial era. As the college grew, several buildings were added. \n" +
                "Alumni and students of this college are known as Mirandians. \n" +
                "Miranda House started with 33 students in July 1948, which rose to 105 by September the same year. It was 2,090 in 1997–98. The academic staff increased from six in 1948 to 120 (permanent) in 1997–98 and that of non-academic staff from 11 in 1948 (five in the hostel and six in the college) to 120 in 1997–98. The college accommodation (hostel) housed 43 students in 1948, of whom seven were enrolled at other colleges of the University of Delhi. There are now 250 students in the hostel. \n" +
                "At the time of its founding, Miranda House had six departments; as of 2012 there were eighteen. Science teaching was conducted in the university and in 1963–64, B.Sc. General and in 1971, B.Sc. Honours teaching work started in the college. Many new subjects have been introduced in the humanities and social sciences since then. \n" +
                "Miranda House provides liberal education in social sciences, humanities and the basic sciences. The college's infrastructure includes teaching laboratories and general facilities.As of 2012 Miranda House has more than 3,000 students. Miranda House offers a wide array of undergraduate and graduate courses. All undergraduate courses commencing from the academic year 2014-15 are according to the three-year undergraduate honours degree system. The Miranda House Library acquired its first book on 22 July 1948. In the beginning it was confined to one room. Miranda House provides liberal education in social sciences, humanities and the basic sciences. The college's infrastructure includes teaching laboratories and general facilities.As of 2012 Miranda House has more than 3,000 students. Miranda House offers a wide array of undergraduate and graduate courses. All undergraduate courses commencing from the academic year 2014-15 are according to the three-year undergraduate honours degree system. The new library block is a double-storeyed building consisting of deposit-counter, issue-of-books counter, stack hall, reserve section, reading hall, teachers' reading room, magazine section, and administrative section.");
        Clicktxt = findViewById(R.id.clicktext);
        mirandatxt = findViewById(R.id.locateMirandatext);
        mirandalocation = findViewById(R.id.Mirandalocation);
        miranda_flipper = findViewById(R.id.mirandaslide);
        mirandalocation.setOnClickListener(this);

        int image[] = {R.drawable.miranda1, R.drawable.miranda2, R.drawable.miranda3,R.drawable.miranda4};

        for(int imageloop: image){
            flipperImage(imageloop);
        }
    }

    public void flipperImage(int image){

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        miranda_flipper.addView(imageView);
        miranda_flipper.setFlipInterval(3000);
        miranda_flipper.setAutoStart(true);

        miranda_flipper.setInAnimation(this,android.R.anim.fade_in);
        miranda_flipper.setOutAnimation(this, android.R.anim.fade_out);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.Mirandalocation){
            Uri uri=Uri.parse("https://goo.gl/maps/cxSrvJXZEc72");
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
