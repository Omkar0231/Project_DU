package com.example.omkar.project_du;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class Cutoff_list extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String Flag="x";
    String Flag1;
    int test=0,test1=0;               //Appending 0 to Flag should be only once
    ListView listview;
    Toast t1;

    PDFView FirstCutoff, LastCutoff;
    Spinner Science_Commerce;
    RadioGroup cutoff_rdbtns2017;
    RadioButton firstcutoff,lastcutoff;
    String list_names[] = {"2018 - CutOff","2017 - CutOff","2016 - CutOff", "2015 - CutOff", "2014 - CutOff"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutoff_list);

        //Grabbing Reference

        listview = findViewById(R.id.list_view);
        FirstCutoff = findViewById(R.id.pdf2017);
        LastCutoff = findViewById(R.id.pdf2017);
        cutoff_rdbtns2017 = findViewById(R.id.cutoff_radiobuttons);
        firstcutoff = findViewById(R.id.firstcutoffbtn);
        lastcutoff = findViewById(R.id.lastcutoffbtn);
        Science_Commerce = findViewById(R.id.selectstream);




        //Implementing



        FirstCutoff.setVisibility(View.INVISIBLE);
        Science_Commerce.setVisibility(View.INVISIBLE);

        cutoff_rdbtns2017.setVisibility(View.INVISIBLE);

        //Setting OnCheckedChangeListener

        Science_Commerce.setOnItemSelectedListener(this);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list_names);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //Items Selected in ListView
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==1){
                    listview.setVisibility(View.INVISIBLE);
                    Science_Commerce.setVisibility(View.VISIBLE);   //Spinner is visible
                    Flag = "2017-cutoffx";
                }
                else if(position==2){
                    listview.setVisibility(View.INVISIBLE);
                    Science_Commerce.setVisibility(View.VISIBLE);
                    Flag = "2016-cutoffx";
                }
                else if(position==3){
                    listview.setVisibility(View.INVISIBLE);
                    Science_Commerce.setVisibility(View.VISIBLE);
                    Flag = "2015-cutoffx";
                }
                else if(position==4){
                    listview.setVisibility(View.INVISIBLE);
                    Science_Commerce.setVisibility(View.VISIBLE);
                    Flag = "2014-cutoffx";
                }
            }
        });


        // Selecting Radio Buttons for First and Last Cut-Off
        cutoff_rdbtns2017.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                if(radioButton.getId()==R.id.firstcutoffbtn){

                    switch (Flag){                                         //When 2017 CutOff in ListView is selected
                        // and Stream Science is  Selected

                        case "2017-cutoff0" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("sciencebestcutoff2017.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2016-cutoff0" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("sciencebestcutoff2016.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2015-cutoff0" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("sciencebestcutoff2015.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2014-cutoff0" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("sciencebestcutoff2014.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2017-cutoff1" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("arts_commercebestcutoff2017.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2016-cutoff1" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("sciencebestcutoff2016.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2015-cutoff1" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("arts_commercebestcutoff2015.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2014-cutoff1" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("arts_commercebestcutoff2014.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        default:
                            Toast.makeText(Cutoff_list.this, "Error loading pdf", Toast.LENGTH_SHORT).show();
                            break;
                    }



                }
                else if(radioButton.getId()==R.id.lastcutoffbtn){

                    switch (Flag){


                        case "2017-cutoff0" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("scienceleastcutoff2017.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2016-cutoff0" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("scienceleastcutoff2016.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2015-cutoff0" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("scienceleastcutoff2015.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2014-cutoff0" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("scienceleastcutoff2014.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2017-cutoff1" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("scienceleastcutoff2017.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2016-cutoff1" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("arts_commerceleastcutoff2016.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2015-cutoff1" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("arts_commerceleastcutoff2015.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        case "2014-cutoff1" :     LastCutoff.setVisibility(View.INVISIBLE);
                            FirstCutoff.fromAsset("arts_commerceleastcutoff2014.pdf").load();
                            FirstCutoff.setVisibility(View.VISIBLE);

                            break;

                        default:
                            Toast.makeText(Cutoff_list.this, "Error loading pdf in least cutoff", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }

            }
        });


    }

    /*   @Override
       public void onBackPressed() {
           super.onBackPressed();
           FirstCutoff.setVisibility(View.INVISIBLE);
           LastCutoff.setVisibility(View.INVISIBLE);
           Science_Commerce.setVisibility(View.INVISIBLE);
           cutoff_rdbtns2017.setVisibility(View.INVISIBLE);
           listview.setVisibility(View.VISIBLE);
       }
   */
    //Items Selected in Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        if(position==0){
            Flag1=Flag.substring(Flag.length()-1);
            t1 = Toast.makeText(this, "Select Course", Toast.LENGTH_SHORT);
            if(Flag1.equals("0")||Flag1.equals("1"))
                t1.show();
            FirstCutoff.setVisibility(View.INVISIBLE);
            LastCutoff.setVisibility(View.INVISIBLE);
        }
        if(position==1){
            Flag=Flag.substring(0,Flag.length()-1);
            Flag = Flag+"0";
            cutoff_rdbtns2017.setVisibility(View.VISIBLE);


        }

        else if(position==2){

            Flag=Flag.substring(0,Flag.length()-1);
            Flag = Flag+"1";
            cutoff_rdbtns2017.setVisibility(View.VISIBLE);
            test1 = 1;
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
