package com.example.voltify;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        username = findViewById(R.id.start);
        password = findViewById(R.id.stop);
        loginButton = findViewById(R.id.Button2);

        textView3 = (TextView) findViewById(R.id.textView7);
        textView3.setText(getString(R.string.plan));

        TextPaint paint = textView3.getPaint();
        float width = paint.measureText("Zephyr");

        Shader textShader = new LinearGradient(0, 0, width, textView3.getTextSize(),
                new int[]{
                        Color.parseColor("#553bdd"),
                        Color.parseColor("#fe2485"),
                        Color.parseColor("#fdd55b"),
                }, null, Shader.TileMode.CLAMP);
        textView3.getPaint().setShader(textShader);




//        loginButton.setOnClickListener(view -> {
//
//                Intent i = new Intent(MainActivity3.this, Construction.class);
//                startActivity(i);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = username.getText().toString();
                String Destination = password.getText().toString();
                if (source.equals("") && Destination.equals("")) {

                    Toast.makeText(MainActivity3.this, "enter both source and destination...", Toast.LENGTH_SHORT).show();
                } else {

                    Uri uri = Uri.parse("https://www.google.com/maps/dir/"+source + "/" + Destination);
                    Intent i = new Intent(Intent.ACTION_VIEW, uri);
                    i.setPackage("com.google.android.apps.maps");
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                }
            }
        });


         
            // invoke the SecondActivity.


    }
}