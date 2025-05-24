package com.example.voltify;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class car_intro extends AppCompatActivity {

    TextView textView;
    private static final int SPLASH_SCREEN_TIME_OUT = 2700; // After completion of 2000 ms, the next activity will get started.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_intro);

        // This method is used so that your splash activity can cover the entire screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(() -> {
            // Intent is used to switch from one activity to another.
            Intent i = new Intent(car_intro.this, MainActivity4.class);
            startActivity(i); // invoke the SecondActivity.
            finish(); // the current activity will get finished.
        }, SPLASH_SCREEN_TIME_OUT);
    }
}