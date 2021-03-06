package com.example.elias.nomythicscouting;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.value;
import static java.util.logging.Logger.global;

public class FormActivity extends AppCompatActivity {
    public int teamNum;

    boolean shouldRun;

    int sliderProgress;

    int value5;

    EditText juice;

    private static final String TAG = "myman";

    float timerCountSeconds = 0;

    private int matchNumber;

    Timer timer = new Timer();
    TimerTask task;

    // references to views
    public TextView autoHighShot;
    public TextView autolowShot;
    public TextView teleopHighShot;
    public TextView teleopLowShot;
    public TextView teleopGears;
    public TextView timerCount;
    public CheckBox gearInAuto;
    public CheckBox didItClimb;
    public TextView loadingUpdate;
    public SeekBar slidervalue;

    // references to buttons
    public Button autoHighShotMinus;
    public Button autoHighShotPlus;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);
        Intent intent = getIntent();

        // Get all referenves to views
        juice = (EditText) findViewById(R.id.comments);
        autoHighShot = (TextView) findViewById(R.id.editText2HighGoal);
        autolowShot = (TextView) findViewById(R.id.editTextLowGoal);
        teleopHighShot = (TextView) findViewById(R.id.highCount);
        teleopLowShot = (TextView) findViewById(R.id.lowCount);
        teleopGears = (TextView) findViewById(R.id.gearCount);
        timerCount = (TextView) findViewById(R.id.textView5Timer);
        gearInAuto = (CheckBox) findViewById(R.id.checkBox);
        didItClimb = (CheckBox) findViewById(R.id.checkBox2);
        loadingUpdate = (TextView) findViewById(R.id.textViewUpdates);
        slidervalue = (SeekBar) findViewById(R.id.seekBar);

        // Get all referenves to buttons
        autoHighShotMinus = (Button) findViewById(R.id.button2);
        autoHighShotPlus = (Button) findViewById(R.id.button);

        autoHighShot.setText("0");
        autolowShot.setText("0");
        teleopHighShot.setText("0");
        teleopLowShot.setText("0");
        teleopGears.setText("0");
        timerCount.setText("0");


        teamNum = intent.getIntExtra("TEAM_NUMBER", 0000);
        final TextView teamNumView = (TextView) findViewById(R.id.teamNumberFormPassthruText);
        teamNumView.setText("" + teamNum);

        matchNumber = intent.getIntExtra("MATCH_NUMBER", 0000);

        slidervalue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                Log.e("SLIDER","Progress: "  + progress);
                sliderProgress = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    public void setAutolowShot(View view){
        int value2;

        int lowShotValue = Integer.parseInt(autolowShot.getText().toString());
        int id = view.getId();

        if (id == findViewById(R.id.button4).getId()) value2 = 1;
        else value2 = -1;

        if (lowShotValue == 0){
            if(value2 == 1){
                autolowShot.setText(""+(lowShotValue + 1));
            }

        } else {
            if (value2 == 1){
                autolowShot.setText("" + (lowShotValue + 1));
            } else {
                autolowShot.setText("" + (lowShotValue - 1));
            }

        }
    }

    public void setTeleopHighShot(View view){
        int value3;

        int teleopHighShotValue = Integer.parseInt(teleopHighShot.getText().toString());
        int id = view.getId();

        if(id == findViewById(R.id.button7SubtractHigh).getId()) value3 = 1;
        else value3 = -1;

        if (teleopHighShotValue == 0){
            if(value3 == 1){
                teleopHighShot.setText(""+(teleopHighShotValue + 1));
            }
        } else {
            if (value3 == 1){
                teleopHighShot.setText("" + (teleopHighShotValue + 1));
            } else {
                teleopHighShot.setText("" + (teleopHighShotValue - 1));
            }
        }
    }

    public void setTeleopLowShot(View view){
        int value4;

        int teleopLowShotValue = Integer.parseInt(teleopLowShot.getText().toString());
        int id = view.getId();

        if(id == findViewById(R.id.button5SubtractLow).getId()) value4 = 1;
        else value4 = -1;

        if (teleopLowShotValue == 0){
            if(value4 == 1){
                teleopLowShot.setText(""+(teleopLowShotValue + 1));
            }
        } else {
            if (value4 == 1){
                teleopLowShot.setText("" + (teleopLowShotValue + 1));
            } else {
                teleopLowShot.setText("" + (teleopLowShotValue - 1));
            }
        }
    }

    public void setTeleopGears(View view){
        int value4;

        int teleopGearsValue = Integer.parseInt(teleopGears.getText().toString());
        int id = view.getId();

        if(id == findViewById(R.id.button10AddGear).getId()) value4 = 1;
        else value4 = -1;

        if (teleopGearsValue == 0){
            if(value4 == 1){
                teleopGears.setText(""+(teleopGearsValue + 1));
            }
        } else {
            if (value4 == 1){
                teleopGears.setText("" + (teleopGearsValue + 1));
            } else {
                teleopGears.setText("" + (teleopGearsValue - 1));
            }
        }
    }
    public void setTimerCount(View view){


        double timerPrint = Float.parseFloat(timerCount.getText().toString());
        int id = view.getId();

        if(id == findViewById(R.id.button6Start).getId()) value5 = 1;
        else if (id == findViewById(R.id.button5Stop).getId()) value5 = 2;
        else value5 = -1;

        if (value5 == 1){
            timer.cancel();
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    timerCountSeconds += 0.1;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String S = "" + (timerCountSeconds);
                            timerCount.setText(String.format("%.1f", timerCountSeconds ));
                        }
                    });

                }
            };
            timer.schedule(task,0,100);
        }
        else if (value5 == 2){
            timer.cancel();

        }
        else{
            timer.cancel();
            timer.purge();
            timerCount.setText("" + 0);
            timerCountSeconds = 0;
        }



    }
    public void startTheThing (View view2){
        ConfirmDialogFragment myman = new ConfirmDialogFragment();
        myman.show(getSupportFragmentManager(), "myMan" );
    }

    public void saveToCSV () {
        final EditText editText3 = (EditText) findViewById(R.id.editTextTeamNumber);
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS),  matchNumber+"_"+teamNum+".csv" );

        FileOutputStream outputStream;
        try {


            outputStream = new FileOutputStream(file);
            outputStream.write(autoHighShot.getText().toString().getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(autolowShot.getText().toString().getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(teleopHighShot.getText().toString().getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(teleopLowShot.getText().toString().getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(teleopGears.getText().toString().getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(timerCount.getText().toString().getBytes());
            outputStream.write(",".getBytes());
             if (gearInAuto.isChecked()){
                 outputStream.write(" true".getBytes());
             }
             else{
                 outputStream.write("false".getBytes());
             }
            outputStream.write(",".getBytes());
             if (didItClimb.isChecked()){
                 outputStream.write(" true".getBytes());
             }
             else{
                 outputStream.write(" false".getBytes());
             }
            outputStream.write(",".getBytes());
             outputStream.write((("" + matchNumber).getBytes()));
            outputStream.write(",".getBytes());
             outputStream.write((""+ teamNum).getBytes());
            outputStream.write(",".getBytes());
             outputStream.write(("" + juice.getText().toString()).getBytes());
            outputStream.write(",".getBytes());
            outputStream.write(("" + sliderProgress).getBytes());

            outputStream.close();

            autoHighShot.setText(""+0);
            autolowShot.setText(""+0);
            teleopHighShot.setText(""+0);
            teleopLowShot.setText(""+0);
            teleopGears.setText(""+0);
            juice.setText("");
                value5 = -1;
            setTimerCount(findViewById(R.id.buttonReset));
            gearInAuto.setChecked(false);
            didItClimb.setChecked(false);

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);


        } catch (Exception e)
        {
            Context context = getApplicationContext();
            CharSequence errorMassage = "you have goofed. ";
            int duration = Toast.LENGTH_SHORT;
            Log.e(TAG,"exeption",e);

            Toast toast = Toast.makeText(context, errorMassage, duration);
            toast.show();
            //todo fix
        }


    }
}





