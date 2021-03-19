package com.example.megasuperpuperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static int rndcolor() {
        int color;
        color = (int) (Math.random() * 256);
        return color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button colorButton = (Button) findViewById(R.id.colorButton);
        Button highCalc = (Button) findViewById(R.id.highCalc);
        Intent intent = new Intent(MainActivity.this, HighCalc.class);
        ConstraintLayout backgroundConstraintLayout = (ConstraintLayout) findViewById(R.id.backGround);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    backgroundConstraintLayout.setBackgroundColor(Color.rgb(rndcolor(), rndcolor(), rndcolor()));

                } catch (Exception e) {

                }
            }
        });


        highCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
    }
}