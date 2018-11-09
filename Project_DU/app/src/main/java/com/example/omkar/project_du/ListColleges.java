package com.example.omkar.project_du;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.security.AccessController.getContext;

public class ListColleges extends AppCompatActivity {

    Button hrcmore;
    LinearLayout hrcLayout,parentLayout,hrcmoreLayout;
    TextView hrcText;
    TextView textView=null;
    ImageView imageView=null;
    int hrcCount=0;
    TextView hrcCall,hrcLocate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_colleges);
        hrcmore=findViewById(R.id.hrcmore);
        hrcText=findViewById(R.id.textView2);
        hrcLayout=findViewById(R.id.hrcLayout);
        parentLayout=findViewById(R.id.parent);
        hrcCall=findViewById(R.id.hrcCall);
        hrcmoreLayout=findViewById(R.id.hrcmoreLayout);
        hrcLocate=findViewById(R.id.hrcLocate);

        SpannableString spanStr = new SpannableString(hrcLocate.getText().toString());
        spanStr.setSpan(new UnderlineSpan(), 0, spanStr.length(), 0);
        hrcLocate.setText(spanStr);

        SpannableString spanSt = new SpannableString(hrcCall.getText().toString());
        spanSt.setSpan(new UnderlineSpan(), 0, spanSt.length(), 0);
        hrcCall.setText(spanSt);


        hrcmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hrcCount++;

                if(hrcCount%2==1)
                {





                    hrcmoreLayout.setVisibility(View.VISIBLE);

                    hrcmore.setText("read less...");

                }
                else
                {


                    hrcmore.setText(R.string.read_more);
                    hrcmoreLayout.setVisibility(View.GONE);


                }

            }
        });
        hrcText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hrcCount++;

                if(hrcCount%2==1)
                {





                    hrcmoreLayout.setVisibility(View.VISIBLE);

                    hrcmore.setText("read less...");

                }
                else
                {


                    hrcmore.setText(R.string.read_more);
                    hrcmoreLayout.setVisibility(View.GONE);


                }


            }
        });

        hrcLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="
                        +hrcLocate.getText().toString()));
                startActivity(geoIntent);
            }
        });
        hrcCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
                        +hrcCall.getText().toString()));
                startActivity(intent);
            }
        });
    }
}
