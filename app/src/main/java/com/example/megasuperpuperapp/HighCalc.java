package com.example.megasuperpuperapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class HighCalc extends AppCompatActivity {
    private TextInputLayout highInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_calc);

        Button okButton = (Button) findViewById(R.id.okButton);
        Button backButton = (Button) findViewById(R.id.backButton);
        Intent intent = new Intent(HighCalc.this, MainActivity.class);
        highInput = findViewById(R.id.userHigh);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userHigh = highInput.getEditText().getText().toString();
                if (validate(userHigh) == true){
                    toaster("Ваш рост: " + userHigh + "см");
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);finish();
            }
        });


    }

    private void toaster(String userHigh) {
        Toast.makeText(this,  userHigh, Toast.LENGTH_SHORT).show();
    }
    private boolean validate(String userHigh) {
        if (userHigh.isEmpty()) {
            toaster("ВВЕДИТЕ ЧИСЛО!!1!!111!!");
            return false;
        } else {
            return true;
        }
    }



}