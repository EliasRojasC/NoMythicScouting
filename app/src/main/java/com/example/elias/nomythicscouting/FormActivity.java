package com.example.elias.nomythicscouting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.value;

public class FormActivity extends AppCompatActivity {
    public int teamNum;

    // references to views
    public TextView autoHighShot;
    public TextView autolowShot;
    public TextView teleopHighShot;
    public TextView teleopLowShot;
    public TextView teleopGears;
    public TextView timerCount;

    // references to buttons
    public Button autoHighShotMinus;
    public Button autoHighShotPlus;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        Intent intent = getIntent();

        // Get all referenves to views
        autoHighShot = (TextView) findViewById(R.id.editText2HighGoal);
        autolowShot = (TextView) findViewById(R.id.editTextLowGoal);
        teleopHighShot = (TextView) findViewById(R.id.highCount);
        teleopLowShot = (TextView) findViewById(R.id.lowCount);
        teleopGears = (TextView) findViewById(R.id.gearCount);
        timerCount = (TextView) findViewById(R.id.textView5Timer);

        // Get all referenves to buttons
        autoHighShotMinus = (Button) findViewById(R.id.button2);
        autoHighShotPlus = (Button) findViewById(R.id.button);

        autoHighShot.setText("0");
        autolowShot.setText("0");
        teleopHighShot.setText("0");
        teleopLowShot.setText("0");
        teleopGears.setText("0");
        timerCount.setText("0");


        int recived = intent.getIntExtra("TEAM_NUMBER", 0000);
        final TextView teamNumView = (TextView) findViewById(R.id.teamNumberFormPassthruText);
        teamNumView.setText("" + recived);
    }

    public void setAutoHighShot(View view) {
        // if plus, 1, if minus, -1
        int value;

        int highShotValue = Integer.parseInt(autoHighShot.getText().toString());
        int id = view.getId();

        if (id == findViewById(R.id.button).getId()) value = 1;
        else value = -1;

        if (highShotValue == 0) {
            if (value == 1) {
                autoHighShot.setText("" + (highShotValue + 1));
            }
        } else {
            if (value == 1) {
                autoHighShot.setText("" + (highShotValue + 1));
            } else {
                autoHighShot.setText("" + (highShotValue - 1));
            }

        }
    }
}

