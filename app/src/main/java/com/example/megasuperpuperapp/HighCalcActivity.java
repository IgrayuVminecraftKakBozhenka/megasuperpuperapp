package com.example.megasuperpuperapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Timer;
import java.util.TimerTask;


public class HighCalcActivity extends AppCompatActivity implements View.OnClickListener {

    private Button okButton;
    private Button backButton;
    private ConstraintLayout backGround;
    private EditText highInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_calc);


        okButton = findViewById(R.id.okButton);
        backButton = findViewById(R.id.backButton);
        backGround = findViewById(R.id.backGround);

        highInput = findViewById(R.id.highInput);
        okButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        highInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.postDelayed(()-> showKeyboard(v), 200);
                } else {
                    hideKeyboard(v);
                }
            }
        });
        highInput.requestFocus();
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        backGround.requestFocus();
//    }

    private void hideKeyboard(View v) {
        final InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

    }

    private void showKeyboard(View view) {
        final InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okButton:
                okClick();
                break;
            case R.id.backButton:
                finish();
                break;
        }
    }

    private void okClick() {
        final String userHigh = highInput.getText().toString();
        if (userHigh.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Введите число!", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Ваш рост " + userHigh + " см", Toast.LENGTH_SHORT).show();
            final Intent intent = new Intent();
            intent.putExtra(MainActivity.INTENT_KEY_HEIGHT, userHigh);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}