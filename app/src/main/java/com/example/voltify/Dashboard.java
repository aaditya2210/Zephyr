package com.example.voltify;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    ImageButton loginButton;
    ImageButton loginButton2,button2,button3,button4,button5,button6,button7;
    TextView textView,textView2,textView56;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loginButton = findViewById(R.id.loginButton);
        loginButton2 = findViewById(R.id.loginButton2);
        button2 = findViewById(R.id.Button2);
        button3 = findViewById(R.id.Button3);
        button4 = findViewById(R.id.Button4);
        button5 = findViewById(R.id.Button5);
        button6 = findViewById(R.id.Button6);
        button7 = findViewById(R.id.Button7);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(getString(R.string.hello));

        TextPaint paint = textView.getPaint();
        float width = paint.measureText("hello");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
//                        Color.parseColor("#00FFFF"),
                        Color.parseColor("#0000ff"),
                        Color.parseColor("#00FFFF"),
//                        Color.parseColor("#FF0080"),

                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);




        textView2 = (TextView) findViewById(R.id.textView2);
//        textView2.setText(getString(R.string.ryan));

//        TextPaint paint1 = textView2.getPaint();
//        float width1 = paint.measureText("Good");
//
//        Shader textShader1 = new LinearGradient(0, 0, width1, textView2.getTextSize(),
//                new int[]{
//                        Color.parseColor("#0000ff"),
//                        Color.parseColor("#00FFFF"),
////                        Color.parseColor("#FF0080"),
//
//                }, null, Shader.TileMode.CLAMP);
//        textView2.getPaint().setShader(textShader1);

        Intent in = getIntent();
        String str = in.getStringExtra("message_key");
        textView2.setText(str);

//
//
//
//        textView56 = (TextView) findViewById(R.id.textView56);
//        textView56.setText(getString(R.string.wood));
//
//        TextPaint paint2 = textView56.getPaint();
//        float width2 = paint.measureText("wood");
//
//        Shader textShader2 = new LinearGradient(0, 0, width1, textView56.getTextSize(),
//                new int[]{
//                        Color.parseColor("#0000ff"),
//                        Color.parseColor("#00FFFF"),
////                        Color.parseColor("#FF0080"),
//
//                }, null, Shader.TileMode.CLAMP);
//        textView56.getPaint().setShader(textShader2);



        loginButton.setOnClickListener(view -> {


            Intent i = new Intent(Dashboard.this, MainActivity3.class);
            startActivity(i);
        });


        loginButton2.setOnClickListener(view -> {


            Intent i = new Intent(Dashboard.this, MapActivity.class);
            startActivity(i);
        });

        button2.setOnClickListener(view -> {
            Intent i = new Intent(Dashboard.this, Construction.class);
            startActivity(i);
        });

        button3.setOnClickListener(view -> {
            Intent i = new Intent(Dashboard.this, Range_Calc.class);
            startActivity(i);
        });

        button4.setOnClickListener(view -> {
            Intent i = new Intent(Dashboard.this, MainActivity6.class);
            startActivity(i);
        });

        button5.setOnClickListener(view -> {
            Intent i = new Intent(Dashboard.this, Faq.class);
            startActivity(i);
        });

        button6.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            String UriText = "mailto:" + Uri.encode("aadityagandhi2210@gmail.com") +"?subject="+
                    Uri.encode("Feedback") +"$body="+ Uri.encode("");
            Uri uri = Uri.parse(UriText);
            intent.setData(uri);
            startActivity(Intent.createChooser(intent,"send email"));
        });

        button7.setOnClickListener(view -> {
            Intent i = new Intent(Dashboard.this, Construction.class);
            startActivity(i);
        });


//        Intent in = getIntent();
//        // receive the value by getStringExtra() method and
//        // key must be same which is send by first activity
//        String str = in.getStringExtra("message_key");
//        textView2.setText(str);



    }
}