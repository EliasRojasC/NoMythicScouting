package com.example.elias.nomythicscouting;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        final FloatingActionButton button = (FloatingActionButton) findViewById(R.id.floatingActionButtonPassThruToForm);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchForm();

            }
        });
    }
    public void launchForm(){
        final EditText editText = (EditText) findViewById(R.id.editTextTeamNumber);
        if  (editText.getText().toString().isEmpty()){
            Context context = getApplicationContext();
            CharSequence errorMassage = "you have goofed. Please enter a team number";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, errorMassage, duration);
            toast.show();
        } else {
            int teamNumber = Integer.parseInt(editText.getText().toString());
            Intent intent = new Intent(this, FormActivity.class);
            intent.putExtra("TEAM_NUMBER",teamNumber);
            startActivity(intent);
        }
    }
}

