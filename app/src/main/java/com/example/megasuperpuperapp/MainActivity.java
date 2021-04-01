package com.example.megasuperpuperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public final class MainActivity extends AppCompatActivity {

    public final static String INTENT_KEY_HEIGHT = "intent_key_height";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        

        final Button colorButton = (Button) findViewById(R.id.main_activity_color_button);
        final Button highCalcButton = (Button) findViewById(R.id.main_activity_high_calc_button);
        final ConstraintLayout backgroundConstraintLayout = (ConstraintLayout) findViewById(R.id.backGround);
        final Button toolBarHighCalcButton = findViewById(R.id.toolbar_high_calc_button);

        toolBarHighCalcButton.setOnClickListener(v -> {
            try {
                final Intent intent = new Intent(MainActivity.this, HighCalcActivity.class);
                startActivityForResult(intent, 1);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        colorButton.setOnClickListener(v -> {
            final int red = (int) (Math.random() * 256);
            final int green = (int) (Math.random() * 256);
            final int blue = (int) (Math.random() * 256);
            final int color = Color.rgb(red, green, blue);
            backgroundConstraintLayout.setBackgroundColor(color);
        });

        highCalcButton.setOnClickListener(v -> {
            try {
                final Intent intent = new Intent(MainActivity.this, HighCalcActivity.class);
                startActivityForResult(intent, 1);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        String high = data.getStringExtra(INTENT_KEY_HEIGHT);
        final TextView yourHigh = (TextView) findViewById(R.id.main_activity_your_high);
        yourHigh.setText("Ваш рост " + high);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        openQuitDialog();
//    }

//    private void openQuitDialog() {
//        AlertDialog.Builder quitDialog = new AlertDialog.Builder(CustomViewDemoActivity.this)
//    }
}