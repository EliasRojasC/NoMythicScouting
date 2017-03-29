package com.example.elias.nomythicscouting;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FloatingActionButton button = (FloatingActionButton) findViewById(R.id.floatingActionButtonPassThruToForm);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchForm();

            }
        });
    }
    public void launchForm(){
        final EditText editText = (EditText) findViewById(R.id.editTextTeamNumber);
        int teamNumber = Integer.parseInt(editText.getText().toString());
        Intent intent = new Intent(this, FormActivity.class);
        intent.putExtra("TEAM_NUMBER",teamNumber);
        startActivity(intent);
    }
}

