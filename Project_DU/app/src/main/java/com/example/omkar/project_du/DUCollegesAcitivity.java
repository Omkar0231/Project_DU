package com.example.omkar.project_du;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DUCollegesAcitivity extends AppCompatActivity {
   ImageView i1,i2;
   ViewPager v1;
   ViewPagerAdapter  adaoter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ducolleges_acitivity);
        v1=(ViewPager)findViewById(R.id.card);
        adaoter=new ViewPagerAdapter(this);
        v1.setAdapter(adaoter);

    }
}
