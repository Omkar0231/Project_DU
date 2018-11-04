package com.example.omkar.project_du;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class DU_Prospectus extends AppCompatActivity {

    PDFView DU_pros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du__prospectus);
        DU_pros = findViewById(R.id.du_prospectus);

        DU_pros.fromAsset("duprospectus.pdf").load();
    }


}
