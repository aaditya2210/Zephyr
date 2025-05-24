package com.example.voltify;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.text.TextPaint;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private static final int SPLASH_SCREEN_TIME_OUT = 2100; // After completion of 2000 ms, the next activity will get started.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText(getString(R.string.zephyr));

        TextPaint paint = textView.getPaint();
        float width = paint.measureText("Zephyr");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#553bdd"),
                        Color.parseColor("#fe2485"),
                        Color.parseColor("#fdd55b"),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);

        // This method is used so that your splash activity can cover the entire screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(() -> {
            // Intent is used to switch from one activity to another.
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i); // invoke the SecondActivity.
            finish(); // the current activity will get finished.
        }, SPLASH_SCREEN_TIME_OUT);
    }
}