package com.example.elias.nomythicscouting;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView mes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mes = (TextView) findViewById(R.id.textViewUpdates);
        try{
            mes.setText("Creating Files");
            Thread.sleep(2000);
            mes.setText("killing all macs");
            Thread.sleep(2000);
            mes.setText("lets switch it up");
            Thread.sleep(2000);
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

            this.finish();
        }
        catch(Exception e){

        }


    }



    }


