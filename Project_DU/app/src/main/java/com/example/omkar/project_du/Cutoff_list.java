package com.example.omkar.project_du;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class Cutoff_list extends AppCompatActivity {

    ListView listview;
    PDFView pdf_2017;
    RadioGroup cutoff_rdbtns;
    RadioButton firstcutoff,lastcutoff;
    String list_names[] = {"2018 - CutOff","2017 - CutOff","2016 - CutOff", "2015 - CutOff", "2014 - CutOff"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutoff_list);
        listview = findViewById(R.id.list_view);
        pdf_2017=findViewById(R.id.pdf2017);
        cutoff_rdbtns= findViewById(R.id.cutoff_radiobuttons);
        firstcutoff = findViewById(R.id.firstcutoffbtn);
        lastcutoff = findViewById(R.id.lastcutoffbtn);

        cutoff_rdbtns.setVisibility(View.INVISIBLE);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_names);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    listview.setVisibility(View.INVISIBLE);
                    cutoff_rdbtns.setVisibility(View.VISIBLE);

                    cutoff_rdbtns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if(checkedId==R.id.firstcutoffbtn){
                                pdf_2017.fromAsset("bestcutoff2017.pdf").load();
                                pdf_2017.setVisibility(View.VISIBLE);
                            }

                        }
                    });

                }
            }
        });


    }
}




