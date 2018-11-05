package com.example.omkar.project_du;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class Ug_Admissions extends AppCompatActivity {

    PDFView UgInfo;
    RadioGroup radioGroupUG;
    RadioButton meritbtn,entrancebtn,registrationbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ug__admissions);

        UgInfo = findViewById(R.id.ug_info);
        radioGroupUG = findViewById(R.id.radiogroupUG);
        meritbtn = findViewById(R.id.meritbtn);
        entrancebtn = findViewById(R.id.Entrancebtn);
        registrationbtn = findViewById(R.id.registrationbtn);

        radioGroupUG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd = findViewById(checkedId);
                int Id=rd.getId();

                switch (Id){

                    case R.id.meritbtn          :   UgInfo.fromAsset("ugmeritbased.pdf").load();
                        break;

                    case R.id.Entrancebtn       :   UgInfo.fromAsset("ugentrance.pdf").load();
                        break;

                    case R.id.registrationbtn   :   UgInfo.fromAsset("ugonlineregistration.pdf").load();
                        break;

                    default:
                        Toast.makeText(Ug_Admissions.this, "Error Loading Info", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
